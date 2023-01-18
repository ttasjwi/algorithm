# Programmers 120833 : 배열 자르기

- 난이도 : Level 0
- numbers의 num1번 째 인덱스부터 num2번째 인덱스까지 자른 정수 배열을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120833)

---

## 풀이1
```java
public class Solution1 {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = new int[num2-num1+1];
        for (int i=0; i<answer.length; i++) {
            answer[i] = numbers[i+num1];
        }
        return answer;
    }
}
```
- 배열의 길이를 계산해서 순서대로 채워넣는다.

## 풀이2
```java
public class Solution2 {
    public int[] solution(int[] numbers, int num1, int num2) {
        return Arrays.copyOfRange(numbers, num1, num2+1);
    }
}
```
- Arrays.copyOfRange 메서드 사용

---
