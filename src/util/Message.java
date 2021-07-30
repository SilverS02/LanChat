/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author Larry Finol
 */
public class Message implements Serializable {

    private String content, by, toIp, toName;
    
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

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
