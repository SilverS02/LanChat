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

/**
 *
 * @author Larry Finol
 */
public class Receiver extends Thread {

    private ServerSocket serverSocket;
    private Boolean isClient;

    public Receiver(Boolean isClient) {
        this.isClient = isClient;
    }

    @Override
    public void run() {
        try {
            int puerto;
            if (isClient) { 
                puerto = 2120;
            } else {
                puerto = 2021;
            }

            serverSocket = new ServerSocket(puerto);

            while (true) {
                Socket socket = serverSocket.accept();

                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) input.readObject();

                if (!isClient) {
                    Sender sender = new Sender();
                    sender.send(message.getContent(),message.getBy(), "", message.getToName(), message.getToIp());
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
