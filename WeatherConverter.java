import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherConverter {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Weather Converter");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        // Input field and labels
        JLabel inputLabel = new JLabel("Enter Temperature:");
        JTextField inputField = new JTextField();

        JLabel resultLabel = new JLabel("Converted Temperature:");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);

        // Buttons for conversion
        JButton toCelsiusButton = new JButton("Convert to Celsius");
        JButton toFahrenheitButton = new JButton("Convert to Fahrenheit");

        // Add action listeners to buttons
        toCelsiusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double fahrenheit = Double.parseDouble(inputField.getText());
                    double celsius = (fahrenheit - 32) * 5 / 9;
                    resultField.setText(String.format("%.2f °C", celsius));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        toFahrenheitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celsius = Double.parseDouble(inputField.getText());
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    resultField.setText(String.format("%.2f °F", fahrenheit));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add components to the frame
        frame.add(inputLabel);
        frame.add(inputField);
        frame.add(toCelsiusButton);
        frame.add(toFahrenheitButton);
        frame.add(resultLabel);
        frame.add(resultField);

        // Set frame visibility
        frame.setVisible(true);
    }
}
