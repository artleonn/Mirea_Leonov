package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {

    private JTextField numField1;
    private JTextField numField2;
    private JLabel resultLabel;

    public CalculatorGUI() {
        setTitle("Калькулятор (Задание 1)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Первое число:"));
        numField1 = new JTextField();
        add(numField1);

        add(new JLabel("Второе число:"));
        numField2 = new JTextField();
        add(numField2);

        String[] operations = {"+", "-", "*", "/"};
        for (String op : operations) {
            JButton btn = new JButton(op);
            btn.addActionListener(new OperationListener(op));
            add(btn);
        }

        add(new JLabel("Результат:"));
        resultLabel = new JLabel("0");
        add(resultLabel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class OperationListener implements ActionListener {
        private String operation;

        public OperationListener(String operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double num1 = Double.parseDouble(numField1.getText().trim());
                double num2 = Double.parseDouble(numField2.getText().trim());
                double result = 0;

                switch (operation) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            JOptionPane.showMessageDialog(null, "Деление на ноль невозможно!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        result = num1 / num2;
                        break;
                }

                resultLabel.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Введите корректные числа!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
