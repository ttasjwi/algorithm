package boj_2920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Answer {

    public static void main(String[] args) throws IOException {

        final int[] ints = Prompt.input(); // 사용자로부터 입력을 받아 숫자들을 배열에 저장한다.
        Prompt.printStatusOf(ints); // 지정 배열의 증감상태를 출력한다.
    }

}

class Prompt {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 사용자로부터 입력을 받아 숫자들을 배열로 반환한다.
    public static int[] input() throws IOException{

        final String input = br.readLine();

        final StringTokenizer st = new StringTokenizer(input, " ");
        final int[] parseInts = new int[st.countTokens()];
        for (int i=0; i < parseInts.length; i++) {
            parseInts[i] = Integer.parseInt(st.nextToken());
        }

        return parseInts;

    }

    // 지정 배열의 증감상태를 출력한다.
    public static void printStatusOf(int[] ints) {
        final String status = MyArrays.getStatus(ints);
        System.out.print(status);
        return;
    }

}

class MyArrays {

    // 증감 상태를 문자열로 반환
    public static String getStatus(int[] ints) {
        if (isAscending(ints)) {
            return "ascending";
        }

        if (isDescending(ints)) {
            return "descending";
        }
        return "mixed";
    }

    // 증가하면 true
    public static boolean isAscending(int[] ints) {
        for (int i=1; i<ints.length; i++) {
            if(ints[i-1]>ints[i]) return false;
        }
        return true;
    }

    // 감소하면 true
    public static boolean isDescending(int[] ints) {
        for (int i=1; i<ints.length; i++) {
            if(ints[i-1]<ints[i]) return false;
        }
        return true;
    }

}