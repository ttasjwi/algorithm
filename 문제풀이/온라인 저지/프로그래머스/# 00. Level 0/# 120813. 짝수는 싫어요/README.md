# Programmers 120813 : 짝수는 싫어요
- 난이도 : Level 0
- n 이하의 홀수가 오름차순으로 담긴 배열 반환
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120813)

---

## 풀이1 : 순수하게 배열 사용
```java
public class Solution1 {
    public int[] solution(int n) {
        int length = (n % 2 == 0)
                ? n / 2
                : n / 2 + 1;

        int[] answer = new int[length];
        for (int i=0; i<length; i++) {
            answer[i] = 2*i + 1;
        }
        return answer;
    }
}
```
- n이 짝수냐 홀수냐에 따라 배열의 길이가 달라짐에 주의하여 고정배열을 생성하고, 값을 채워넣는다.

## 풀이2 : IntStream 사용
```java
import java.util.stream.IntStream;

public class Solution2 {
    public int[] solution(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(number -> number % 2 == 1)
                .toArray();
    }
}
```

---
