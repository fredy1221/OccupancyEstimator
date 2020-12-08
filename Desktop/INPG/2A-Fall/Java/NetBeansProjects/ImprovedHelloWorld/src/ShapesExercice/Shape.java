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
public abstract class Shape {
    static int counter;
    int identifier;
    int filled; //1 if filled, 0 if not
    Shape(){
        counter++;
        identifier=counter;
    }
    abstract public void CreatePlot();
    abstract public double perimeter();
    abstract public double surface();
}
