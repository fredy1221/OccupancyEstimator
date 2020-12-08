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
public class MyConditionalProgram {

    public static void main(String[] args) {
        main1(5);
        main2(5);
        main3(5);
        main4();
    }

    public static void main1(int a) {
        if (a > 0) { // a is greater than 0, so this statement will execute
            System.out.println("a is positive");
        } else if (a >= 0) { // a case has already executed, so this statement will NOT execute
            System.out.println("a is positive or zero");
        } else { // a case has already executed, so this statement will NOT execute
            System.out.println("a is negative");
        }
    }

    public static void main2(int ki) {
        String answer = (ki < 0.05) ? "reject" : "keep";
        System.out.println(answer);
    }

    public static void main3(int ki) {
        switch (ki) {
            case 1: // i doesn't equal 1, so this code won't execute
                System.out.println("i equals 1");
                break;
            case 2: // i doesn't equal 2, so this code won't execute
                System.out.println("i equals 2");
                break;
            default: // i has not been handled so far, so this code will execute
                System.out.println("i equals something other than 1 or 2");
        }
        String day = "Monday";
        switch (day) {
            case "Monday": // Since day == "Monday", this statement will execute
                System.out.println("Mondays are the worst!");
                break;
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
                System.out.println("Weekdays are so-so.");
                break;
            case "Friday":
            case "Saturday":
            case "Sunday":
                System.out.println("Weekends are the best!");
                break;
            default:
                throw new IllegalArgumentException("Invalid day of the week: " + day);
        }
    }

    public static void main4() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        for (int i = 1, j = 10;i <= 10;i++, j--){
            System.out.print(i + " ");
            System.out.println(j);
        }
        
        String[] sentence = {"I", "am", "a", "Java", "program."};
        for (String word : sentence) {
            System.out.print(word + " ");
        }
        
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            if (i == 5) {
                System.out.println("STOP!");
                break;
            }
        }
        
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("Caught i == 5");
                continue;
            }
            System.out.println(i);
        }
        
        int i, j;
        int[][] nums = {{1, 2, 5}, {6, 9, 7}, {8, 3, 4}};
        Outer:
        for (i = 0; i < nums.length; i++) {
            for (j = 0; j < nums[i].length; j++) {
                if (nums[i][j] == 9) {
                    System.out.println("Found number 9 at (" + i + ", " + j + ")");
                    break Outer;
                }
            }
        }

    }
}
