---
# 프로그래머스 - K번째 수
https://programmers.co.kr/learn/courses/30/lessons/42748

---

## 풀이1 - 내 풀이
```
import java.util.stream.IntStream;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {

        int COUNT_OF_COMMANDS = commands.length;
        int[] answer = new int[COUNT_OF_COMMANDS];

        for (int i=0; i<COUNT_OF_COMMANDS; i++) {
            answer[i] = IntStream.of(array)
                    .limit(commands[i][1]) // 제한 : 끝 인덱스
                    .skip(commands[i][0]-1)
                    .sorted()
                    .toArray()[commands[i][2]-1];
        }
        return answer;
    }

}
```
Stream을 활용했다.
- commands의 길이만큼 `int[] answer`을 생성
- array 기반으로 IntStream을 생성한다.
- skip, limit으로 시작, 끝을 설정한다.
- sorted로 정렬
- 배열로 반환한뒤 지정 인덱스의 값을 answer에 추가한다.

---