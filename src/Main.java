import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите операцию с двумя числами: ");
        String input = scanner.nextLine();
        System.out.println("Ответ: " + parse(input));
    }
    public static String parse(String input) {
        int num1 , num2; // в них храним два наших числа
        String operator; // для оператора
        String result; // для результата
        boolean isRoman; // для проверки римской или арабской цифры
        String[] operands = input.split("[+\\-*/]"); // разбиваем input на массив строк operands, где
        // разделителем служит + - * /.
        if (operands.length != 2) { // Если больше 2х элементов в массиве, то выводим исключение
            throw new IllegalArgumentException("Должно быть 2 операнда! ");
        }
        operator = detectedOperation(input); // проверяем введен ли оператор, если да, записываем его в operator
        // Если оба числа римские:
        if (RomanNum.isRoman(operands[0]) && RomanNum.isRoman(operands[1])){
            // Конвертируем оба числа в арабские
            num1 = RomanNum.convertToArabian(operands[0]);
            num2 = RomanNum.convertToArabian(operands[1]);
            isRoman = true;
        }
        // Если оба числа арабские
        else if (!RomanNum.isRoman(operands[0]) && !RomanNum.isRoman(operands[1])){
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[1]);
            isRoman = false;
        }
        // Если одно число римское, а второе арабское:
        else {
            throw new IllegalArgumentException("Числа должны быть одного формата");
        }
        if (num1 >10 || num2 >10 || num1 < 1 || num2 < 1) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10");
        }

        int arabian = calc(num1, num2, operator);
        if (isRoman){
            // Если римское число получилось <= 0, будет ошибка!
            if (arabian <= 0) {
                throw new IllegalArgumentException("Римское число должно быть больше 0!");
            }
            // Конвертируем результат из арабского в римское
            result = RomanNum.convertToRoman(arabian);
        } else {
            //Конвертируем арабское[int] в String
            result = String.valueOf(arabian);
        }

        return result;
    }

    // Метод, проверяющий какой оператор ввёл пользователь. (из четырёх возможных +-*/)
    public static String detectedOperation (String input){
        if (input.contains("+")) return "+"; // сontains - Eсли строка содержит + , то возвращаем + и тд...
        else if (input.contains("-")) return "-";
        else if (input.contains("*")) return "*";
        else if (input.contains("/")) return "/";
        else return null; // Если ввели другой символ...
    }
    public static int calc (int a, int b, String operator){
        if(operator.equals("+")) return a + b;
        if(operator.equals("-")) return a - b;
        if(operator.equals("*")) return a * b;
        if(operator.equals("/") && b == 0) {
            throw new IllegalArgumentException("деление на 0 запрещено!");
        } else return a / b;
    }
}
class RomanNum {
    // создаём массив с римскими цифрами от 1 до 10. (Каждое чтсло будет соотв. своему индексу)
    static String[] romanArray = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
    // создаём метод, с помощью которого будем проверять, арабские или римские цифры введены
    public static boolean isRoman(String value){
        for(int i = 0; i < romanArray.length; i++){
            if(value.equals(romanArray[i])){
                return true;
            }
        }
        return false;
    }
    public static int convertToArabian(String roman){
        for (int i = 0; i<romanArray.length; i++){
            if (roman.equals(romanArray[i])){ // V == 5
                return i; //т.к. соответствует индексу :)
            }
        }
        return -1; // -1 будет означать, что число не найдено...
    }
    public static String convertToRoman(int arabian){
        return romanArray[arabian]; // Если индекс 5, вернет V
    }
}