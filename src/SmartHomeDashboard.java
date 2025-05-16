
package smarthome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SmartHomeDashboard extends JFrame {
    private JLabel electricityLabel, gasLabel, waterLabel, predictionLabel;
    private JButton simulateButton;

    public SmartHomeDashboard() {
        setTitle("🏠 Smart Home Energy Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        electricityLabel = new JLabel("Electricity Usage: 0 kWh");
        gasLabel = new JLabel("Gas Usage: 0 m³");
        waterLabel = new JLabel("Water Usage: 0 L");
        predictionLabel = new JLabel("💡 Predicted Next Month Cost: $0");

        simulateButton = new JButton("Simulate Energy Usage");
        simulateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simulateUsage();
            }
        });

        add(electricityLabel);
        add(gasLabel);
        add(waterLabel);
        add(predictionLabel);
        add(simulateButton);

        setVisible(true);
    }

    private void simulateUsage() {
        Random rand = new Random();
        int electricity = rand.nextInt(500) + 100;
        int gas = rand.nextInt(100) + 20;
        int water = rand.nextInt(1000) + 200;

        double cost = electricity * 0.12 + gas * 0.08 + water * 0.005;

        electricityLabel.setText("Electricity Usage: " + electricity + " kWh");
        gasLabel.setText("Gas Usage: " + gas + " m³");
        waterLabel.setText("Water Usage: " + water + " L");
        predictionLabel.setText("💡 Predicted Next Month Cost: $" + String.format("%.2f", cost));
    }

    public static void main(String[] args) {
        new SmartHomeDashboard();
    }
}
