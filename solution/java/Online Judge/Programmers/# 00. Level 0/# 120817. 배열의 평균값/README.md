# Programmers 120817 : 배열의 평균값
- 난이도 : Level 0
- numbers의 원소의 평균값을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120817)

---

## 풀이1
```java
public class Solution1 {
    public double solution(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum/(double)numbers.length;
    }
}
```
- 배열을 전부 순회하여, 합을 구하고 평균으로 나누기

## 풀이2
```java
import java.util.Arrays;

public class Solution2 {
    public double solution(int[] numbers) {
        return Arrays.stream(numbers)
                .average()
                .getAsDouble();
    }
}
```
- Stream 사용

---
