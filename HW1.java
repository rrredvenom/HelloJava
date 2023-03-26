import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Выберите задачу 1,2,3 : ");
        int num = iScanner.nextInt();
        if(num == 1) {Task1();}
        if(num == 2) {Task2();}
        if(num == 3) {Task3();}
        iScanner.close();
        //Task1();//Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
        //Task2();//Вывести все простые числа от 1 до 1000
        //Task3();//Реализовать простой калькулятор
    }

   
     static void Task1(){
        System.out.print("Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)\n");
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите число : ");
        int number = iScanner.nextInt();
        iScanner.close();
        System.out.println("Треугольноe числo " + number + " = " + getTriengle(number));
        System.out.println("Факториал " + number + " = " + getFactorial(number));
        }
        static int getFactorial(int n) {
        if(n==1)return 1;
        return n * getFactorial(n-1);
        }
       
        static int getTriengle(int n) {
        if(n==1)return 1;
        return n + getTriengle(n-1);
        } 
     

    static void Task2(){
        System.out.print("Вывести все простые числа от 1 до 1000\n");
        int n = 1000;
        System.out.printf("Простые числа от 0 до %s : ", n);
        for(int i = 2; i < n; ++i){
            int count = 0;
            for(int j = 2; j <=i && count < 2;++j){
              if(i%j==0){
                ++count;}
            }
            if(count<2) {
               System.out.print(i + " ");}
          }
    }
    static void Task3(){
        System.out.print("Простой калькулятор\n");
        int a;
        int b;
        int res = 0;
        char op;
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите 1е число: ");
        a = sc.nextInt();
        System.out.print("Какое действие вы хотите совершить (+, -, *, /): ");
        op = sc.next().charAt(0);
        System.out.print("Введите 2е число: ");
        b = sc.nextInt();
        sc.close();
        if (op == '+'){
            res = a + b;}
        else if(op == '-') {res = a - b;}
        else if(op == '*') {res = a * b;}
        else if(op == '/') {res = a / b;}
        else System.out.printf("Неверный ввод !");
        System.out.print("\n   Ответ:\n");
        System.out.printf(a + " " + op + " " + b + " = " + res);
    }

}