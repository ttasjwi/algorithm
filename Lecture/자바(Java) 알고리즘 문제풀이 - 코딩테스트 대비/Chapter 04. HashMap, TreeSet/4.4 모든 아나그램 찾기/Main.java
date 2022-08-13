import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        br.close();

        int answer = solution(s, t);
        System.out.print(answer);
    }

    private static int solution(String s, String t) {
        int count = 0;
        int sl = s.length();
        int tl = t.length();

        // t 카운팅
        HashMap<Character, Integer> tCounter = new HashMap<>();
        for (int i=0; i<tl; i++) {
            tCounter.put(t.charAt(i), tCounter.getOrDefault(t.charAt(i), 0) + 1);
        }

        // s의 앞부분 카운팅
        HashMap<Character, Integer> sCounter = new HashMap<>();
        for (int i=0; i<tl; i++) {
            sCounter.put(s.charAt(i), sCounter.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (tCounter.equals(sCounter)) {
            count ++;
        }

        // 슬라이딩
        for (int i=tl; i<sl; i++) {
            if (sCounter.get(s.charAt(i-tl)) == 1) {
                sCounter.remove(s.charAt(i-tl));
            } else {
                sCounter.put(s.charAt(i-tl), sCounter.get(s.charAt(i-tl)) - 1);
            }
            sCounter.put(s.charAt(i), sCounter.getOrDefault(s.charAt(i), 0) + 1);

            if (tCounter.equals(sCounter)) {
                count ++;
            }
        }
        return count;
    }
}
