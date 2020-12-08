/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ense3;

import java.util.ArrayList;

/**
 *
 * @author chemalif
 */
public class DynamicArray {

    public static void main(String[] args) {
        ArrayList dynamicSerie = new ArrayList();
        double[] staticSerie = {1.3, 2.1, 4.5, 3.2};
        for (double value : staticSerie) {
            dynamicSerie.add(value);
        }
        dynamicSerie.add(5.6);
        System.out.println(dynamicSerie);
        double sum = 0;
        for (int i = 0; i < dynamicSerie.size(); i++) {
            sum = sum + (double) dynamicSerie.get(i);
        }
        System.out.println(sum);
    }

}
