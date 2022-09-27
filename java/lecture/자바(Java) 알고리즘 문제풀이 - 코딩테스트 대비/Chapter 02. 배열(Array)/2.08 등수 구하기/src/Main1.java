import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Result1[] results = new Result1[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            int score = Integer.parseInt(st.nextToken());
            results[i] = new Result1(i, score);
        }
        String answer = solution(results);
        System.out.print(answer);
    }

    private static String solution(Result1[] results) {
        Arrays.sort(results); // 내림차순 정렬
        int[] ranks = new int[results.length];

        int minValue = Integer.MAX_VALUE;
        int currentRank = 1; // 등수
        int sameScoreCount = 0; // 동점자 수

        for (Result1 result : results) {
            if (minValue > result.score) {
                minValue = result.score; // 점수가 더 작아졌으므로 현재 최솟값 갱신
                currentRank += sameScoreCount; // 이전 등수의 동점자수만큼 등수 증가
                ranks[result.originalIndex] = currentRank; // 현재 랭크를 반영

                sameScoreCount = 1; // 동점자 수를 1로 초기화
            } else { // 이전 사람과 비교했을 때 동점일 경우
                ranks[result.originalIndex] = currentRank; // 현재 랭크를 반영
                sameScoreCount ++; // 동점자 수 증가
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int rank : ranks) {
            sb.append(rank).append(' ');
        }
        return sb.toString();
    }
}

class Result1 implements Comparable<Result1> {

    int originalIndex;
    int score;

    public Result1(int originalIndex, int score) {
        this.originalIndex = originalIndex;
        this.score = score;
    }


    @Override
    public int compareTo(Result1 o) {
        return o.score - this.score; // 내림차순
    }
}
