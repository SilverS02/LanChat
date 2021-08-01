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

    private String content, by, toIp, toName;
    private HashMap<String, String> usersList;
    private Boolean newConnection, newName;

    public Message() {
        content = "";
        by = "";
        toIp = "";
        toName = "";
        usersList = new HashMap<String, String>();
        newConnection = false;
        newName = false;
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

    public void setNewConnection(Boolean newConnection) {
        this.newConnection = newConnection;
    }

    public Boolean getNewConnection() {
        return newConnection;
    }

    public void setNewName(Boolean newName) {
        this.newName = newName;
    }

    public Boolean setNewName() {
        return newName;
    }
}
