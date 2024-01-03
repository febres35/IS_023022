import java.util.*;
//import java.util.Scanner;
//import java.util.Random;
public class ejercicio4 {   
    
    private static boolean isElementOf( int[] list, int var){
        for (int i = 0; i < list.length; i++){
            if (list[i] == var){
                return true;
            }
        }
        return false;
    } 
    private static boolean theWholeNumberIs_loopFor( int[] list, int var){
        for (int i = 0; i < list.length; i++){
            if (list[i] == var){
                return true;
            }
        }
        return false;
    }

    private static boolean theWholeNumberIs_loopWhile( int[] list, int var){
        int cont = 0;
        while(cont < list.length){
            if (list[cont] == var){

                return true;
            }
            cont++;
        }
        return false;

    } 

    private static int fibonacciSequence(int var ){
        int a=0, b=1;
        for (int i = 0; i <= var; i++){
            System.out.println(a);
            a=b;
            b+=a;   
        }
        return b;
    } 

    private static void initArray(int[] X){
        Random random = new Random();
        for (int i = 0; i < X.length; i++){
            X[i] = random.nextInt(100);
        }
    }
    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);
        System.out.print("indicate the size of array: ");
        int len = entry.nextInt();
        
        try{
            int[] list = new int[len];
            initArray(list);
            System.out.print("Search integer: ");
            int var = entry.nextInt();
            boolean exists = isElementOf(list, var);
            entry.close();
            for (int x: list){
                System.out.print(x + ", ");
            }
            System.out.println(" ");
            if (exists){
                System.out.println("El numero " + var + " Existe en el arreglo de enteros.");
            }else{
                System.out.println("El numero " + var + " No existe en el arreglo de enteros.");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }finally{
            entry.close();
        }


    }
}
