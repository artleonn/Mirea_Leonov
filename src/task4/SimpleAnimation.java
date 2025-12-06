package task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleAnimation extends JFrame {
    private int currentFrame = 0;
    private Timer timer;
    private Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA};

    public SimpleAnimation() {
        setTitle("Простая анимация");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Панель для анимации
        JPanel animationPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawAnimation(g);
            }
        };
        animationPanel.setBackground(Color.BLACK);

        // Панель управления
        JPanel controlPanel = new JPanel();
        JButton startButton = new JButton("Старт");
        JButton stopButton = new JButton("Стоп");
        JButton resetButton = new JButton("Сброс");

        // Таймер для анимации (25 кадров в секунду)
        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame = (currentFrame + 1) % 60; // 60 кадров цикла
                animationPanel.repaint();
            }
        });

        // Обработчики кнопок
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame = 0;
                animationPanel.repaint();
            }
        });

        // Добавляем кнопки на панель управления
        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.add(resetButton);

        // Компоновка окна
        add(animationPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        // Информационная метка
        JLabel infoLabel = new JLabel("Анимация: меняющийся цветной круг", SwingConstants.CENTER);
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setBackground(Color.DARK_GRAY);
        infoLabel.setOpaque(true);
        add(infoLabel, BorderLayout.NORTH);

        setVisible(true);
    }

    private void drawAnimation(Graphics g) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Меняем размер круга в зависимости от кадра
        int size = 50 + (int)(Math.sin(currentFrame * 0.1) * 30);

        // Меняем цвет
        Color currentColor = colors[(currentFrame / 10) % colors.length];

        // Рисуем круг
        g.setColor(currentColor);
        g.fillOval(centerX - size/2, centerY - size/2, size, size);

        // Рисуем обводку
        g.setColor(Color.WHITE);
        g.drawOval(centerX - size/2, centerY - size/2, size, size);

        // Рисуем дополнительные элементы для создания эффекта анимации
        for (int i = 0; i < 8; i++) {
            double angle = currentFrame * 0.1 + i * Math.PI / 4;
            int x = centerX + (int)(Math.cos(angle) * (size/2 + 20));
            int y = centerY + (int)(Math.sin(angle) * (size/2 + 20));
            int smallSize = 10 + i * 2;
            g.setColor(colors[(i + currentFrame/5) % colors.length]);
            g.fillOval(x - smallSize/2, y - smallSize/2, smallSize, smallSize);
        }
    }
}