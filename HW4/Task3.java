package HW4;

import java.util.Scanner;
import java.util.LinkedList;

public class Task3 {
    public static void main(String[] args) {
        LinkedList<Double> res_lst = new LinkedList<Double>();  // Создаем список
        try (Scanner sc = new Scanner(System.in)) {             // Создаем сканер
            System.out.print("Введите первое число: ");
            res_lst.add(sc.nextDouble());  // Добавляем первое число в список
            sc.nextLine();
//  Находимся в цикле, пока запущен калькулятор
            while(true) {  
                System.out.print("Выберите действие ( +, -, *, / ) \n или клавишу [C] для отмены последнего действия: ");
                String Charr = sc.nextLine();     // Вводим действие     

                if ("C".equals(Charr) || "c".equals(Charr)) {  // Если введена отмена, удаляем из списка последний элемент
                    res_lst.removeFirst();

                    if (res_lst.isEmpty()) res_lst.add(0.0);  // Если список пустой, добавляем ноль
                    }
                else {
                    System.out.print("Введите второе число: ");  
                    double Num2 = sc.nextDouble();  //  Добавляем второе число в список

                    calculate(res_lst, Charr, Num2);  //  Проводим расчет
                    sc.nextLine();   //  седующее действие
                    }

                System.out.println("Результат: " + res_lst.getFirst());  // Выводим результат             
            }
        }
    }

    public static void calculate(LinkedList<Double> res_lst, String Charr, double Num2) {  // Ф-ция расчета
        double res = res_lst.getFirst();      //  Переменная для вывода промежуточного результата
        switch (Charr) {                 // Получаем последний добавленный элемент списка и проводим выбранное действие
            
            case "+":
                res_lst.add(0, res_lst.getFirst() + Num2);
                System.out.printf(res + " " + Charr + " " + Num2 + " = " + res_lst.getFirst() + "\n");               
                break;
            
            case "-":
                res_lst.add(0, res_lst.getFirst() - Num2);
                System.out.printf(res + " " + Charr + " " + Num2 + " = " + res_lst.getFirst() + "\n"); 
                break;

            case "*":
                res_lst.add(0, res_lst.getFirst() * Num2);
                System.out.printf(res + " " + Charr + " " + Num2 + " = " + res_lst.getFirst() + "\n");   
                break;
            
            case "/":
                if (Num2 == 0) {       // Исключаем деление на ноль
                    System.out.println("Ошибка! На ноль делить нельзя");
                    break;
                }
                res_lst.add(0, res_lst.getFirst() / Num2);
                System.out.printf(res + " " + Charr + " " + Num2 + " = " + res_lst.getFirst() + "\n");  
                break;
            
            default:
                System.out.println("Ошибка! Повториете ввод! ");
        }
    }
} 
    

