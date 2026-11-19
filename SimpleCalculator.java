import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JLabel label1, label2, label3, label4;
    private JTextField textNum1, textNum2, textResult;
    private JButton addButton, minusButton, multiplyButton, divideButton;

    public SimpleCalculator() {
        // Create components
        label1 = new JLabel("Simple Calculator");
        label2 = new JLabel("Enter first number:");
        label3 = new JLabel("Enter second number:");
        label4 = new JLabel("Result:");

        textNum1 = new JTextField(10);
        textNum2 = new JTextField(10);
        textResult = new JTextField(10);
        textResult.setEditable(false); // make result field non-editable

        addButton = new JButton("+");
        minusButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");

        addButton.addActionListener(this);
        minusButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        // Layout setup: 6 rows, 2 columns
        setLayout(new GridLayout(6, 2, 5, 5));
        add(label1);
        add(new JLabel("")); // empty cell for spacing
        add(label2);
        add(textNum1);
        add(label3);
        add(textNum2);
        add(label4);
        add(textResult);
        add(addButton);
        add(minusButton);
        add(multiplyButton);
        add(divideButton);
    }

    // Handle button click
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(textNum1.getText());
            double num2 = Double.parseDouble(textNum2.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == minusButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero!");
                    return;
                }
                result = num1 / num2;
            }

            textResult.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
        }
    }

    public static void main(String[] args) {
        SimpleCalculator frame = new SimpleCalculator();
        frame.setTitle("Simple Calculator");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
