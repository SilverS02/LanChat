/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import gui.Home;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Larry Finol
 */
public class ReceiverClient extends Thread {

    private ServerSocket serverSocket;
    private Home home;

    public ReceiverClient(Home home) {
        this.home = home;
    }

    // Este es el Receptor que va a Correr en los Clientes (Usuarios).
    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(2120);

            // Ponemos a la constante escucha al Emisor.
            while (true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

                Message message = (Message) input.readObject();

                // Comprobamos si lo recibido es un nuevo mesanje o una nueva conexion.
                if (message.getNewMessage()) {
                    home.updateChatArea(message.getContent());
                    MessageSaves.Serialize(home.getChatArea(), message.getToName(), message.getBy());
                } else if (message.getNewConnection()) {
                    // Comprobamos si la nueva conexion desea cambiarle el nombre al usuario o actualizar la listas de ellos.
                    if (message.getNewUserName()) {
                        home.setUserName(message.getToName());
                    } else {
                        home.updateUsersList(message.getUsersList());
                    }
                }

                socket.close();
                input.close();
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    public void finish() {
        try {
            serverSocket.close();
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
