package task3;

import javax.swing.*;
import java.awt.*;

public class ImageViewer extends JFrame {

    public ImageViewer(String imagePath) {
        setTitle("Просмотр картинки: " + imagePath);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        try {
            // Создаем изображение из пути
            ImageIcon imageIcon = new ImageIcon(imagePath);

            // Масштабируем изображение если оно слишком большое
            Image image = imageIcon.getImage();
            if (imageIcon.getIconWidth() > 550 || imageIcon.getIconHeight() > 450) {
                Image scaledImage = image.getScaledInstance(550, 450, Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(scaledImage);
            }

            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

            JScrollPane scrollPane = new JScrollPane(imageLabel);
            add(scrollPane, BorderLayout.CENTER);

            // Панель с информацией
            JPanel infoPanel = new JPanel();
            infoPanel.add(new JLabel("Путь: " + imagePath));
            add(infoPanel, BorderLayout.SOUTH);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Ошибка загрузки изображения: " + e.getMessage(),
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);

            // Показываем сообщение об ошибке
            JLabel errorLabel = new JLabel("Не удалось загрузить изображение: " + imagePath, SwingConstants.CENTER);
            add(errorLabel);
        }

        setVisible(true);
    }
}