package Published.Expressions.ExpressionEvaluations;

import java.util.Stack;

public class PrefixEvaluation {

    public static Double evaluate(double a, double b, char operator){
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (a == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return b / a;
        }
        return 0.0;
    }
    public static Double convert(String expression) {

        StringBuilder input = new StringBuilder(expression);
        input.reverse();

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            //check if it is a space (separator)
            if(c==' ')
                continue;

            if (c == '*' || c == '/' || c == '^' || c == '+' || c == '-') {
                double s1 = stack.pop();
                double s2 = stack.pop();
                double temp = evaluate(s2, s1, c);
                stack.push(temp);
            } else {
                //if here means, its a digit

                //extract the characters and store it in num
                StringBuffer temp = new StringBuffer();
                while(Character.isDigit(c)) {
                    temp.append(c);
                    i++;
                    c = input.charAt(i);
                }
                i--;
                //push the number in stack
                double num = Double.parseDouble(temp.reverse().toString());
                stack.push(num);
            }
        }
        double result = stack.pop();
        return result;
    }

    public static void main(String[] args) {
        String exp = "- / * 20 * 50 + 3 6 300 2";
        System.out.println("Prefix Expression: " + exp);
        System.out.println("Evaluation: " + convert(exp));
    }
}

