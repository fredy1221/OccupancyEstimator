/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CO2Sensor;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author chemalif
 */
public class Serie {

    String name;
    ArrayList<Double> myValues = new ArrayList<Double>();
    int size;

    Serie(String aName) { //constructor
        setName(aName);
    }
    
    Double[] getValues(){ 
        Double[] array=myValues.toArray(new Double[size]);
        return array;
    }
    
    String getName() {
        return name;
    }

    void setName(String aName) {
        name = aName;
    }

    void setSize(int n) {
        size = n;
    }

    int getSize() {
        return size;
    }
    
    @Override
    public String toString(){
        return "The values of "+getName()+" are: "+myValues;
    }
    
    void populateWithValues(int numberOfValues, double min, double max) {
        setSize(numberOfValues);
        for (int i = 0; i < getSize(); i++) {
            double random_double = Math.random() * (max - min + 1) + min;
            myValues.add(random_double);
        }
    }
    
    void populateWithTimes(int numberOfValues, double max){
        setSize(numberOfValues);
        for (int i = 0; i < getSize(); i++) {
            double random_double = Math.random() * max;
            myValues.add(random_double);
        }
    }
    
    double computeAverage(){
        double[] pDiff = new double [getSize()-1];
        Double[] aSerie = getValues(); 
        double sum = 0.0;
        for (int i = 1; i < getSize(); i++) {
            pDiff[i-1]=aSerie[i]-aSerie[i-1];
        }

        for(double num : pDiff){
        	sum += num;
        }
        double mean = sum / pDiff.length;
       
        return mean;
    }
    
    
    double computeStdDeviation(){
        double[] pDiff = new double [getSize()-1];
        Double[] aSerie = getValues();
        double sum = 0.0, standardDeviation = 0.0;
        
        for (int i = 1; i < getSize(); i++) {
            pDiff[i-1]=aSerie[i]-aSerie[i-1];
        }
        for(double num : pDiff){
        	sum += num;
        }
        double mean = sum / pDiff.length;
        for(double num: pDiff) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        standardDeviation=Math.sqrt(standardDeviation/pDiff.length);
     
        return standardDeviation;
    }
    
    double computeAverage2(double [] aSerie){ //compute the mean of any array
        double sum = 0.0;
        for(double num : aSerie){
        	sum += num;
        }
        double mean = sum / (aSerie.length-2);
        return mean;
    }
        
    double computeStdDeviation2(double [] aSerie){ //compute the std deviation of any array
        double mean=computeAverage2(aSerie), standardDeviation=0.0;
        for(double num: aSerie) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        standardDeviation=Math.sqrt(standardDeviation/(aSerie.length-2));
        return standardDeviation;
    }
    
    double detectOutlier2(){
        double lambda=1/0.9; int found=1;
        double[] pDiff = new double [getSize()], fDiff = new double [getSize()];
        Double[] aSerie = getValues();
        ArrayList outliersIndex = new ArrayList();
        for (int i = 1; i < getSize()-1; i++) { //skip the 1st and last one,
                pDiff[i] = aSerie[i] - aSerie[i - 1];
                fDiff[i] = aSerie[i + 1] - aSerie[i];
        }
        double m_p=computeAverage2(pDiff), s_p=computeStdDeviation2(pDiff); //mean and std from pDiff
        double m_f=computeAverage2(fDiff), s_f=computeStdDeviation2(fDiff); //mean and std from fDiff
        System.out.print("Values of pDiff: "); System.out.println(Arrays.toString(pDiff));
        System.out.print("Values of fDiff: "); System.out.println(Arrays.toString(fDiff)); 
        System.out.print("for pDiff     mean: "); System.out.print(m_p); System.out.print("      STD deviation: "); System.out.println(s_p);
        System.out.print("for fDiff     mean: "); System.out.print(m_f); System.out.print("      STD deviation: "); System.out.println(s_f);
        
        outter:
        while (found == 1) {
            lambda*=0.9;
            if (lambda<0.01) break; //smthg went wrong
            System.out.println("starting with lambda = "+lambda);
            inner:
            for (int i = 1; i < getSize()-1; i++) {
                if (Math.abs(pDiff[i]) > m_p + lambda * s_p && Math.abs(fDiff[i]) > m_f + lambda * s_f && fDiff[i] * pDiff[i] < 0) {
                    found = 0;
                    outliersIndex.add(i-1);  //this is an outlier
                }
            }
            if (found==1){
                System.out.println("No outlier found for lambda = "+lambda);
            }
            else {
                System.out.println("outliers index: "+outliersIndex);
            }
        }
        return lambda;
    }
    
    double detectOutlier(){
        double lambda=1/0.9;
        int found=1;
        double[] pDiff = new double [getSize()];
        double[] fDiff = new double [getSize()];
        Double[] aSerie = getValues();
        double m=computeAverage(), s=computeStdDeviation(); //from pDiff
        
        for (int i = 1; i < getSize()-1; i++) { //skip the 1st and last one,
                pDiff[i] = aSerie[i] - aSerie[i - 1];
                fDiff[i] = aSerie[i + 1] - aSerie[i];
        }
        
        
        
        System.out.print("Values of pDiff: ");
        System.out.println(Arrays.toString(pDiff));
        System.out.print("Values of fDiff: ");
        System.out.println(Arrays.toString(fDiff)); 
        System.out.print("     mean: ");
        System.out.print(m); 
        System.out.print("      STD deviation: ");
        System.out.println(s); 
        
        while (found == 1) {
            lambda*=0.9;
            if (lambda<0.01){
                break;
            }
            System.out.println("starting with lambda = "+lambda);
            found=0;
            inner:
            for (int i = 1; i < getSize(); i++) {
                if (Math.abs(pDiff[i]) > m + lambda * s && Math.abs(fDiff[i]) > m + lambda * s && fDiff[i] * pDiff[i] < 0) {
                    //this is an outlier
                    found = 1;
                    //System.out.println("found an outlier");
                    break inner;
                }
            }
        }
        return lambda;
    }
    
    public static void main(String[] args) {
        Serie serie1 = new Serie("serieData");
        Serie serie2 = new Serie("serieTime");
        serie1.populateWithValues(10, 400, 2500);
        serie2.populateWithTimes(10, 24*60);
        System.out.println(serie1);
        serie1.detectOutlier2();
    }
    
}
