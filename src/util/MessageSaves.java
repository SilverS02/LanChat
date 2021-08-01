/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.*;

/**
 *
 * @author Alejandro
 */
public class MessageSaves {
    
    public static void Serialize(String content, String by, String to){
        String messagelist = "";
        /*try{
            ObjectInputStream messageFileIn = new ObjectInputStream(new FileInputStream(by+"-"+to));
            messagelist = (String) messageFileIn.readObject();;
            messageFileIn.close();
        } catch (Exception ex){
            System.out.println("Arhivo inexistente");
        }*/
        
        try {
            messagelist = content;
            ObjectOutputStream messageFile = new ObjectOutputStream(new FileOutputStream(by+"-"+to));
            messageFile.writeObject(messagelist);
            messageFile.close();
        } catch (Exception ex){
            System.err.println("Error: " + ex.getMessage());
        }
    }
    
    public static String Deserialize(String by, String to){
        String messageList = "";
        try{
            ObjectInputStream messageFileIn = new ObjectInputStream(new FileInputStream(by+"-"+to));
            messageList = (String) messageFileIn.readObject();
            messageFileIn.close();
            
            return messageList;
        } catch (Exception ex){
            return messageList;
        }
    }
}
