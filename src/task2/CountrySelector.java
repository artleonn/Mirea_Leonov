package task2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountrySelector extends JFrame {
    public CountrySelector() {
        setTitle("Выбор страны (Задание 2)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        String[] countries = {"Россия", "США", "Германия", "Япония", "Бразилия"};
        JComboBox<String> comboBox = new JComboBox<>(countries);
        JLabel infoLabel = new JLabel("Выберите страну");

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBox.getSelectedItem();
                String info = "";
                switch (selected) {
                    case "Россия": info = "Столица: Москва"; break;
                    case "США": info = "Столица: Вашингтон"; break;
                    case "Германия": info = "Столица: Берлин"; break;
                    case "Япония": info = "Столица: Токио"; break;
                    case "Бразилия": info = "Столица: Бразилиа"; break;
                }
                infoLabel.setText(info);
            }
        });

        add(new JLabel("Выберите страну:"));
        add(comboBox);
        add(infoLabel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}