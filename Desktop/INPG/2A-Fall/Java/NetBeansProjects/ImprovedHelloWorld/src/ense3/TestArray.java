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
public class TestArray {

    public static void main(String[] args) {
        //main1();
        //main2();
        main3();
    }
    public static void main1(){
        double[] myList = {1.9, 2.9, 3.4, 3.5};
// Print all the array elements
        for (int i = 0; i < myList.length; i++) {
            System.out.println(myList[i] + " ");
        }
// Summing all elements
        double total = 0;
        for (int i = 0; i < myList.length; i++) {
            total += myList[i];
        }
        System.out.println("Total is " + total);
// Finding the largest element
        double max = myList[0];
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max) {
                max = myList[i];
            }
        }
        System.out.println("Max is " + max);
    }
    
    public static void main2() {
        double[] myList = {1.9, 2.9, 3.4, 3.5};
        double[] anotherArray = new double[5];
// Print all the array elements
        for (double element : myList) {
            System.out.println(element);
        }
    }
    
    public static void main3(){
        String[][] twoDimArray = {{"a", "b", "c", "d", "e"},
                                    {"f", "g", "h", "i", "j"},
                                    {"k", "l", "m", "n", "o"}};
        int[][] twoDimIntArray = {{ 0, 1, 2, 3, 4},
                                    {10, 11, 12, 13, 14},
                                    {20, 21, 22, 23, 24}};
        String[] oneDimArray = {"00", "01", "02", "03", "04"};
        String[][] twoDimArray2 = {oneDimArray,
                                    {"10", "11", "12", "13", "14"},
                                    {"20", "21", "22", "23", "24"}};
        String[][] weirdTwoDimArray = {{"10", "11", "12"},
                                        null,
                                        {"20", "21", "22", "23", "24"}};
        System.out.println(weirdTwoDimArray[1]);
    }
}
