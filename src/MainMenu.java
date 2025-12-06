import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Практическая работа №5 - Главное меню");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Панель с кнопками
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        // Кнопка для задания 1
        JButton task1Button = new JButton("Задание 1: Симулятор матча Милан-Мадрид");
        task1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new task1.MatchSimulatorUI();
            }
        });

        // Кнопка для задания 2
        JButton task2Button = new JButton("Задание 2: 20 случайных фигур");
        task2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new task2.RandomShapesWindow();
            }
        });

        // Кнопка для задания 3
        JButton task3Button = new JButton("Задание 3: Просмотр картинки");
        task3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Открываем диалог для ввода пути к картинке
                String imagePath = JOptionPane.showInputDialog(
                        MainMenu.this,
                        "Введите путь к картинке:",
                        "Задание 3",
                        JOptionPane.QUESTION_MESSAGE
                );
                if (imagePath != null && !imagePath.trim().isEmpty()) {
                    new task3.ImageViewer(imagePath);
                }
            }
        });

        // Кнопка для задания 4
        JButton task4Button = new JButton("Задание 4: Анимация");
        task4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new task4.SimpleAnimation();
            }
        });

        // Добавляем кнопки на панель
        panel.add(task1Button);
        panel.add(task2Button);
        panel.add(task3Button);
        panel.add(task4Button);

        // Добавляем заголовок
        JLabel titleLabel = new JLabel("Практическая работа №5", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Основная панель
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(panel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Запускаем главное меню
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMenu();
            }
        });
    }
}