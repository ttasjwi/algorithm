# Programmers 120583 : 중복된 숫자 개수
- 난이도 : Level 0
- array에 n이 몇 개 있는 지
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120583)

---

## 풀이1 : 반복문
```java
    public int solution(int[] array, int n) {
        int answer = 0;
        for (int number : array) {
            if (number == n) {
                answer ++;
            }
        }
        return answer;
    }
```

---

## 풀이2 : Stream 사용
```java
    public int solution(int[] array, int n) {
        return (int) Arrays.stream(array)
                .filter(number -> number == n)
                .count();
    }
```

---
