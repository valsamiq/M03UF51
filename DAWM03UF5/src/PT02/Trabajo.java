/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PT02;

/**
 *
 * @author chronos
 */
public class Trabajo {
    private int id;
    private String desc;
    private boolean status;
    private int price; //Part's price in case of Reparation, or Extra in case of Revision

    public Trabajo(int id, String desc, boolean status, int price) {
        this.id = id;
        this.desc = desc;
        this.status = status;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Trabajo{" + "id=" + id + ", desc=" + desc + ", status=" + status + ", price=" + price + '}';
    }
    
}


