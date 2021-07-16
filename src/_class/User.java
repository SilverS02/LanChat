/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _class;

import java.io.Serializable;

/**
 *
 * @author Larry Finol
 */
public class User implements Serializable{

    private String name, ip;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setIP(String ip) {
        this.ip = ip;
    }

    public String getIP() {
        return this.ip;
    }
}
