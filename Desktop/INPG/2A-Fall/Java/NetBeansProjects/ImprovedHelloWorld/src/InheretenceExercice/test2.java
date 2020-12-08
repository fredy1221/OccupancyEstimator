/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InheretenceExercice;

/**
 *
 * @author User
 */
public class test2 {
    
}

class DivisionByZero extends Exception {
}

class UnkownOperation extends Exception {

    public UnkownOperation(String s) {
        super(s);
    }

    public static int execute(int nbr1, String op, int nbr2) throws DivisionByZero, UnkownOperation {
        if ("*".compareTo(op) == 0) {
            return nbr1 * nbr2;
        } else if ("/".compareTo(op) == 0) {
            if (nbr2 == 0) {
                throw new DivisionByZero();
            }
            return nbr1 / nbr2;
        } else {
            throw new UnkownOperation(op);
        }
    }
    
    public static void main(String args[]) {
        try {
            System.out.println("R1 =" + execute(3, "*", 5));
            System.out.println("R2 =" + execute(56, "/", 4));
            System.out.println("R3 =" + execute(33, "+", 5));
            System.out.println("R4 =" + execute(25, "/", 0));
        } catch (DivisionByZero e) {
            System.out.println("Division par zero");
        } catch (UnkownOperation e) {
            System.out.println("Unknown operation"+e.getMessage());
        } catch (Exception e) {
            System.out.println("Other exception");
        }
        finally {
            System.out.println("finally is executed");
        }
    }    
    
}