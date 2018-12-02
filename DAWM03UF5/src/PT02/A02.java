/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PT02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import PT02.Rep;
import PT02.Rev;

/**
 *
 * @author chronos
 */
public class A02 {
    static ArrayList<Trabajo> trabajos = new ArrayList<>();
    static ArrayList<Rep> reps = new ArrayList<>();
    static ArrayList<Rev> revs = new ArrayList<>();
    // Main
    //--------------------------------------------------------------------------
    public static void main(String[] args){
        boolean bnd; //temporary flag for further uses
        int op;
        do{
            options();
            op = insInt("");
            switch (op){
                case 1:
                    //Register work
                    int op2 = insInt("[0]Repair Work - [1]Revision Work");
                    if(op2==0){
                        int hrs = insInt("Hours of work");
                        int id = trabajos.size();
                        String desc = insStr("Work's description");
                        boolean status = false; //False = Unfinished/True = Finished
                        int parts = insInt("Price of parts");
                        Rep rep = new Rep(hrs, id, desc, status, parts);
                        trabajos.add(rep); reps.add(rep); //temporary solution
                        System.out.println("Work successfully created. with ID: "+rep.getId());
                    }
                    else if(op2==1){
                        int id = trabajos.size();
                        String desc = insStr("Work's description");
                        boolean status = false;
                        int extra = insInt("Price of extras");
                        Rev rev = new Rev(id, desc, status, extra);
                        trabajos.add(rev); revs.add(rev); //temporary solution
                    }else{
                        System.out.println("Option out of range");
                    }
                    System.out.println("Work's Description");
                    break;
                case 2:
                    chgHrs(insInt("Insert a valid Work ID"));
                    //Increase work hours
                    break;
                case 3:
                    chgPrt(insInt("Insert a valid Work ID"));
                    //Increase part price
                    break;
                case 4:
                    finishWork(insInt("Insert a valid Work ID"));
                    //Finish work
                    break;
                case 5:
                    showTotal();
                    //Show work
                    break;
                case 6:
                    System.out.println("Quitting...");
                    break;
                default:
                System.out.println("Outrange option");
            }
        }
        while (op!=6);
    }
    // Methods
    //--------------------------------------------------------------------------
    private static void options(){
        System.out.println("1 - Register new work");
        System.out.println("2 - Increase working hours");
        System.out.println("3 - Increase parts price");
        System.out.println("4 - Finish work");
        System.out.println("5 - Show work");
        System.out.println("6 - Quit");
    }
    private static void finishWork(int id){
        for(Trabajo t : trabajos){
            if(id==(t.getId())){
                System.out.println("Actual Status:");
                if(t.isStatus()){
                    System.out.println("This Work is already finished.");
                }
                else if(!t.isStatus()){
                    System.out.println("Sure you want to finish this work?");
                    int op = insInt("[0]NO / [1]YES");
                    if(op==1){
                        t.setStatus(true);
                        System.out.println("Work "+t.getId()+" successfully finished.");
                    }
                    else if(op==0){
                        System.out.println("Back to menu.");
                    }
                    else{
                        System.out.println("Outrange option");
                    }
                }
            }
        }
    }
    private static void showTotal(){
        //Calculation of total amount of money.
        int id = insInt("Insert a valid Work ID");
        for(Rev t : revs){
            if(id==(t.getId())){
                System.out.println("Type: Revision");
                System.out.println("ID: "+t.getId());
                System.out.println("Description: "+t.getDesc());
                System.out.println("Price: "+t.getPrice());
                //It has an Override on its class wich calculates for me the price.
            }
        }
        for(Rep t : reps){
            if(id==(t.getId())){
                System.out.println("Type: Reparation");
                System.out.println("ID: "+t.getId());
                System.out.println("Description: "+t.getDesc());
                System.out.println("Hours: "+t.getHours());
                System.out.println("Calculing final price...");
                double total;
                int subtotal = (t.getHours()*30) + t.getPrice();
                System.out.println("What kind of intervention is?");
                int op2 = insInt("[0]Mechanical/[1]Bodywork");
                if(op2==0){
                    total = subtotal*1.1;
                    System.out.println("Total Price: "+total);
                }
                else if(op2==1){
                    total = subtotal*1.3;
                    System.out.println("Total Price: "+total);
                }
                else{
                    System.out.println("Outrange option");
                }
                double tot = t.getPrice();
            }
        }
    }
    private static void chgHrs(Integer id){
        boolean bnd = false;
        for(Rep t : reps){
            if(id==(t.getId())){
                System.out.println("Actual hours: "+t.getHours());
                int tmp = t.getHours()+insInt("How many hours do you want to add?");
                t.setHours(tmp);
                System.out.println("Done, increased to "+t.getHours()+" hours");
                bnd=true;
            }
        }
        if(!bnd){
            System.out.println("This ID does not exists.");
        }
    }
    private static void chgPrt(Integer id){
        boolean bnd = false;
        for(Rep t : reps){
            if(id==(t.getId())){
                System.out.println("Actual parts price: "+t.getPrice());
                int tmp = t.getHours()+insInt("How much has increased?");
                t.setPrice(tmp);
                System.out.println("Done, increased to "+t.getPrice());
                bnd=true;
            }
        }
        if(!bnd){
            System.out.println("This ID does not exists.");
        }
    }
    private static String insStr(String input) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = "";
        boolean bnd = true;
        do {
            System.out.println(input);
            System.out.print("  -> ");
            try {
                text = br.readLine();
                if (text.equals("")) {
                    System.out.println("empty value");
                } else {
                    bnd = false;
                }
            } catch (IOException ex) {
                System.out.println("Input/Output Error");
            }
        } while (bnd);
        return text;
    }
    private static int insInt(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int op = 0;
        boolean bnd = true;
        do {
            try {
                System.out.println(mensaje);
                System.out.print("  -> ");
                op = Integer.parseInt(br.readLine());
                bnd = false;
            } catch (IOException ex) {
                System.out.println("Input/Output Error");
            } catch (NumberFormatException ex) { //Format Error
                System.out.println("Integer number requiered");
            }
        } while (bnd == true);
        return op;
    }
    //Unused but interessting.
    private static void waitForIt() throws InterruptedException {
        int seconds = 1;
        int miliseconds = seconds * 1000;
        Thread.sleep(miliseconds);
    }
}

//   (\_(\
// =( °w° )=
//   )   ( //
//  (__ __)/
// balsamiq

