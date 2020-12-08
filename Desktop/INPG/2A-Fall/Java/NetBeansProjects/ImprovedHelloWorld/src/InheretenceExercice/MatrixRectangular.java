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
public class MatrixRectangular extends Matrix {
    double[][] elements = new double[nbrLines][nbrColumns];
    public MatrixRectangular(int nL, int nC) {
        super(nL, nC);
    }
    @Override
    public Matrix Transpose() {
        Matrix transpose = new MatrixRectangular(nbrColumns, nbrLines);
        for (int i = 0; i < nbrLines; i++) {
            for (int j = 0; j < nbrColumns; j++) {
                transpose.setElement(j, i, getElement(i, j));
            } 
        }
        return transpose;
    }
    @Override
    public void setElement(int i, int j, double e) {
        try {
            elements[i][j] = e;
        } catch (NullPointerException er) {
            System.out.println("Null Pointer Exception " + er);
        }
    }
    @Override
    public double getElement(int i, int j) {
        return elements[i][j];
    }
}
