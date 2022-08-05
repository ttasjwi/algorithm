
# 2.04 피보나치 수열

- 분류 : 배열(Array)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 2.04)

---

## 풀이
```java
    private static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int[] numbers = new int[n];
        numbers[0] = 1;
        numbers[1] = 1;

        sb.append(numbers[0]).append(' ').append(numbers[1]).append(' ');

        for (int i=2; i<numbers.length; i++) {
        numbers[i] = numbers[i-2] + numbers[i-1];
        sb.append(numbers[i]).append(' ');
        }
        return sb.toString();
        }
```
- 0,1번 인덱스를 1로 초기화
- 반복문 돌려서 앞의 두개 읽고 현재 항을 구하고 StringBuilder에 덧붙이기

---
