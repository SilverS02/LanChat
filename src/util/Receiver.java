/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Larry Finol
 */
public class Receiver extends Thread {

    ServerSocket serverSocket;
    
    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(2120);
            
            while (true) {
                Socket socket = serverSocket.accept();
                DataInputStream message = new DataInputStream(socket.getInputStream());

                socket.close();
                message.close();
            }
        } catch (IOException ex) {
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
