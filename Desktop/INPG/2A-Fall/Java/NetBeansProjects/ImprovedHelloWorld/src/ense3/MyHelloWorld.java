/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ense3;

/**
 *
 * @author chemalif
 */
public class MyHelloWorld {

    public static void main(String[] args) {
        int value = 1;
        int[] array = {1,2,3,4};
        display(value, array);
        display(value, array);
        stringLen();
        funTrueFalse();
    }
    
    public static void display(int aValue, int[] anArray) {
        aValue = aValue + 1;
        anArray[0] = anArray[0] + 1;
        System.out.println("i: " + aValue);
        System.out.println("array: ");
        for(int i=0; i<anArray.length; i++)
            System.out.print(anArray[i] + " ");
        System.out.println();
        
        String string1 = "My name is ";
        String string2 = "Jean";
        String string3 = string1.concat(string2);
        String string4 = string1 + string2;
        System.out.println(string4);
    }
    
    public static void stringLen() {
        String palindrome = "Dot saw I was Tod";
        int len = palindrome.length();
        System.out.println( "String Length is : " + len );
    }
    public static void funTrueFalse() {
        int a = 5, b = 3;
        System.out.println(a > b); // Value is true because a is greater than b
        System.out.println(a == b); // Value is false because a does not equal b
    }
  }




