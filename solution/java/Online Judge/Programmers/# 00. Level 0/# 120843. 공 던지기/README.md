# 문제
- 번호 : 120843
- 제목 : 공 던지기
- 난이도 : Level 0
- 정수 배열 numbers와 정수 K가 주어질 때, k번째로 공을 던지는 사람의 번호는 무엇인지 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120843)

---

# 필요 알고리즘
- 기본적인 반복문
- 주기성(나머지)

---

# 풀이
```java
public class Solution {

    public int solution(int[] numbers, int k) {
        int current = 0;
        for (int i=1; i<k; i++) {
            current = (current+2)%numbers.length;
        }
        return numbers[current];
    }
}
```
- 처음에 공을 잡는 사람의 인덱스는 0번 인덱스
- 다음 사람의 인덱스는 2씩 증가하되, 배열의 길이만큼 주기가 반복되므로, 배열의 길이로 나눈 나머지의 인덱스가 다음의 사람이다.

---
