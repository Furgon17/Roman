public class Calc {
    public int calc (int a, int b, String operator){
        if(operator.equals("+")) return a + b;
        if(operator.equals("-")) return a - b;
        if(operator.equals("*")) return a * b;
        if(operator.equals("/") && b == 0) {
            throw new IllegalArgumentException("деление на 0 запрещено!");
        } else return a / b;
    }
}
