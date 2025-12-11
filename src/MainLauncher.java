import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainLauncher extends JFrame {
    public MainLauncher() {
        setTitle("Практическая работа 15 - Лаунчер");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton task1Button = new JButton("Задание 1: Калькулятор");
        JButton task2Button = new JButton("Задание 2: Выбор страны");
        JButton task3Button = new JButton("Задание 3: Меню и текстовое поле");
        JButton task4Button = new JButton("Задание 4: Калькулятор с кнопками");

        task1Button.addActionListener(new TaskLauncher("task1.MainCalculator"));
        task2Button.addActionListener(new TaskLauncher("task2.MainCountrySelector"));
        task3Button.addActionListener(new TaskLauncher("task3.MainMenuApp"));
        task4Button.addActionListener(new TaskLauncher("task4.MainButtonCalculator"));

        add(task1Button);
        add(task2Button);
        add(task3Button);
        add(task4Button);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private static class TaskLauncher implements ActionListener {
        private String className;

        public TaskLauncher(String className) {
            this.className = className;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Class.forName(className).getMethod("main", String[].class)
                        .invoke(null, (Object) new String[]{});
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ошибка запуска: " + ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new MainLauncher();
    }
}