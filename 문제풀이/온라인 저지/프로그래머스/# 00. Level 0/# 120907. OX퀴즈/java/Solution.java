public class Solution {

    private static final String ANSWER_MARK = "O";
    private static final String WRONG_MARK = "X";

    public String[] solution(String[] quizs) {
        String[] answer = new String[quizs.length];
        for (int i=0; i<quizs.length; i++) {
            answer[i] = isAnswer(quizs[i]) ? ANSWER_MARK : WRONG_MARK;
        }
        return answer;
    }

    private boolean isAnswer(String quiz) {
        String[] splited = quiz.split(" ");
        // 0번 : 피제수 1
        // 1번 : 연산자
        // 2번 : 피제수 2
        // 3번 : =
        // 4번 : 결과

        return Integer.parseInt(splited[0]) + getSign(splited[1]) * Integer.parseInt(splited[2])
                == Integer.parseInt(splited[4]);
    }

    private int getSign(String operator) {
        return (operator.charAt(0) == '+')
                ? 1
                : -1;
    }

}
