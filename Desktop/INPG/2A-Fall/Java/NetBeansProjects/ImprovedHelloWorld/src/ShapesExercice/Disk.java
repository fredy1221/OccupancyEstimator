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
public class Disk extends Shape {

    double centralPointX, centralPointY, radius;

    public Disk(Point p, double r) { //constructed using a central point and a radius
        setX(p.x);
        setY(p.y);
        setRadius(r);

    }

    public Disk(Point p1, Point p2) { //2 points defining its diameter.
        setX((p1.x + p2.x) * 0.5);
        setY((p1.y + p2.y) * 0.5);
        setRadius(0.5 * Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2)));
    }

    public void setX(double x) {
        centralPointX = x;
    }

    public void setY(double y) {
        centralPointY = y;
    }

    public void setRadius(double r) {
        radius = r;
    }

    public double getX() {
        return centralPointX;
    }

    public double getY() {
        return centralPointY;
    }

    public double getRadius() {
        return radius;
    }

    public double surface() {
        return 3.14 * Math.pow(getRadius(), 2);
    }

    public double perimeter() {
        return 2 * 3.14 * getRadius();
    }

    public void CreatePlot() {/////////////////////////////////////????????????????????????????????
        System.out.println("...");
    }

}
