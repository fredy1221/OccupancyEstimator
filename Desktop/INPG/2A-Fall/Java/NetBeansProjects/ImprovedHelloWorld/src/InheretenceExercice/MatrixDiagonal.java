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

public class MatrixDiagonal extends Matrix {
    double[] elements = new double[nbrLines];
    public MatrixDiagonal(int nL) {
        super(nL,nL);
    }
    public void setElement(int i, int j, double e) {
        if(i==j){
            elements[i] = e;
        }
        else if (e!=0){
            System.out.println("erreur..");
        }}
    public double getElement(int i, int j) {
        if(i==j){
            return elements[i];
        }
        else{
            return 0;
        }}
    public Matrix Transpose() {
        
        Matrix new_transpose = new MatrixDiagonal(nbrLines);
        for (int i = 0; i < nbrLines; i++) {
                new_transpose.setElement(i,i,getElement(i,i));
        }
        return new_transpose;}}