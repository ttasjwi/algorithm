# Programmers 120912 : 7의 개수
- 난이도 : Level 0
- 정수 배열 array가 매개변수로 주어질 때, 7이 총 몇 개 있는지 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120912)

---

## 풀이1
```java
public class Solution1 {
    public int solution(int[] array) {
        int answer = 0;
        for (int number : array) {
            answer += countSeven(number);
        }
        return answer;
    }

    private int countSeven(int number) {
        int count = 0;
        while (number > 0) {
            if (number%10 == 7) {
                count ++;
            }
            number /= 10;
        }
        return count;
    }
}
```
- 숫자를 10으로 나눠가면서, 끝자리가 7이면 count를 증가시킨다.

---

## 풀이2 : Stream 사용
```java
public class Solution2 {
    public int solution(int[] array) {
        return Arrays.stream(array)
                .map(this::countSeven)
                .sum();
    }

    private int countSeven(int number) {
        int count = 0;
        while (number > 0) {
            if (number%10 == 7) {
                count ++;
            }
            number /= 10;
        }
        return count;
    }
}
```
- 앞의 내용에 Stream을 더한 것

---
