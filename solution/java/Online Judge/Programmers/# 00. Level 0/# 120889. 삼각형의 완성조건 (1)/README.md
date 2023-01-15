# 문제
- 번호 : 120889
- 제목 : 삼각형의 완성조건 (1)
- 난이도 : Level 0
- 세 변으로 삼각형을 만들 수 있다면 1, 만들 수 없다면 2
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120889)

---

# 필요 알고리즘
- 단순 반복
- 정렬?

---

## 풀이1
```java
public class Solution1 {
    public int solution(int[] sides) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int side : sides) {
            sum += side;
            if (side > max) {
                max = side;
            }
        }
        return (max < sum - max)
                ? 1
                : 2;

    }
}

```
- 0.01ms ~ 0.03ms
- 배열을 한번 순회하면 되므로 풀이2보다 더 빠르다.

## 풀이2
```java
import java.util.Arrays;

public class Solution2 {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        return (sides[2] < sides[0] + sides[1])
                ? 1
                : 2;
    }
}
```
- 0.31ms ~ 0.47ms
- 전체 정렬을 해야하므로 시간비용이 발생한다

---
