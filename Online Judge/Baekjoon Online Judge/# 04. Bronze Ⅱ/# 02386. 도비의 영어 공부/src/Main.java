import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();

        char[] inputs;
        char search;
        int count;

        while (true) {
            inputs = br.readLine().toLowerCase().toCharArray(); // 라인을 읽어오고 모두 소문자화, 그리고 배열에 문자단위로 저장
            search = inputs[0]; // 첫번째 문자로 검색
            if (search == '#') break; // 첫번째 문자가 '#'이면 반복을 탈출함.
            count = 0;
            for (int i =1; i < inputs.length; i++) {
                if (inputs[i] == search) count ++; // search와 일치하면, count 증가
            }
            sb.append(search).append(' ').append(count).append('\n'); // search와 count를 StringBuilder에 추가
        }
        br.close();
        System.out.println(sb); // StringBuilder 출력
    }
}
