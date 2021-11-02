package boj_9498;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Prompt {
    void run()  {
        int score = inputScore(); // 점수 입력
        String grade = getGrade(score); // 점수를 기반으로, grade 반환
        System.out.println(grade); // grade 출력
    }

    // 사용자로부터 점수를 입력받고 이를 int 타입 변수에 저장해 반환한다.
    private int inputScore()  {
        int score = 0;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            score = Integer.parseInt(br.readLine());
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return score;
    }

    // 지정 점수를 통해 등급(F,D,C,B,A)을 반환받는다.
    private String getGrade(int score) {
        String grade = "F";

        if (60<=score&&score<70) grade = "D";
        if (70<=score&&score<80) grade = "C";
        if (80<=score&&score<90) grade = "B";
        if (90<=score&&score<=100) grade = "A";
        return grade;
    }
}