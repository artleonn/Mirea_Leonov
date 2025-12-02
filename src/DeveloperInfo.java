import java.text.SimpleDateFormat;
import java.util.Date;

public class DeveloperInfo {
    private Date assignmentReceivedDate;
    private Date assignmentSubmittedDate;
    private String developerName;

    public DeveloperInfo(String name) {
        this.developerName = name;
        this.assignmentReceivedDate = new Date();
    }

    public void submitAssignment() {
        this.assignmentSubmittedDate = new Date();
    }

    public void displayInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        System.out.println("=== Информация о разработчике и задании ===");
        System.out.println("Фамилия разработчика: " + developerName);
        System.out.println("Дата и время получения задания: " +
                dateFormat.format(assignmentReceivedDate));

        if (assignmentSubmittedDate != null) {
            System.out.println("Дата и время сдачи задания: " +
                    dateFormat.format(assignmentSubmittedDate));
        } else {
            System.out.println("Задание еще не сдано");
        }
        System.out.println("===========================================\n");
    }

    public void displayTimeInMillis() {
        System.out.println("Время получения (мс): " + assignmentReceivedDate.getTime());
        System.out.println("Текущее время (мс): " + System.currentTimeMillis());
    }
}