# Programmers 120831 : 짝수의 합
- 난이도 : Level 0
- n이하의 짝수를 모두 더한 값을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120831)

---

## 풀이1
```java
public class Solution1 {

    public int solution(int n) {
        int sum = 0;
        for (int i=2; i<=n; i+=2) {
            sum += i;
        }
        return sum;
    }
}
```
- 반복문

## 풀이2
```java
    public int solution(int n) {
        return IntStream.rangeClosed(1,n)
                .filter(number -> number%2==0)
                .sum();
    }
```
- Stream

---
