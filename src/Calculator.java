import java.util.Scanner;
public  class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operation calc = new Operation();

        System.out.println("Введите первое число: ");
        calc.setNum1(scanner.nextDouble());

        System.out.println("Какую операцию вы хотите выполнить? (+ , - , * , /)");
        calc.setOperator(scanner.next().charAt(0));

        System.out.println("Введите второе число: ");
        calc.setNum2(scanner.nextDouble());

        System.out.println("Результат равен: " + calc.operation());
    }
}