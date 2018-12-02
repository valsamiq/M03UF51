/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PT04;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chronos
 */
public class A04 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        Empleado e1 = new Empleado("Adolfo", 49, 2600);
        Empleado e2 = new Empleado("Yoseph", 52, 1300);
        Empleado e3 = new Empleado("Mao",94,1600);
        Empleado e4 = new Empleado("Benito", 45, 3200);
        File empleados = new File("empleados");
        
        //Write object:
        ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(empleados));
        
        //Read object:
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(empleados));
        
        //fill ArrayList...
        List<Empleado> lista = new ArrayList();
        lista.add(e1);
        lista.add(e2);
        lista.add(e3);
        lista.add(e4);
        
        //Write array and close...
        oos.writeObject(lista);
        oos.close();
        
        //Recupero el array con todos los videojuegos
        List<Empleado> lecturaLista = new ArrayList();
        lecturaLista = (List<Empleado>) ois.readObject();
        
        ois.close();
        
        for (Empleado v : lecturaLista) {
            System.out.println(v);
        }
        //save and close...
        XMLEncoder xmlEn = new XMLEncoder(new FileOutputStream(new File("empleadosXML.xml")));
        xmlEn.writeObject(lista);
        xmlEn.close();

        XMLDecoder xmlDe = new XMLDecoder(new BufferedInputStream(new FileInputStream("empleadosXML.xml")));

        List<Empleado> listaXML = (List<Empleado>) xmlDe.readObject();
        xmlDe.close();

        for (Empleado e : listaXML) {
            System.out.println(e);
        }
    }
}

//   (\_(\
// =( °w° )=
//   )   ( //
//  (__ __)/
// balsamiq

