package HW5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Map<String, ArrayList<String>> phoneBook = new HashMap<>();
        Scanner scn = new Scanner(System.in, "cp866");

        boolean book = true;

        while (book) {
            System.out.println();
            System.out.println("Введите команду:\n1- Добавление номера.\n" +
                    "2- Вывод всего.\n" +
                    "0- Выйти из записной книги.");
            String operation = scn.nextLine();
            switch (operation) {
                case "1":
                    addContact(phoneBook, scn);
                    break;
                case "2":
                    showAllContacts(phoneBook);
                    break;
                case "0":
                    book = false;
                    System.out.println("Вы вышли из программы.");
                    break;
                default:
                    System.out.println("Неверная операция.");
                    break;
            }
        }
    }

    // Функция добавления нового контакта
    public static void addContact(Map<String, ArrayList<String>> db, Scanner scanner) {
        System.out.println();
        ArrayList<String> phone_number = new ArrayList<>();
        System.out.println("Введите ФИО контакта: ");
        String name = scanner.nextLine().toUpperCase();
        System.out.println();
        System.out.println("Введите введите номер телефона: ");
        String number = scanner.nextLine();
        if (!db.containsKey(name)) {
            // phone_number.add(number);
            db.put(name, phone_number);
        }
        db.get(name).add(number);

    }

    // Функция вывода всей телефонной книги
    public static void showAllContacts(Map<String, ArrayList<String>> book) {
        System.out.println();
        for (String name : book.keySet()) {
            System.out.printf(name + ":\n");
            ArrayList<String> phones = book.get(name);
            for (String phone : phones) {
                System.out.printf(phone + "\n");
            }
            System.out.println();
        }
    }
}