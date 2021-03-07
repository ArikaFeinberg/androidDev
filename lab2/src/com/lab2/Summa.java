package com.lab2;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Summa {
    //int a;
    //int b;
    public static void func1(){
        System.out.println("We will add two numbers a = 5 and b = 8, using Goldberg's machine, which means using as many instruments as possible");

        System.out.println("1. Multiplication, Division, Adding and Subtraction");
        int a = 5;
        int b = 8;
        int c = (a + 10 - 8)*10/5;
        int d = (b + 27 - 3)*15/3;
        System.out.println("("+a + " + 10 - 8)*10/5 = "+ c);
        System.out.println("("+b + " + 27 - 3)*15/3 = " + d);
        func2(c, d);
    }

    public static void func2(int a, int b){
        System.out.println("2. Transformation into string");
        String A = String.valueOf(a);
        String B = String.valueOf(b);
        System.out.println("Strings: ");
        System.out.println("a -> "+A+ " b -> "+B);
        func3(A, B);
    }

    public static void func3(String a, String b){
        System.out.println("3. Transformation into bytes ");
        byte[] byteArrayA = a.getBytes();
        byte[] byteArrayB = b.getBytes();
        System.out.println("a -> "+Arrays.toString(byteArrayA));
        System.out.println("b -> "+Arrays.toString(byteArrayB));
        //String s = new String(byteArrayA, StandardCharsets.UTF_8);
        //System.out.println("String s -> "+s);
        func4(byteArrayA, byteArrayB);

    }

    public static void func4 (byte[] a, byte [] b){
        System.out.println("4. Adding to a list and converting to a hash map: ");
        List<byte[]> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        System.out.println("List: ");
        for(int i = 0; i < list.size(); i++){
            System.out.println(Arrays.toString(list.get(i)));
        }
        Map<Integer, byte[]> map = new HashMap<>();
        map.put(0, list.get(0));
        map.put(1, list.get(1));
        System.out.println("Hash map: ");
        for (int i = 0; i<map.size(); i++){
            System.out.println(Arrays.toString(map.get(i)));
        }
        func5(map);
    }

    public static void func5(Map<Integer, byte[]> map){
        System.out.println("5. Writing map parameters to a file ");
        try(FileWriter writer = new FileWriter("lab2.txt", false)){
            StringBuilder text = new StringBuilder();
            for(int i = 0; i<map.size(); i++){
                text.append(Arrays.toString(map.get(i)));
            }
            System.out.println(text);
            //String text = Arrays.toString(map)
            writer.write(String.valueOf(text));
            writer.flush();

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        func6();
    }

    public static void func6(){
        System.out.println("6. Reading from file to String builder: ");
        StringBuilder stringBuilder = new StringBuilder();
        try(FileInputStream fin = new FileInputStream("lab2.txt")){
            System.out.println("File size: " + fin.available());
            int i;
            while ((i= fin.read())!=-1){
                //System.out.print((char) i);
                stringBuilder.append((char) i);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("String builder: "+stringBuilder.toString());
        func7(stringBuilder);
    }
    public static void func7(StringBuilder stringBuilder){
        System.out.println("7. Splitting String builder into byteArrays and turning it to an integer: ");
       /* System.out.println(stringBuilder.substring(1, 3));
        System.out.println(stringBuilder.substring(5, 7));
        System.out.println(stringBuilder.substring(9, 11));
        System.out.println(stringBuilder.substring(13, 15));
        System.out.println(stringBuilder.substring(17, 19));
        int a = Integer.parseInt(stringBuilder.substring(1, 3));
        int b = Integer.parseInt(stringBuilder.substring(5, 7));
        System.out.println("a =  " + a);
        System.out.println("b = "+b);

        */
        byte[] bytesA = {(byte)Integer.parseInt(stringBuilder.substring(1, 3)), (byte)Integer.parseInt(stringBuilder.substring(5, 7))};
        byte[] bytesB = {(byte)Integer.parseInt(stringBuilder.substring(9,11)), (byte)Integer.parseInt(stringBuilder.substring(13,15)), (byte)Integer.parseInt(stringBuilder.substring(17,19)) };
        System.out.println("Bytes a : "+Arrays.toString(bytesA));
        System.out.println("Bytes b : "+ Arrays.toString(bytesB));
        String a = new String(bytesA, StandardCharsets.UTF_8);
        String b = new String(bytesB, StandardCharsets.UTF_8);
        System.out.println("String a = "+a);
        System.out.println("String b = "+ b);
        func8(a, b);
    }

    public static void func8(String a, String b){
        System.out.println("8. Final transformations: ");
        int A = Integer.parseInt(a);
        int B = Integer.parseInt(b);
        System.out.println("A = " + A+ " B  = "+ B);
        int finalA = A - 9;
        int finalB = B - 152;
        System.out.println("final summa = "+finalA+finalB);
    }

}


