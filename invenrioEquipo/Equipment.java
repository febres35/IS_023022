/* 
 * 
 * EJERCICIO 4 B DE LA PRACTICA 7 INGENIERIA DE SOFTWARE
*/

import java.util.Scanner;
//import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Equipment  {
    private String ci;
    private float totalUnitPrice;
    private int totalAmount;
    
    public Equipment(String ci, float totalUnitPrice, int totalAmount){
        this.ci = ci;
        this.totalUnitPrice = totalUnitPrice;
        this.totalAmount = totalAmount;
    }

    public Equipment(){

    }

    // GETTER y SETTER
    String getCi(){
        return this.ci;
    }
    float getTotalUnitPrice(){
        return this.totalUnitPrice;
    }
    int getTotalAmount(){
        return this.totalAmount;
    }
    void setTotalAmount(int totalAmount){
        this.totalAmount = totalAmount;
    }
    void setTotalUnitPrice(float totalUnitPrice){
        this.totalUnitPrice = totalUnitPrice;
    }

    @Override
    public String toString(){
        return (ci + " - " + totalAmount + " - " + totalUnitPrice);

    }

    public static int setEquipmentFile(String desc,int ct, float mu,String nf,String ci){
        try{
            FileWriter file = new FileWriter("inventario.txt", true);
            BufferedWriter buffer =new BufferedWriter(file);
            LocalDate date = LocalDate.now();
            String data = (desc + "#" + ct + "#"+ mu+ "#" +date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear()+ "#" + nf + "#"+ ci+"\n");
            buffer.write(data);
            buffer.close();
            return 0;
        }catch (IOException e){
            e.printStackTrace(System.out);
            return -1;
        }
    }

    public static int equipmentLoadingInterface(){
        Scanner entry = new Scanner(System.in);
        for( int i = 0; i < 3; i++){
            try{
                System.out.println("System of Inventary");
                System.out.print("Description:");
                String desc = entry.next();
                System.out.print("amount:");
                int ct = entry.nextInt();
                System.out.print("unit pirce:");
                float mu = entry.nextFloat();
                System.out.print("invoice #:");
                //entry.next(); // un pass por error despues de nextInt o FLoat
                String ft = entry.next();
                System.out.print("teacherId:");
                String ci = entry.next();
                setEquipmentFile(desc, ct, mu, ft, ci);
                
            }catch( Exception e){
                e.printStackTrace();
                return -1;
            }finally{
                entry.close();
            }
        }
        entry.close();
        
        return 0;
    }
    
    public ArrayList<Equipment> getListOfEquipment() {
        ArrayList<Equipment> list = new ArrayList<Equipment>();
        try{
            FileReader file = new FileReader("inventario.txt");
            BufferedReader buffer = new BufferedReader(file);
            String l = buffer.readLine();
            Equipment register = new Equipment();
            while(true){
                
                if (l == null){break;}
                register = Equipment.getEquipment(l);
                l = buffer.readLine();
                if (isElementOf(list, register)){
                    int i = indexOfEquipment(list, register);
                    if (i >= 0){
                        Equipment temp = list.get(i);
                        temp.setTotalAmount(temp.getTotalAmount() + register.getTotalAmount());
                        temp.setTotalUnitPrice(temp.getTotalUnitPrice() + register.getTotalUnitPrice());
                    }
                }else{
                    list.add(register);
                }
            }
            buffer.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
        return list;
    } 
    private static Equipment getEquipment(String l){
        int i = l.lastIndexOf("#");
        String ci = l.substring(i+1, l.length()); // CI

        i = l.indexOf("#");
        String sub = l.substring(i+1, l.length());// ignore desc
        i = sub.indexOf("#");
        int totalAmount = Integer.parseInt(sub.substring(0, i));
        sub = sub.substring(i+1, sub.length()); // ignore ct
        i = sub.indexOf("#");
        float totalUnitPrice = Float.parseFloat(sub.substring(0, i));
        
        Equipment r = new Equipment(ci, totalUnitPrice, totalAmount);
        return r;
    }

    private static boolean isElementOf(ArrayList<Equipment> list, Equipment element){
        if (!list.isEmpty()){
            for (Equipment l: list){
                if (l.getCi().equals(element.getCi())){
                    return true;
                }
            }
        }
        
        return false;
    }

    private static int indexOfEquipment(ArrayList<Equipment> list, Equipment element){
        for (Equipment l: list){
            if (l.getCi().equals(element.getCi())){
                return list.indexOf(l);
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {

        ArrayList<Equipment> lista = new ArrayList<>();
        //equipmentLoadingInterface();
        Equipment e = new Equipment();
        lista = e.getListOfEquipment();
        System.out.println(lista);
    }
}


