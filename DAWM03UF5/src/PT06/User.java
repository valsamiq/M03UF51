/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PT06;

import java.io.Serializable;

/**
 *
 * @author chronos
 */
public class User implements Serializable{
    private String name;
    private String pass;

    public User() {}

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", pass=" + pass + '}';
    }
    
    
}



