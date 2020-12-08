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
public class StringTest {

    public static void main(String[] args) {
        String greeting = new String("Hello World!");
        if (greeting == "Hello World!") { //e ‘==’ checks to see whether objects are same i.e. in the same position in memory
            System.out.println("Match found.");
        } else {
            System.out.println("Match not found.");
        }
        if (greeting.equals("Hello World!")) { //The ‘equals’ test compares the actual content of strings.
            System.out.println("Match found.");
        } else {
            System.out.println("Match not found.");
        }
    }
    
// The difference between the ‘==’ and ‘equals’ comparisons is that the ‘==’ checks
//to see whether objects are same i.e. in the same position in memory (similarly to
//C, pointing to the same object). The ‘equals’ test compares the actual content of
//strings.

}
