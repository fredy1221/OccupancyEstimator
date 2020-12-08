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
public class Square extends Rectangle {

    public Square(Point p1, Point p2) { //constructed using 2 points defining its diagonal
        super(p1, p2);

    }

    public Square(Point p1, double x) { //constructed using one point, a width.
        super(p1, x, x);

    }

}
