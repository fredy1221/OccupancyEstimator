/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ense3;

import java.util.*;

/**
 *
 * @author chemalif
 */
public class MapExample {

    public static void main(String args[]) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing"
                + " elit, sed du eiusmod tempor incididunt ut labore et"
                + " dolore magna aliqua. Ut enim ad minim veniam, quis"
                + " nostrud exercitation ullamco labori nisi ut aliquip"
                + " ex ea commodo consequat. Duis aute irure dolor in"
                + " reprehenderit in voluptate velit esse cillum dolore"
                + " eu fugiat nulla pariatur. Excepteur sint occaecat"
                + " cupidatat non proident, sunt in culpa qui officia"
                + " deserunt mollit anim id est laborum";
        String[] words = text.split("[\\s|\\.|,]"); //regular expression
// for splitting at a space, a dot or a comma.
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0, n = words.length; i < n; i++) {
            String word = words[i];
            if (word.length() > 0) {
                int frequency = 1;
                if (!map.containsKey(word)) {
                    frequency = 1;
                } else {
                    frequency = map.get(word) + 1;
                }
                map.put(word, frequency);
            }
        }
        System.out.println(map);
        TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(map);
        System.out.println(sortedMap);
    }
}
