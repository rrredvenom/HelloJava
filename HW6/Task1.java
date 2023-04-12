package HW6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Task1 {
    public static void main(String[] args) {
        Notebook nb1 = new Notebook("Asus", "15 D543MA-DM1368", 4, 1000, "Windows 10", "черный");
        Notebook nb2 = new Notebook("Acer", "Aspire 3 A315-23-R0HR", 4, 256, "Windows 10", "черный");
        Notebook nb3 = new Notebook("Lenovo", "IdeaPad 3 15IML05", 8, 1000, "Windows 11", "серый");
        Notebook nb4 = new Notebook("MSI", "Modern 15 B11-002RU", 8, 256, "Windows 11", "черный");
        Notebook nb5 = new Notebook("Asus", "VivoBook Pro 14 K3400PA-KP109", 16, 512, "Windows 10", "серебристый");
        Notebook nb6 = new Notebook("MSI", "Summit E13 Flip Evo A12MT-061RU", 16, 512, "Без ОС", "серый");
        Notebook nb7 = new Notebook("Huawei", "MateBook D16 RLEF-X", 16, 512, "Windows 10", "серый");
        Notebook nb8 = new Notebook("Asus", "ROG Zephyrus G14 GA402RJ-L4045", 8, 1000, "Без ОС", "серый");
        Notebook nb9 = new Notebook("MSI", "Raider GE78 HX 13VH-094RU", 32, 2000, "Windows 11", "черный");
        Notebook nb10 = new Notebook("Apple", "MacBook Air", 8, 256, "macOS", "серый");

        HashSet<Notebook> notebooks = new HashSet<Notebook>(
                Arrays.asList(nb1, nb2, nb3, nb4, nb5, nb6, nb7, nb8, nb9, nb10));

        Scanner sc = new Scanner(System.in, "cp866");
        System.out.println();
        System.out.println("Добро пожаловать в интернет-магазин 'Мир Ноутбуков'!\n" +
                "Мы поможем подобрать вам подходящий ноутбук.\n" + 
                "Введите цифру, соответствующую необходимому критерию: \n");
        boolean filter = true;
        while (filter) {
            System.out.println("1 - Выбрать по ОЗУ.\n" +
                    "2 - Выбрать по объему жесткого диска.\n" +
                    "3 - Выбрать по операционной системе.\n" +
                    "4 - Выбрать по цвету.\n" +
                    "5 - Посмотреть все модели.\n" +
                    "0 - Для выхода из каталога.");
       
            String operation = sc.nextLine();
            switch (operation) {
                case "1":
                    filterRAM(notebooks, sc);
                    break;
                case "2":
                    filterHardDisk(notebooks, sc);
                    break;
                case "3":
                    filterOS(notebooks, sc);
                    break;
                case "4":
                    filterColor(notebooks, sc);
                    break;
                case "5":
                    showCatalog(notebooks);
                    break;
                case "0":
                    System.out.println("Ждем вас снова!");
                    filter = false;
                    break;
                default:
                    System.out.println("Введена неправильная операция");
                    System.out.println();
                    break;
            }
        }

    }
    // Функция фильтра по объему ОЗУ
    public static void filterRAM(HashSet<Notebook> notebooks, Scanner scanner) {
        TreeSet<Integer> ram = new TreeSet<>();
        for (Notebook note : notebooks) {
            ram.add(note.getRam());
        }
        System.out.println();
        System.out.println("В нашем каталоге представлены ноутбуки с оперативной памятью "
                + ram.toString().replaceAll("^\\[|\\]$", "") + " Гб\n" +
                "Введите интересующее значение: ");

        String oper = scanner.nextLine();
        int filter = Integer.parseInt(oper);
        if (ram.contains(filter)) {
            System.out.println();
            System.out.println("Подходящие модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getRam() == filter) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Неправильное значение. Попробуйте снова");
            filterRAM(notebooks, scanner);
        }

    }
    // Функция фильтра по объему жесткого диска
    public static void filterHardDisk(HashSet<Notebook> notebooks, Scanner scanner) {
        TreeSet<Integer> hardDisk = new TreeSet<>();
        for (Notebook note : notebooks) {
            hardDisk.add(note.getHardDisk());
        }
        System.out.println();
        System.out.println("В нашем каталоге представлены ноутбуки с объемом жесткого диска "
                + hardDisk.toString().replaceAll("^\\[|\\]$", "") + " Гб\n" +
                "Введите интересующее значение: ");

        String oper = scanner.nextLine();
        int filter = Integer.parseInt(oper);
        if (hardDisk.contains(filter)) {
            System.out.println();
            System.out.println("Подходящие модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getHardDisk() == filter) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Неправильное значение. Попробуйте снова");
            filterHardDisk(notebooks, scanner);
        }
    }
    // Функция поиска по ОС
    public static void filterOS(HashSet<Notebook> notebooks, Scanner scanner) {
        TreeSet<String> operSystems = new TreeSet<>();
        for (Notebook note : notebooks) {
            operSystems.add(note.getOperSystem());
        }
        System.out.println();
        System.out.println("В нашем каталоге представлены операционные системы: "
                + operSystems.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите интересующую ОС: ");

        String oper = scanner.nextLine().toUpperCase();
        if (operSystems.contains(oper)) {
            System.out.println();
            System.out.println("Подходящие модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getOperSystem().equals(oper)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Нет такой ОС. Попробуйте снова");
            filterOS(notebooks, scanner);

        }
    }
    // Функция поиска по цвету
    public static void filterColor(HashSet<Notebook> notebooks, Scanner scanner){
        TreeSet<String> colors = new TreeSet<>();
        for (Notebook note: notebooks){
            colors.add(note.getColor());
        }
        System.out.println();
        System.out.println("В нашем каталоге представлены ноутбуки следующих цветов: "
                + colors.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите интересующий цвет: ");
      
        String oper = scanner.nextLine().toLowerCase();
        if (colors.contains(oper)) {
            System.out.println();
            System.out.println("Подходящие модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getColor().equals(oper)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Нет такого цвета. Попробуйте снова");
            filterColor(notebooks, scanner);
        }
    }
    // Функция вывода полного каталога в консоль
    public static void showCatalog(HashSet<Notebook> notebooks){
        System.out.println();
        System.out.println("Полный каталог ноутбуков: ");
        System.out.println();
        for (Notebook note : notebooks) {
                note.showInfo();
        }
    }
}