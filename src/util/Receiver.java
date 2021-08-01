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
import java.util.HashMap;

/**
 *
 * @author Larry Finol
 */
public class Receiver extends Thread {

    private Boolean isClient;
    private ServerSocket serverSocket;
    private HashMap<String, String> usersList;
    private Home home;

    public Receiver(Boolean isClient) {
        this.isClient = isClient;
        usersList = new HashMap<String, String>();
    }

    public void setHome(Home home) {
        this.home = home;
    }

    @Override
    public void run() {
        int port = isClient == true ? 2120 : 2021;

        try {
            serverSocket = new ServerSocket(port);
            Socket socket;
            Sender sender = new Sender();

            while (true) {
                socket = serverSocket.accept();
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

                Message message = (Message) input.readObject();

                if (isClient) {
                    if (!message.getNewConnection()) {
                        home.updateChatArea(message.getContent());
                        MessageSaves.Serialize(home.getChatArea(), message.getToName(), message.getBy());
                    } else {
                        if (!message.setNewName()) {
                            home.updateUsersList(message.getUsersList());
                        } else {
                            home.setName(message.getToName());
                        }
                    }
                } else {
                    if (!message.getNewConnection()) {
                        sender.resend(message);
                    } else {
                        int count = 0;
                        Boolean exists;
                        do {
                            count++;
                            exists = false;
                            for (String name : usersList.values()) {
                                if (count != 1) {
                                    if (name.equals(message.getBy() + " " + count)) {
                                        exists = true;
                                    }
                                } else {
                                    if (name.equals(message.getBy())) {
                                        exists = true;
                                    }
                                }
                            }
                        } while (exists);
                        if (count != 1) {
                            message.setBy(message.getBy() + " " + count);
                            sender.sendNewName(socket.getInetAddress().getHostAddress(), message.getBy());
                        }
                        usersList.put(socket.getInetAddress().getHostAddress(), message.getBy());
                        for (String ip : usersList.keySet()) {
                            sender.sendUsersList(ip, usersList);
                        }
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
