public class Parse {

    public static String parse(String input) {
        Calc arithmetic = new Calc();
        ChekOperation proverka = new ChekOperation();
        int num1 , num2; // в них храним два наших числа
        String operator; // для оператора
        String result; // для результата
        boolean isRoman; // для проверки римской или арабской цифры
        String[] operands = input.split("[+\\-*/]"); // разбиваем input на массив строк operands, где
        // разделителем служит + - * /.
        if (operands.length != 2) { // Если больше 2х элементов в массиве, то выводим исключение
            throw new IllegalArgumentException("Должно быть 2 операнда! ");
        }
        operator = proverka.detectedOperation(input); // проверяем введен ли оператор, если да, записываем его в operator
        // Если оба числа римские:
        if (ChekRoman.isRoman(operands[0]) && ChekRoman.isRoman(operands[1])){
            // Конвертируем оба числа в арабские
            num1 = ChekRoman.convertToArabian(operands[0]);
            num2 = ChekRoman.convertToArabian(operands[1]);
            isRoman = true;
        }
        // Если оба числа арабские
        else if (!ChekRoman.isRoman(operands[0]) && !ChekRoman.isRoman(operands[1])){
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

        int arabian = arithmetic.calc(num1, num2, operator);
        if (isRoman){
            // Если римское число получилось <= 0, будет ошибка!
            if (arabian <= 0) {
                throw new IllegalArgumentException("Римское число должно быть больше 0!");
            }
            // Конвертируем результат из арабского в римское
            result = ChekRoman.convertToRoman(arabian);
        } else {
            //Конвертируем арабское[int] в String
            result = String.valueOf(arabian);
        }

        return result;
    }
}
