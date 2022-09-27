
# 프로그래머스 - 모의고사

https://programmers.co.kr/learn/courses/30/lessons/42840

---

# 풀이1 : 내 풀이
```
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] solution(int[] answers) {
        int[] counter = counting(answers); // 점수를 배열에 집계

        Map<Integer, Integer> counts = new HashMap<>();

        int max = Integer.MIN_VALUE;

        for (int i=0; i< counter.length; i++) {
            counts.put(i, counter[i]); // 인덱스에 대응되는 count를 Map에 추가
            if (counter[i] > max) max = counter[i]; // 최댓값 갱신 
        }

        int finalMax = max; // 위에서 구한 최댓값을 상수로 함(Stream 쓰려고)

        return counts.entrySet().stream()
                .filter(e -> e.getValue() == finalMax) // 최댓값보다 작은 entry는 필터링
                .map(Map.Entry::getKey) // key로 map
                .mapToInt(k -> k + 1) // key값에 1 증가
                .toArray(); // 배열로 반환
    }

    private int[] counting(int[] answers) {
        int[] counter = new int[3];

        int[][] patterns = {
                {1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}
        };

        for (int i = 0; i< answers.length; i ++) { // 각 문제별로
            for (int j=0; j<patterns.length; j++) {
                if(patterns[j][i%patterns[j].length] == answers[i])
                    counter[j] ++;
            }
        }
        return counter;
    }

}
```

- 각 패턴별 반복 주기를 나눈 나머지를 기준으로 정답 여부 판단
- 점숫 최댓값 구하기
- 최댓값보다 작은 값 필터링

---