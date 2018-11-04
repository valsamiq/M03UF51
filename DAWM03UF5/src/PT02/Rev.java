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
public class Rev extends Trabajo{

    public Rev(int id, String desc, boolean status, int price) {
        super(id, desc, status, price);
    }

    @Override
    public void setPrice(int price) {
        super.setPrice(price+20);
        //To change body of generated methods, choose Tools | Templates.
    }
    
}


