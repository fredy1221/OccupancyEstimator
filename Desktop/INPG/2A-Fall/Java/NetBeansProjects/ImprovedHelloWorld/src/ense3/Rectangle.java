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
public class Rectangle {

    double width;
    double height;
    double perimeter;
    double surface;

    public Rectangle(double aWidth, double aHeight) { // constructor of the new type
        width = aWidth;
        height = aHeight;
        perimeter = 2 * (width + height);
        surface = width * height;
    }

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(10, 5);
        Rectangle rectangle2 = new Rectangle(4, 7);
        System.out.println("[rectangle1] width: " + rectangle1.width + ", surface: " +rectangle1.surface);
        System.out.println("[rectangle2] width: " + rectangle2.width + ", surface: " +rectangle2.surface);
}
}
