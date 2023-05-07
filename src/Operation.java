public class Operation {
    private double num1;
    public void setNum1(double num1) {
        this.num1 = num1;
    }
    private double num2;
    public void setNum2(double num2) {
        this.num2 = num2;
    }

    private char operator;
    public void setOperator(char operator) {
        this.operator = operator;
    }
    public char getOperator() {
        return operator;
    }
     public double operation() {
        double result = 0;
        if (operator == '+'){
            result = num1 + num2;
        } if (operator == '-'){
            result = num1 - num2;
        } if (operator == '*'){
            result = num1 * num2;
        } if (operator == '/' && num2 == 0){
            throw new ArithmeticException("Делить на 0 нельзя!");// исключение, если делим на 0!
         }if (operator == '/'){
             result = num1 / num2;}
        if(operator != '+' && operator != '-' && operator != '*' && operator != '/') {
            System.out.println("Вы ввели неверный оператор: " + operator + " !");
        }
        return result;
    }

}
