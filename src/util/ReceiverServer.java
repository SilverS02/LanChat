/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 *
 * @author Larry Finol
 */
public class ReceiverServer extends Thread {

    private ServerSocket serverSocket;
    private HashMap<String, String> usersList;

    // Este es el Receptor que va a Correr en los Clientes (Usuarios).
    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(2021);
            Sender sender = new Sender();
            usersList = new HashMap<String, String>();

            // Ponemos a la constante escucha al Emisor.
            while (true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

                Message message = (Message) input.readObject();

                // Comprobamos si lo recibido es un nuevo mensaje, una nueva conexion o una desconexion.
                if (message.getNewMessage()) {
                    sender.resend(message);
                } else if (message.getNewConnection()) {
                    // Comprobamos si ya hay otros usuarios con este nombre.
                    int count = checkUserName(message.getBy());
                    if (count > 1) {
                        message.setBy(message.getBy() + " " + count);
                        sender.sendNewName(socket.getInetAddress().getHostAddress(), message.getBy());
                    }

                    // Actualizamos la lista de Usuarios Conectados.
                    usersList.put(socket.getInetAddress().getHostAddress(), message.getBy());
                    for (String ip : usersList.keySet()) {
                        sender.sendUsersList(ip, usersList);
                    }
                } else {
                    // Eliminamos un Usuario de la Lista de Conectados y la Actualizamos
                    usersList.remove(socket.getInetAddress().getHostAddress());
                    for (String ip : usersList.keySet()) {
                        sender.sendUsersList(ip, usersList);
                    }
                }

                socket.close();
                input.close();
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    private int checkUserName(String userName) {
        int count = 0;
        Boolean exists;

        do {
            count++;
            exists = false;

            for (String name : usersList.values()) {
                if (count != 1) {
                    if (name.equals(userName + " " + count)) {
                        exists = true;
                    }
                } else {
                    if (name.equals(userName)) {
                        exists = true;
                    }
                }
            }
        } while (exists);

        return count;
    }

    public void finish() {
        try {
            serverSocket.close();
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
