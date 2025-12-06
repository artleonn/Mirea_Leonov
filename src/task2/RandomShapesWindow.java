package task2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomShapesWindow extends JFrame {

    public RandomShapesWindow() {
        setTitle("20 случайных фигур");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        // Создаем панель для рисования
        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawRandomShapes(g);
            }
        };

        drawingPanel.setBackground(Color.WHITE);
        add(drawingPanel);

        setVisible(true);
    }

    private void drawRandomShapes(Graphics g) {
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            // Случайный цвет
            Color color = new Color(
                    random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256)
            );

            // Случайная позиция
            int x = random.nextInt(500);
            int y = random.nextInt(400);

            // Случайно выбираем тип фигуры
            if (random.nextBoolean()) {
                // Круг
                int radius = 20 + random.nextInt(30);
                Circle circle = new Circle(color, x, y, radius);
                circle.draw(g);
            } else {
                // Прямоугольник
                int width = 30 + random.nextInt(50);
                int height = 20 + random.nextInt(40);
                Rectangle rect = new Rectangle(color, x, y, width, height);
                rect.draw(g);
            }
        }
    }
}