# Programmers 120824 : 짝수 홀수 개수
- 난이도 : Level 0
- num_list의 원소 중 짝수와 홀수의 개수를 담은 배열을 return 하도록 solution 함수를 완성해보세요.
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120824)

---

## 풀이1
```java
public class Solution1 {

    public int[] solution(int[] num_list) {
        int evenCount = 0; // 짝수
        int oddCount = 0; // 홀수

        for (int number : num_list) {
            if (number%2 == 0) {
                evenCount ++;
            } else {
                oddCount ++;
            }
        }
        return new int[]{evenCount, oddCount};
    }

}
```

---

## 풀이2
```java
public class Solution2 {

    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        for (int number : num_list) {
            answer[number%2] ++;
        }
        return answer;
    }

}
```

---
