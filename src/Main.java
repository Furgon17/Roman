import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите операцию с двумя числами: ");
        String input = scanner.nextLine();
        System.out.println("Ответ: " + Parse.parse(input));
    }
}


