/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thales.parkingrent.gui;

import com.thales.parkingrent.App;
import com.thales.parkingrent.entities.parking.ExhibitionStand;
import com.thales.parkingrent.entities.parking.ParkingSize;
import com.thales.parkingrent.entities.parking.ParkingUsage;
import com.thales.parkingrent.entities.vehicles.Car;
import com.thales.parkingrent.entities.vehicles.Motorcycle;
import com.thales.parkingrent.entities.vehicles.Truck;
import com.thales.parkingrent.entities.vehicles.Vehicle;
import java.awt.Component;
import java.util.Objects;

/**
 * Entry point for the main app.
 */
public class ParkingRentFrame extends javax.swing.JFrame {

    private static final String SELECT_USAGE = "Select Usage";
    private static final String SELECT_SIZE = "Select Size";
    private static final String SELECT_PRICE = "Select Price";
    private static final String EXHIBITION_STAND = "ExhibitionStand";

    private final App app;

    private ParkingRentFrame(App app) {
        this.app = app;
        initComponents();
        disablePanels();
    }

    private void disablePanels() {
        disableComponents(kilometerDetailsPanel.getComponents());
        disableComponents(exhibitionStandDetailsPanel.getComponents());
    }

    private void disableComponents(Component[] components) {
        enableDisableComponents(components, false);
    }

    private void enableComponents(Component[] components) {
        enableDisableComponents(components, true);
    }

    private void enableDisableComponents(Component[] components, boolean value) {
        for (Component component : components) {
            component.setEnabled(value);
        }
    }

    private void loadUsageComboBox() {
        usageComboBox.addItem(SELECT_USAGE);
        app.getAllUsages().forEach(usage -> usageComboBox.addItem(usage));
    }

    private void loadSizeComboBox() {
        usageComboBox.addItem(SELECT_SIZE);
        app.getExhibitionStandSizes().forEach(usage -> usageComboBox.addItem(usage));
    }

    private void loadValueComboBox() {
        usageComboBox.addItem(SELECT_PRICE);
        app.getValueOfExhibitionItem().forEach(usage -> usageComboBox.addItem(usage));
    }

    private void handleUsageSelection(String selectedValue) {
        if (app.getAllUsages().contains(selectedValue)) {
            if (EXHIBITION_STAND.equals(selectedValue)) {
                disableComponents(kilometerDetailsPanel.getComponents());
                enableComponents(exhibitionStandDetailsPanel.getComponents());
                resultTextArea.setText("");
            } else {
                disableComponents(exhibitionStandDetailsPanel.getComponents());
                enableComponents(kilometerDetailsPanel.getComponents());
                resultTextArea.setText("");
            }
        } else {
            disableComponents(kilometerDetailsPanel.getComponents());
            disableComponents(exhibitionStandDetailsPanel.getComponents());
            resultTextArea.setText("");
        }
    }

    private void computePriceAndShowTheResult() {
        String usage = usageComboBox.getSelectedItem().toString();
        if (app.getAllUsages().contains(usage)) {
            if (EXHIBITION_STAND.equalsIgnoreCase(usage)) {
                computeExhibitionPriceAndShowTheResult();
            } else {
                computeParkingPriceAndShowTheResult(usage);
            }
        }
    }

    private void computeExhibitionPriceAndShowTheResult() {
        String exhibitionStandSize = exhibitionStandSizeCombo.getSelectedItem().toString();
        String exhibitionVehicleValue = exhibitionVehicleValueCombo.getSelectedItem().toString();
        String price = String.valueOf(app.getParkingManager().computePrice(new ExhibitionStand(ParkingSize.valueOf(exhibitionStandSize), Vehicle.Value.valueOf(exhibitionVehicleValue))));
        resultTextArea.setText(price + "$");
    }

    private void computeParkingPriceAndShowTheResult(String usage) {
        int kilometers = Integer.parseInt(carKilometerTextField.getText());
        ParkingUsage parkingUsage = null;
        switch (usage) {
            case "Car":
                parkingUsage = new Car(kilometers);
                break;
            case "Truck":
                parkingUsage = new Truck(kilometers);
                break;
            case "Motorcycle":
                parkingUsage = new Motorcycle(kilometers);
                break;
            default:
                System.out.println("Invalid combination");
        }
        if (Objects.nonNull(parkingUsage)) {
            String price = String.valueOf(app.getParkingManager().computePrice(parkingUsage));
            resultTextArea.setText(price + "$");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        headingPanel = new javax.swing.JPanel();
        headingLabel = new javax.swing.JLabel();
        usagePanel = new javax.swing.JPanel();
        usageLabel = new javax.swing.JLabel();
        usageComboBox = new javax.swing.JComboBox<>();
        kilometerDetailsPanel = new javax.swing.JPanel();
        carKilometerLabel = new javax.swing.JLabel();
        carKilometerTextField = new javax.swing.JTextField();
        exhibitionStandDetailsPanel = new javax.swing.JPanel();
        exhibitionStandSizeLabel = new javax.swing.JLabel();
        exhibitionStandSizeCombo = new javax.swing.JComboBox<>();
        exhibitionVehicleValueLabel = new javax.swing.JLabel();
        exhibitionVehicleValueCombo = new javax.swing.JComboBox<>();
        pricingButtonPanel = new javax.swing.JPanel();
        pricingButton = new javax.swing.JButton();
        resultPanel = new javax.swing.JPanel();
        resultTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parking Rental");
        setMinimumSize(new java.awt.Dimension(327, 120));
        setName("ParkingRentInnerFrame"); // NOI18N
        getContentPane().setLayout(new java.awt.BorderLayout());

        mainPanel.setMinimumSize(new java.awt.Dimension(327, 120));
        mainPanel.setLayout(new java.awt.GridBagLayout());

        headingLabel.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        headingLabel.setText("Parking Rental");
        headingPanel.add(headingLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        mainPanel.add(headingPanel, gridBagConstraints);

        usageLabel.setText("Usage:");
        usagePanel.add(usageLabel);

        usageComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Usage", "Car", "Truck", "Motorcycle", "ExhibitionStand" }));
        usageComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                usageComboBoxItemStateChanged(evt);
            }
        });
        usageComboBox.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                usageComboBoxComponentShown(evt);
            }
        });
        usagePanel.add(usageComboBox);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        mainPanel.add(usagePanel, gridBagConstraints);

        carKilometerLabel.setText("Car/Bike/Truck Kilometer:");
        kilometerDetailsPanel.add(carKilometerLabel);

        carKilometerTextField.setMinimumSize(new java.awt.Dimension(150, 28));
        carKilometerTextField.setName("txtKilometer"); // NOI18N
        carKilometerTextField.setPreferredSize(new java.awt.Dimension(150, 28));
        kilometerDetailsPanel.add(carKilometerTextField);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        mainPanel.add(kilometerDetailsPanel, gridBagConstraints);

        exhibitionStandSizeLabel.setText("Stand Size:");
        exhibitionStandDetailsPanel.add(exhibitionStandSizeLabel);

        exhibitionStandSizeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Size", "SMALL", "MEDIUM", "LARGE" }));
        exhibitionStandSizeCombo.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                exhibitionStandSizeComboComponentShown(evt);
            }
        });
        exhibitionStandDetailsPanel.add(exhibitionStandSizeCombo);

        exhibitionVehicleValueLabel.setText("Vehicle Value:");
        exhibitionStandDetailsPanel.add(exhibitionVehicleValueLabel);

        exhibitionVehicleValueCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Value", "CHEAP", "MEDIUM", "COSTLY" }));
        exhibitionVehicleValueCombo.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                exhibitionVehicleValueComboComponentShown(evt);
            }
        });
        exhibitionStandDetailsPanel.add(exhibitionVehicleValueCombo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        mainPanel.add(exhibitionStandDetailsPanel, gridBagConstraints);

        pricingButton.setText("Compute Price");
        pricingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pricingButtonActionPerformed(evt);
            }
        });
        pricingButtonPanel.add(pricingButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 6;
        mainPanel.add(pricingButtonPanel, gridBagConstraints);

        resultTextArea.setColumns(20);
        resultTextArea.setRows(3);
        resultPanel.add(resultTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 7;
        mainPanel.add(resultPanel, gridBagConstraints);

        getContentPane().add(mainPanel, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exhibitionVehicleValueComboComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_exhibitionVehicleValueComboComponentShown
        loadValueComboBox();
    }//GEN-LAST:event_exhibitionVehicleValueComboComponentShown

    private void exhibitionStandSizeComboComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_exhibitionStandSizeComboComponentShown
        loadSizeComboBox();
    }//GEN-LAST:event_exhibitionStandSizeComboComponentShown

    private void usageComboBoxComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_usageComboBoxComponentShown
        loadUsageComboBox();
    }//GEN-LAST:event_usageComboBoxComponentShown

    private void usageComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_usageComboBoxItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            handleUsageSelection(usageComboBox.getSelectedItem().toString());
        }
    }//GEN-LAST:event_usageComboBoxItemStateChanged

    private void pricingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pricingButtonActionPerformed
        computePriceAndShowTheResult();
    }//GEN-LAST:event_pricingButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ParkingRentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParkingRentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParkingRentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParkingRentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            App app1 = new App();
            new ParkingRentFrame(app1).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel carKilometerLabel;
    private javax.swing.JTextField carKilometerTextField;
    private javax.swing.JPanel exhibitionStandDetailsPanel;
    private javax.swing.JComboBox<String> exhibitionStandSizeCombo;
    private javax.swing.JLabel exhibitionStandSizeLabel;
    private javax.swing.JComboBox<String> exhibitionVehicleValueCombo;
    private javax.swing.JLabel exhibitionVehicleValueLabel;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JPanel headingPanel;
    private javax.swing.JPanel kilometerDetailsPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton pricingButton;
    private javax.swing.JPanel pricingButtonPanel;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JTextArea resultTextArea;
    private javax.swing.JComboBox<String> usageComboBox;
    private javax.swing.JLabel usageLabel;
    private javax.swing.JPanel usagePanel;
    // End of variables declaration//GEN-END:variables

}
