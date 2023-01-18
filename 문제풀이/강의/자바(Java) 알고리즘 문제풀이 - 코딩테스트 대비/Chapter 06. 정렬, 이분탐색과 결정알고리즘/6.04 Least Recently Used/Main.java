import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken()); // 캐시의 크기
        int n = Integer.parseInt(st.nextToken()); // 작업의 갯수

        int[] cache = new int[s];
        int[] works = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        br.close();

        for (int i=0; i<n; i++) {
            works[i] = Integer.parseInt(st.nextToken());
        }

        String answer = solution(cache, works, s);
        System.out.print(answer);
    }

    // 로직을 수행하고 출력 문자열을 생성한다.
    private static String solution(int[] cache, int[] works, int s) {
        logic(cache, works, s);
        StringBuilder sb = new StringBuilder();
        for (int i : cache) {
            sb.append(i).append(' ');
        }
        return sb.toString();
    }

    // 순서대로 LRU 캐싱 알고리즘을 수행한다.
    private static void logic(int[] cache, int[] works, int s) {
        for (int work : works) {
            int sameWorkIndex = findSameWorkIndex(cache, s, work);
            if (sameWorkIndex == -1) {
                cacheMiss(cache, s, work);
            } else {
                cacheHit(cache, s, sameWorkIndex, work);
            }
        }
    }

    // 같은 work가 위치한 인덱스를 찾는다.
    private static int findSameWorkIndex(int[] cache, int s, int work) {
        for (int i=0; i<s; i++) {
            if (cache[i] == work) {
                return i;
            }
        }
        return -1;
    }

    // 배열 끝까지 모든 요소를 뒤로 민뒤, 0번 인덱스에 새 작업을 삽입한다.
    private static void cacheMiss(int[] cache, int s, int work) {
        pushToRight(cache, s, s-1);
        cache[0] = work;
    }

    // 이미 work가 위치해있던 인덱스까지 모든 요소를 밀어버리고 0번 인덱스에 work를 삽입한다.
    private static void cacheHit(int[] cache, int s, int sameWorkIndex, int work) {
        pushToRight(cache, s, sameWorkIndex);
        cache[0] = work;
    }

    // pushEnd 인덱스까지 값들을 밀어버린다.
    private static void pushToRight(int[] cache, int s, int pushEnd) {
        if (pushEnd >= s) {
            pushEnd = s-1;
        }
        int i;
        for (i= pushEnd; i>=1; i--) {
            cache[i] = cache[i-1];
        }
    }

}
