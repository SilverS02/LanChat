/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Larry Finol
 */
public class Sender {

    // ---------- Enviar Mensaje al Servidor ----------
    public void sendMessage(String content, String by, String toIp, String toName, String server) {
        try {
            Socket socket = new Socket(server, 2021);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            Message message = new Message();
            message.setNewMessage(true);
            message.setContent(content);
            message.setBy(by);
            message.setToIp(toIp);
            message.setToName(toName);

            output.writeObject(message);

            socket.close();
            output.close();
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    // ---------- Reenviar Mensaje al Cliente ----------
    public void resend(Message message) {
        try {
            Socket socket = new Socket(message.getToIp(), 2120);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            output.writeObject(message);

            socket.close();
            output.close();
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    // ---------- Enviar Conexion al Servidor ----------
    public void sendConnection(String server, String name) {
        try {
            Socket socket = new Socket(server, 2021);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            Message message = new Message();
            message.setNewConnection(true);
            message.setBy(name);

            output.writeObject(message);

            socket.close();
            output.close();
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    // ---------- Enviar nuevo Nombre al Cliente ----------
    public void sendNewName(String client, String newName) {
        try {
            Socket socket = new Socket(client, 2120);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            Message message = new Message();
            message.setNewConnection(true);
            message.setNewUserName(true);
            message.setToName(newName);

            output.writeObject(message);

            socket.close();
            output.close();
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    // ---------- Enviar Lista de Usuarios Conectados al Cliente ----------
    public void sendUsersList(String client, HashMap<String, String> usersList) {
        try {
            Socket socket = new Socket(client, 2120);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            Message message = new Message();
            message.setNewConnection(true);
            message.setUsersList(usersList);

            output.writeObject(message);

            socket.close();
            output.close();
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    // ---------- Enviar Desconexi??n al Servidor ----------
    public void sendDisconnection(String servidor) {
        try {
            Socket socket = new Socket(servidor, 2021);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            Message message = new Message();

            output.writeObject(message);

            socket.close();
            output.close();
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    // ---------- Enviar Desconexion a los Clientes ----------
    public void sendCloseServer(String client) {
        Socket socket;
        try {
            socket = new Socket(client, 2120);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            Message message = new Message();

            output.writeObject(message);

            socket.close();
            output.close();
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }

    }
}
