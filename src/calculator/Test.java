package calculator;

import java.util.EmptyStackException;

public class Test {

    public static void main(String[] args) {
        String expression[] = {"1+    1*  2",
                "1+2+3+4+5+6+7+8+9",
                "1*2*3*4*5",
                "1+2*3+2*1",
                "1-1+1-1+1-1+1-2",
                "20/5/4/5",
                "2+1*(2-1+3)-5/4*(3-2/1+4)"
        };
        double result[] = {
                3, 45, 120, 9, -1, 0.2, -0.25, 0
        };
        boolean tests = true;
        for(int i = 0; i < expression.length;i++) {
            Operator operator = new Operator();
            Iterator iterator = new Iterator(expression[i]);
            double num=0;
            Calculator calculator = new Calculator(operator, iterator);
            try {
                num = calculator.getResult();
            } catch (NullPointerException | EmptyStackException e) {
                System.out.println("выражение не обработано");
                System.out.println();
            }
            if(num == result[i])
                System.out.println("Test " + i + " done.");
            else {
                System.out.println("Test " + i + " error!!!!!!! " + num + " != " + result[i]);
                tests = false;
            }

        }
        if(tests)
            System.out.println("Все тесты проедены");
        else
            System.out.println("Ошибка!!!");
    }
}
