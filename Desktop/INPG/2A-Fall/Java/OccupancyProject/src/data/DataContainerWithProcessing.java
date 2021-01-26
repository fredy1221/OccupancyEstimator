/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import fitters.DichotomicScaler;
import java.io.IOException;

/**
 *
 * @author thoma
 */
public class DataContainerWithProcessing extends DataContainer {

    public DataContainerWithProcessing(String csvFileName) throws IOException {
        super(csvFileName);
        addEstimLaptotPower();
        addEstimDetectedMotions();
    }

    public void addEstimLaptotPower() {
        int nbrOfSamples = getNumberOfSamples();
        Double[] occ_laptop = new Double[nbrOfSamples];
        Double[] pow_laptop1z1 = getData("power_laptop1_zone1");
        Double[] pow_laptop1z2 = getData("power_laptop1_zone2");
        Double[] pow_laptop2z2 = getData("power_laptop2_zone2");
        Double[] pow_laptop3z2 = getData("power_laptop3_zone2");
        for (int i = 0; i < nbrOfSamples; i++) {
            double nbrPers = 0;
            if (pow_laptop1z1[i] > 15) {
                nbrPers++;
            }
            if (pow_laptop1z2[i] > 15) {
                nbrPers++;
            }
            if (pow_laptop2z2[i] > 15) {
                nbrPers++;
            }
            if (pow_laptop3z2[i] > 15) {
                nbrPers++;
            }
            occ_laptop[i] = nbrPers;
        }
        addData("laptop_power_estimator", occ_laptop);
    }

    public void addEstimDetectedMotions() {
        Double[] referenceData = getData("laptop_power_estimator");
        Double[] scaledData = getData("detected_motions");
        DichotomicScaler my_scaler = new DichotomicScaler(referenceData, scaledData, 0.001, 0.8, 2000);
        double scale = my_scaler.getBestScale();
           
        System.out.print("best scale: "); System.out.println(scale);
        int nbrOfSamples = getNumberOfSamples();
        Double[] occ_motion = new Double[nbrOfSamples];
        for (int i = 0; i < nbrOfSamples; i++) {
            occ_motion[i] = (double)Math.round (scaledData[i] * scale);
        }
        addData("occupancy motion estimator",occ_motion);
    }
}