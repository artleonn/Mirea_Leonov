import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String name;
    private String surname;
    private Date birthDate;

    public Student(String name, String surname, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return "Student{name='" + name + "', surname='" + surname +
                "', birthDate=" + formatBirthDate("MEDIUM") + "}";
    }

    // Метод для форматирования даты рождения
    public String formatBirthDate(String formatType) {
        if (birthDate == null) {
            return "Дата рождения не указана";
        }

        switch (formatType.toUpperCase()) {
            case "SHORT":
                SimpleDateFormat shortFormat = new SimpleDateFormat("dd.MM.yy");
                return shortFormat.format(birthDate);

            case "MEDIUM":
                SimpleDateFormat mediumFormat = new SimpleDateFormat("dd.MM.yyyy");
                return mediumFormat.format(birthDate);

            case "LONG":
                SimpleDateFormat longFormat = new SimpleDateFormat("dd MMMM yyyy");
                return longFormat.format(birthDate);

            case "FULL":
                SimpleDateFormat fullFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy");
                return fullFormat.format(birthDate);

            default:
                return birthDate.toString();
        }
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}

