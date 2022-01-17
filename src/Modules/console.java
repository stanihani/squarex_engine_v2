package Modules;

import java.util.Scanner;

public class console {

    private static Scanner sc;

    static {
        sc =  new Scanner(System.in);
    }

    // print Method

    // overloaded for different types
    public static void print(int _int){
        System.out.println(_int);
    }

    public static void print(double _double){
        System.out.println(_double);
    }

    public static void print(long _long){
        System.out.println(_long);
    }

    public static void print(String _text){
        System.out.println(_text);
    }


    // getters
    static int getInt(){
        return sc.nextInt();
    }

    static double getDouble(){
        return sc.nextDouble();
    }

    static String getString(){
        return sc.nextLine();
    }

}
