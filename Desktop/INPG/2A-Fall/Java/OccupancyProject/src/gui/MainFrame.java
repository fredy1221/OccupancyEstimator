/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.DataContainer;
import data.DataContainerWithProcessing;
import fitters.DichotomicScaler;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;

/**
 *
 * @author User
 */
public class MainFrame extends JFrame {

    DataContainerWithProcessing dataContainer;
    PlotFactory plotFactory;
    JCheckBox[] variableCheckBoxes;
    JButton plotButton = new JButton("plot");
    int plotCounter = 0;

    public MainFrame(String name) {
        super(name);
        setResizable(false);
    }

    private void initComponents() {
        //Create the frame:
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(new GridLayout(0, 1));

        //Choose the CSV file:
        try {
            dataContainer = new DataContainerWithProcessing("office.csv");
            
        } catch (Exception e) {
            System.out.println("ERROR loading CSV file");
            System.out.println(e.getMessage());
        }

        //Create checkbox and buttons:
        String[] sensorsTable = dataContainer.getAvailableVariables();
        variableCheckBoxes = new JCheckBox[sensorsTable.length];
        for (int i = 0; i < sensorsTable.length; i++) {
            variableCheckBoxes[i] = new JCheckBox(sensorsTable[i]);
            compsToExperiment.add(variableCheckBoxes[i]);
        }
        JButton btnPlot = new JButton("Plot");
        compsToExperiment.add(btnPlot);
        btnPlot.addActionListener(new MyActionListener());
        getContentPane().add(compsToExperiment, BorderLayout.NORTH);
        pack();
        setVisible(true);

        plotFactory = new PlotFactory(dataContainer);
        
    }

    class MyActionListener implements ActionListener {
        ArrayList<String> checkedBoxes = new ArrayList<String>();
        public void actionPerformed(ActionEvent e) {
            checkedBoxes.clear();
            for (JCheckBox cb : variableCheckBoxes) {
                if (cb.isSelected()) {
                    checkedBoxes.add(cb.getText());
                }
            }
            JPanel plotPanel = plotFactory.getPlot(checkedBoxes);
            JFrame frame = new JFrame("Test");
            frame.getContentPane().add(plotPanel);
            frame.pack();
            frame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        MainFrame mFrame = new MainFrame("Occupancy estimator");
        mFrame.initComponents();
        
    }
}
