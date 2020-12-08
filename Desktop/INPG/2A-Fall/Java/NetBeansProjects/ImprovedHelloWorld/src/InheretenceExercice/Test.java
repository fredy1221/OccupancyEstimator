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
public class Test {
    public Test() {
        System.out.print("Constructor of Object Class");
    }
    public static void main(String args[]) {
        int N = 3;
        int M = 4;
        ///////////////////////////////////////////////////////////////////////////////////////////
        Matrix matA = new MatrixRectangular(N, M);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                double x = Math.random();
                matA.setElement(i, j, x);
            }
        }
        System.out.println("Original rectangular matrix");
        System.out.println(matA.toString());
        System.out.println("Transpose function called for rectangular matrix");
        System.out.println(matA.Transpose().toString());
        ///////////////////////////////////////////////////////////////////////////////////////////
        Matrix matB = new MatrixSquare(N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                double x = Math.random();
                matB.setElement(i, j, x);
            }
        }
        System.out.println("Original square matrix");
        System.out.println(matB.toString());
        System.out.println("Transpose function called for square matrix");
        System.out.println(matB.Transpose().toString());
        ///////////////////////////////////////////////////////////////////////////////////////////
        Matrix matC = new MatrixDiagonal(N);
        for (int i = 0; i < N; i++) {
            double x = Math.random();
            matC.setElement(i, i, x);
        }
        System.out.println("Original Diagonal matrix");
        System.out.println(matC.toString());
        System.out.println("Transpose function called for Diagonal matrix");
        System.out.println(matC.Transpose().toString());
    }
}
