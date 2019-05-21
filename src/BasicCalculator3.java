import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class BasicCalculator3 {
    public int calculate(String s) {
        Deque<Integer> operands = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int val = Character.getNumericValue(s.charAt(i));
                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    val = val * 10 + Character.getNumericValue(s.charAt(i + 1));
                    i++;
                }
                operands.push(val);
            } else if (c == ' ') {
                continue;
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (operators.peek() != '(') {
                    operands.push(operate(operands, operators));
                }
                operators.pop();
            } else {
                while (!operators.isEmpty() && comparePrecedence(c, operators.peek()) <= 0) {
                    operands.push(operate(operands, operators));
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            operands.push(operate(operands, operators));
        }

        return operands.pop();
    }

    private int comparePrecedence(char a, char b) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', -1);
        map.put('+', 0);
        map.put('-', 0);
        map.put('*', 1);
        map.put('/', 1);
        return map.get(a) - map.get(b);
    }

    private int operate(Deque<Integer> operands, Deque<Character> operators) {
        int a = operands.pop();
        int b = operands.pop();
        char c = operators.pop();

        switch(c) {
            case '+' : return a + b;
            case '-': return b - a;
            case '*': return a * b;
            case '/': return b / a;
            default: return 0;
        }
    }
}
