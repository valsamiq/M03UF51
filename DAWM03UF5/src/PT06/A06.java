/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PT06;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chronos
 */
public class A06 {
    String currentUser="USER"; //Temporary solution
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Frame0 frame0 = new Frame0();
        frame0.setLocationRelativeTo(null);
        frame0.setVisible(true);
        /*
        //Para evitar problemas de lectura, hago escrivir a él mismo el registro de usuarios, así si hay algo mal, es cosa suya.
        User usu = new User("USER", "134");
        File users = new File("users");
        //Write object:
        ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(users));
        //Read object:
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(users));
        //fill ArrayList...
        List<User> lista = new ArrayList();
        lista.add(usu);
        //Write array and close...
        oos.writeObject(lista);
        oos.close();
        
        //Recupero el array con todos los Users
        List<User> lecturaLista = new ArrayList();
        lecturaLista = (List<User>) ois.readObject();
        ois.close();
        
        for (User u : lecturaLista) {
            System.out.println(u);
        }
        //save and close...
        XMLEncoder xmlEn = new XMLEncoder(new FileOutputStream(new File("usersXML.xml")));
        xmlEn.writeObject(lista);
        xmlEn.close();

        XMLDecoder xmlDe = new XMLDecoder(new BufferedInputStream(new FileInputStream("usersXML.xml")));
        
        List<User> listaXML = (List<User>) xmlDe.readObject();
        xmlDe.close();
*/
    }
    public String currentUser(){
        return currentUser;
    }
}












