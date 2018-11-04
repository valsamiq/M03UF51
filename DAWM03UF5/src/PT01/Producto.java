/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PT01;

import java.util.Objects;

/**
 *
 * @author chronos
 */
public class Producto {
    private String name;
    private int pvp;
    private int qty;

    public Producto(String name, int pvp, int qty) {
        this.name = name;
        this.pvp = pvp;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPvp() {
        return pvp;
    }

    public void setPvp(int pvp) {
        this.pvp = pvp;
    }
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Producto{" + "Name: " + name + ", Pvp: " + pvp + ", Quantity: " + qty + '}';
    }

    @Override
    public int hashCode() {
        int hash = this.pvp;
        hash = hash + Objects.hashCode(this.name);
        return hash;
    }       

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o==null){
            return false;
        }
        final Producto other = (Producto) o;
        if (!Objects.equals(this.name, other.name)&&!Objects.equals(this.pvp, other.pvp)) {
            return false;
        }
        return true;
    }
    
}


