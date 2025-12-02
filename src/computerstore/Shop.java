package computerstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    private List<Computer> computers = new ArrayList<>();

    public void addComputer(Computer computer) {
        computers.add(computer);
        System.out.println("Компьютер добавлен: " + computer.getBrand());
    }

    public void removeComputer(Computer computer) {
        if (computers.remove(computer)) {
            System.out.println("Компьютер удален: " + computer.getBrand());
        } else {
            System.out.println("Компьютер не найден");
        }
    }

    public Computer findComputerByBrand(Brand brand) {
        for (Computer computer : computers) {
            if (computer.getBrand() == brand) {
                return computer;
            }
        }
        return null;
    }

    public void displayComputers() {
        if (computers.isEmpty()) {
            System.out.println("Магазин пуст");
        } else {
            System.out.println("Список компьютеров в магазине:");
            for (Computer computer : computers) {
                System.out.println(computer);
            }
        }
    }

    public void fillFromKeyboard() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Добавление компьютера ===");

        System.out.println("Выберите бренд (ASUS, DELL, HP, LENOVO, ACER, APPLE): ");
        String brandStr = scanner.nextLine();
        Brand brand = Brand.valueOf(brandStr.toUpperCase());

        System.out.println("Введите модель процессора: ");
        String procModel = scanner.nextLine();
        System.out.println("Введите частоту процессора (ГГц): ");
        double procSpeed = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Введите объем памяти (ГБ): ");
        int memSize = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите тип памяти: ");
        String memType = scanner.nextLine();

        System.out.println("Введите размер монитора (дюймы): ");
        double monSize = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Введите разрешение монитора: ");
        String monRes = scanner.nextLine();

        System.out.println("Введите цену: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Processor processor = new Processor(procModel, procSpeed);
        Memory memory = new Memory(memSize, memType);
        Monitor monitor = new Monitor(monSize, monRes);

        Computer computer = new Computer(brand, processor, memory, monitor, price);
        addComputer(computer);
    }
}
