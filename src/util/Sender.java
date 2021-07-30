/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Larry Finol
 */
public class Sender {

    public void send(String content, String by, String address) {
        try {
            int puerto;
            if (by.equals("")) {
                puerto = 2120;
            } else {
                puerto = 2021;
            }

            Socket socket = new Socket(address, puerto);

            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            Message message = new Message();
            message.setContent(content);
            message.setBy(by);

            output.writeObject(message);

            socket.close();
            output.close();
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
