package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatchSimulatorUI extends JFrame {
    private int milanScore = 0;
    private int madridScore = 0;
    private String lastScorer = "N/A";
    private String winner = "DRAW";

    private JLabel resultLabel;
    private JLabel lastScorerLabel;
    private JLabel winnerLabel;

    public MatchSimulatorUI() {
        setTitle("Симулятор матча: Милан vs Мадрид");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Панель с компонентами
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Заголовок
        JLabel titleLabel = new JLabel("Матч: AC Milan vs Real Madrid", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Кнопки команд
        JButton milanButton = new JButton("AC Milan");
        JButton madridButton = new JButton("Real Madrid");

        // Метки для отображения информации
        resultLabel = new JLabel("Result: 0 X 0", SwingConstants.CENTER);
        lastScorerLabel = new JLabel("Last Scorer: N/A", SwingConstants.CENTER);
        winnerLabel = new JLabel("Winner: DRAW", SwingConstants.CENTER);

        // Устанавливаем шрифты
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        lastScorerLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        winnerLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        // Обработчики событий для кнопок
        milanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milanScore++;
                lastScorer = "AC Milan";
                updateResult();
            }
        });

        madridButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                madridScore++;
                lastScorer = "Real Madrid";
                updateResult();
            }
        });

        // Кнопка сброса
        JButton resetButton = new JButton("Сбросить счет");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milanScore = 0;
                madridScore = 0;
                lastScorer = "N/A";
                winner = "DRAW";
                updateResult();
            }
        });

        // Добавляем компоненты на панель
        panel.add(titleLabel);
        panel.add(milanButton);
        panel.add(madridButton);
        panel.add(resultLabel);
        panel.add(lastScorerLabel);
        panel.add(winnerLabel);
        panel.add(resetButton);

        add(panel);
        setVisible(true);
    }

    private void updateResult() {
        // Обновляем результат
        resultLabel.setText("Result: " + milanScore + " X " + madridScore);
        lastScorerLabel.setText("Last Scorer: " + lastScorer);

        // Определяем победителя
        if (milanScore > madridScore) {
            winner = "AC Milan";
        } else if (madridScore > milanScore) {
            winner = "Real Madrid";
        } else {
            winner = "DRAW";
        }

        winnerLabel.setText("Winner: " + winner);
    }
}