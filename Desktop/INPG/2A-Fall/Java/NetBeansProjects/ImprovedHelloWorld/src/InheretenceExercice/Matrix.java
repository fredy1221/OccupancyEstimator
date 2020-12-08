/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InheretenceExercice;

/**
 *
 * @author chemalif
 */
public abstract class Matrix {
    public int nbrLines;
    public int nbrColumns;
    
    public Matrix(int nbrLines,int nbrColumns) {
        this.nbrLines = nbrLines;
        this.nbrColumns = nbrColumns;
    }
    
    abstract public void setElement(int i, int j, double e);
    abstract public double getElement(int i, int j);

    public String toString() {
        String resultat="";
        for (int i=0; i< nbrLines; i++){
            for (int j=0; j< nbrColumns; j++){
                resultat+=(getElement(i, j)+"\t");
            }
            resultat+="\n";
        }
        return resultat;
    }
    abstract public Matrix Transpose(); 
}
