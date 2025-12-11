package task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonCalculator extends JFrame {
    private JTextField display;
    private double firstNumber = 0;
    private String operation = "";

    public ButtonCalculator() {
        setTitle("Калькулятор с кнопками (Задание 4)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789".contains(command)) {
                display.setText(display.getText() + command);
            } else if (command.equals("C")) {
                display.setText("");
                firstNumber = 0;
                operation = "";
            } else if ("+-*/".contains(command)) {
                try {
                    firstNumber = Double.parseDouble(display.getText());
                    operation = command;
                    display.setText("");
                } catch (NumberFormatException ex) {
                    display.setText("Ошибка");
                }
            } else if (command.equals("=")) {
                try {
                    double secondNumber = Double.parseDouble(display.getText());
                    double result = 0;
                    switch (operation) {
                        case "+": result = firstNumber + secondNumber; break;
                        case "-": result = firstNumber - secondNumber; break;
                        case "*": result = firstNumber * secondNumber; break;
                        case "/":
                            if (secondNumber == 0) {
                                display.setText("Деление на 0");
                                return;
                            }
                            result = firstNumber / secondNumber;
                            break;
                    }
                    display.setText(String.valueOf(result));
                    operation = "";
                } catch (NumberFormatException ex) {
                    display.setText("Ошибка");
                }
            }
        }
    }
}