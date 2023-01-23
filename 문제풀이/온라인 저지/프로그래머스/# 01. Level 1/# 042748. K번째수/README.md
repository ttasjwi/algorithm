# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042748
- 제목 : K번째수
- 난이도 : Level 1
- commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42748" target="_blank">링크</a>

---

# 필요 지식
- 리스트 처리

---

# 풀이

## Python
```python
def solution(array, commands):
    return [sorted(array[command[0] - 1:command[1]])[command[2] - 1] for command in commands]
```
- 리스트 컴프리헨션과 슬라이싱을 적극적으로 활용


## Java
```java
import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] copied = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(copied);
            answer[i] = copied[commands[i][2] - 1];
        }
        return answer;
    }

}
```
- `Arrays.copyOfRange` : 범위를 지정하여 배열을 복사함
- 정렬 후 지정 인덱스의 요소를 정답 배열에 넣음

---
