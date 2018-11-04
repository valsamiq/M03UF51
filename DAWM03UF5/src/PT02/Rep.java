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
public class Rep extends Trabajo{
    private int hours;

    public Rep(int hours, int id, String desc, boolean status, int price) {
        super(id, desc, status, price);
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Rep{" + "hours=" + hours + '}';
    }
    
}




