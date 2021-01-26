/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitters;

import data.DataContainer;
import data.DataContainerWithProcessing;
import java.io.IOException;

public class DichotomicScaler {

    Double[] referenceData;
    Double[] scaledData;
    double bestScale;
    int numberOfIterations;
    Double precision;
    DataContainerWithProcessing dataContainer;

    public DichotomicScaler(Double[] referenceData, Double[] scaledData, double minScale, double maxScale, int maxIterations) {
        this.referenceData = referenceData;
        this.scaledData = scaledData;
        
        double l = minScale; double u = maxScale; double c = 0;
        for (int i = 0; i < maxIterations; i++) {
            c = (l + u) * 0.5;
            double errL=getError(l);
            double errU = getError(u);
            double errC = getError(c);
            if (errL < errU
                    && errC < errU) {
                u = c;
            } else if (errC < errL
                    && errU < errL) {
                l = c;
            } else {
                numberOfIterations = i;
                break;
            }
        }
        bestScale = c;
        precision = (u - l) * 0.5;
    }

    public int getNumberOfIterations() {
        return numberOfIterations;
    }

    public double getBestScale() {
        return bestScale;
    }

    public double getPrecision() {
        return precision;
    }

    public String toString() {
        String string = " DichotomicScaler ";
        return string;
    }

    private double getError(double scale) {
        double err = 0;
        for (int i = 0; i < referenceData.length; i++) {
            err = err + Math.abs(referenceData[i] - scaledData[i] * scale);
        }
        return err;
    }
}
