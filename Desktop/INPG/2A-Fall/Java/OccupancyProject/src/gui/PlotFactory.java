/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.DataContainer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Hour;
/**
 *
 * @author User
 */
public class PlotFactory{
    Hashtable<String,TimeSeries> timeSeriesContainer;
    DataContainer dataContainer;
    
    Date[] dates;
    
    public PlotFactory(DataContainer csvDataReader) {
        dataContainer = csvDataReader;
        try{
            dates = csvDataReader.getDates();
        
        }catch(Exception e){
            System.out.println("ERROR while getting time");
            System.out.println(e);
        }
    }
    
    //return plot of those columns
    public JPanel getPlot(ArrayList<String> variableNames){
    TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();        
    //iterate over the names:
        System.out.println(variableNames);
        for (int i =0; i< variableNames.size(); i++){
            Double[] dataSensor = dataContainer.getData(variableNames.get(i)); //get the values of this sensor
            TimeSeries timeSeries1 = new TimeSeries(variableNames.get(i)); //create TimeSeries with the name of this sensor
            for (int j =0; j< dataSensor.length; j++){ //iterate over the sensor's values
                timeSeries1.addOrUpdate(new Hour (dates[j]),dataSensor[j]);
            }
            timeSeriesCollection.addSeries(timeSeries1);
        }
        
        JPanel chartPanel = new ChartPanel(ChartFactory.createTimeSeriesChart("Sensors data", " time", "values", timeSeriesCollection, true, true, false));
        return chartPanel;
    }
}
