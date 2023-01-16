import java.util.StringTokenizer;

public class Solution {
    private int coefficient = 0;
    private int constantTerm = 0;

    public String solution(String polynomial) {
        calculate(polynomial);
        return makeResult();
    }

    private void calculate(String polynomial) {
        StringTokenizer st = new StringTokenizer(polynomial, " + ");

        while(st.hasMoreTokens()) {
            calculateWord(st.nextToken());
        }
    }

    private void calculateWord(String word) {
        if (word.startsWith("x")) {
            coefficient += 1;
            return;
        }

        boolean isCoefficient = false;
        int value = 0;

        for (char ch : word.toCharArray()) {
            if (ch == 'x') {
                isCoefficient = true;
            } else {
                value = value * 10 + ch - 48;
            }
        }

        if (isCoefficient) {
            coefficient += value;
        } else {
            constantTerm += value;
        }
    }

    private String makeResult() {
        StringBuilder sb = new StringBuilder();

        if (coefficient != 0) {
            if (coefficient > 1) {
                sb.append(coefficient);
            }
            sb.append('x');
            if (constantTerm > 0) {
                sb.append(' ').append('+').append(' ').append(constantTerm);
            }
        } else {
            sb.append(constantTerm);
        }
        return sb.toString();
    }

}
