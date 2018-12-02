/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PT01;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author chronos
 */
public class A01 {
    public static HashMap<Integer, Producto> mapProd = new HashMap<>();    
    //se que debería haver puesto Producto y luego Integer, pero me he dado cuenta
    //ya con el programa avanzado y no lo he tocado, per lo que la cantidad, la he 
    //puesto como ppropiedad
    
    
    public static void main(String[] args){
    // Main
    //--------------------------------------------------------------------------
    //HashMap<Integer, Producto> mapProd = new HashMap<>();
     
        System.out.println("Adding products to the HashMap...");
        Producto p1 = new Producto("Hacha", 50, 12);
        addProd(p1);
        Producto p2 = new Producto("Sierra", 30, 15);
        addProd(p2);
        Producto p3 = new Producto("Cadena", 10, 8);
        addProd(p3);
        Producto p4 = new Producto("Camisa Lenador", 50, 4);
        addProd(p4);
        Producto p42 = new Producto("Camisa Lenador", 50, 4); //just to check if it detects duplied items.
        addProd(p42);
        Producto p5 = new Producto("Pala", 50, 10);
        addProd(p5);
        Producto p6 = new Producto("Espectrometo Orbital de Masas", 85000, 2);
        addProd(p6);
        
        System.out.println("Products added: "+mapProd.size());
        System.out.println("Done.");
        
        System.out.println("Deleting by NAME item 'Sierra'...");
        delProd("Sierra");
        System.out.println("Done.");
        
        System.out.println("Pala's changes its price to 85...");
        modProd("Pala");
        
        System.out.println("Deleting all Products...");
        aTomarPolCuloTodo();
        System.out.println("Done");
        
    // Methods
    //--------------------------------------------------------------------------
    
    }
    private static void addProd(Producto p){ //Add the given Product as a object into the HashMap
        System.out.println("Adding "+p.getName()+", price: "+p.getPvp()+", quantity: "+p.getQty()+", Hash: "+p.hashCode());
        if(checkProd(p)){
            System.out.println("This product already exists.");
        }
        else{
            mapProd.put((mapProd.size()+1), new Producto(p.getName(),p.getPvp(),p.getQty()));
            System.out.println("Done.");
        }
    }
    
    private static void delProd(String name){ //Delete the given Product from the HashMap
        Producto p = getProdByName(name);
        mapProd.remove(p);
    }
    
    private static Producto getProdByName(String name){
        for(Map.Entry<Integer,Producto> entry:mapProd.entrySet()){
            if(entry.getValue().getName().equals(name)){
                    Producto p = new Producto(entry.getValue().getName(), entry.getValue().getPvp(), entry.getValue().getQty());
                return p;
            }
        }
        return null;
    }
    
    private static void modProd(String name){
        System.out.println("Old price: "+mapProd.get(5).getPvp());
        mapProd.put(5, new Producto(mapProd.get(5).getName(), 85,mapProd.get(5).getQty()));
        System.out.println("New price: "+mapProd.get(5).getPvp());
    }
    
    private static boolean checkProd(Producto p1){
        Producto p2 = getProdByName(p1.getName());
        if(p2!=null){
            if(p1.hashCode()==p2.hashCode()){
                return true;
            }
        }
        return false;
    }
    private static void aTomarPolCuloTodo(){
        mapProd.clear();
    }
}

//   (\_(\
// =( °w° )=
//   )   ( //
//  (__ __)/
// balsamiq

