public class ChekRoman {
    private static String[] arr = RomanArray.getRomanArray();

    // создаём метод, с помощью которого будем проверять, арабские или римские цифры введены
    public static boolean isRoman(String value){
        for(int i = 0; i < arr.length; i++){
            if(value.equals(arr[i])){
                return true;
            }
        }
        return false;
    }
    public static int convertToArabian(String roman){
        for (int i = 0; i<arr.length; i++){
            if (roman.equals(arr[i])){ // V == 5
                return i; //т.к. соответствует индексу :)
            }
        }
        return -1; // -1 будет означать, что число не найдено...
    }
    public static String convertToRoman(int arabian){
        return arr[arabian]; // Если индекс 5, вернет V
    }
}