/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Larry Finol
 */
public class Message implements Serializable {

    private Boolean newMessage, newConnection, newUserName;
    private String content, by, toIp, toName;
    private HashMap<String, String> usersList;

    public Message() {
        newMessage = false;
        newConnection = false;
        newUserName = false;
        content = "";
        by = "";
        toIp = "";
        toName = "";
        usersList = new HashMap<String, String>();
    }

    // ---------- Setter y Getter de newMessage ----------
    // ---------- Establece un valor a newMessage ----------
    public void setNewMessage(Boolean newMessage) {
        this.newMessage = newMessage;
    }

    // ---------- Desvuelve el valor de newMessage ----------
    public Boolean getNewMessage() {
        return newMessage;
    }

    // ---------- Setter y Getter de newConnection ----------
    // ---------- Establece un valor a newConnection ----------
    public void setNewConnection(Boolean newConnection) {
        this.newConnection = newConnection;
    }

    // ---------- Desvuelve el valor de newConnection ----------
    public Boolean getNewConnection() {
        return newConnection;
    }

    // ---------- Setter y Getter de newUserName ----------
    // ---------- Establece un valor a newUserName ----------
    public void setNewUserName(Boolean newUserName) {
        this.newUserName = newUserName;
    }

    // ---------- Desvuelve el valor de newUserName ----------
    public Boolean getNewUserName() {
        return newUserName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    public void setToIp(String toIp) {
        this.toIp = toIp;
    }

    public String getToIp() {
        return toIp;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getToName() {
        return toName;
    }

    public void setUsersList(HashMap<String, String> usersList) {
        this.usersList = usersList;
    }

    public HashMap<String, String> getUsersList() {
        return usersList;
    }
}
