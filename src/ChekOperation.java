public class ChekOperation {

    // Метод, проверяющий какой оператор ввёл пользователь. (из четырёх возможных +-*/)
    public String detectedOperation (String input){
        if (input.contains("+")) return "+"; // сontains - Eсли строка содержит + , то возвращаем + и тд...
        else if (input.contains("-")) return "-";
        else if (input.contains("*")) return "*";
        else if (input.contains("/")) return "/";
        else return null; // Если ввели другой символ...
    }

}

