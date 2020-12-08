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
public class Set {

    static public void main(String[] args) {
        HashSet<String> set = new HashSet<String>();
        set.add("Bernard");
        set.add("Elisabeth");
        set.add("Renée");
        set.add("Elisabeth");
        set.add("Clara");
        System.out.println(set);
        TreeSet<String> sortedSet = new TreeSet<String>(set);
        System.out.println(sortedSet);
    }

}
