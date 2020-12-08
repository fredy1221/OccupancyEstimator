/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShapesExercice;

/**
 *
 * @author User
 */
public class Rectangle extends Shape {

    public double width, height;
    double aX, aY, bX, bY;

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double h) {
        height = h;
    }

    public void setWidth(double w) {
        width = w;
    }

    public Rectangle(Point p1, Point p2) { //constructed using 2 points defining its diagonal
        super();
        setWidth(Math.abs(p1.x - p2.x));
        setHeight(Math.abs(p1.y - p2.y));

    }

    public Rectangle(Point p1, double x, double y) { //constructed using one point, a width and a height.
        super();
        setWidth(x);
        setHeight(y);
    }

    public String toString() {
        return "height: " + getHeight() + " width: " + getWidth();
    }

    public double perimeter() {
        return 2 * (getWidth() + getHeight());
    }

    public double surface() {
        return getWidth() * getHeight();
    }

    public void CreatePlot() {/////////////////////////////////////????????????????????????????????
        System.out.println("...");
    }
}
