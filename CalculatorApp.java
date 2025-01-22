import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Simple Calculator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        // Create UI components
        JLabel label1 = new JLabel("Enter first number:");
        JTextField num1Field = new JTextField();
        JLabel label2 = new JLabel("Enter second number:");
        JTextField num2Field = new JTextField();
        JLabel resultLabel = new JLabel("Result:");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);

        JButton addButton = new JButton("Add");
        JButton subtractButton = new JButton("Subtract");
        JButton multiplyButton = new JButton("Multiply");
        JButton divideButton = new JButton("Divide");

        // Add components to frame
        frame.add(label1);
        frame.add(num1Field);
        frame.add(label2);
        frame.add(num2Field);
        frame.add(addButton);
        frame.add(subtractButton);
        frame.add(multiplyButton);
        frame.add(divideButton);
        frame.add(resultLabel);
        frame.add(resultField);

        // Action listeners for buttons
        ActionListener calculate = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double result = 0;

                    if (e.getSource() == addButton) {
                        result = num1 + num2;
                    } else if (e.getSource() == subtractButton) {
                        result = num1 - num2;
                    } else if (e.getSource() == multiplyButton) {
                        result = num1 * num2;
                    } else if (e.getSource() == divideButton) {
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            JOptionPane.showMessageDialog(frame, "Cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    resultField.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        addButton.addActionListener(calculate);
        subtractButton.addActionListener(calculate);
        multiplyButton.addActionListener(calculate);
        divideButton.addActionListener(calculate);

        // Set frame visibility
        frame.setVisible(true);
    }
}
