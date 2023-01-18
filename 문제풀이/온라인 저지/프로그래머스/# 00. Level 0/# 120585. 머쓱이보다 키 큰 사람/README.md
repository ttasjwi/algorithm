# Programmers 120585 : 머쓱이보다 키 큰 사람
- 난이도 : Level 0
- 키가 담긴 정수 배열 array와 머쓱이의 키 height가 매개변수로 주어질 때, 머쓱이보다 키 큰 사람 수를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120585)

---

## 풀이1
```java
    public int solution(int[] array, int height) {
        int answer = 0;
        for (int h : array) {
            if (h > height) {
                answer ++;
            }
        }
        return answer;
    }
```
- 반복 순회하면서, 키가 더 크면 answer 증가

---

## 풀이2
```java
    public int solution(int[] array, int height) {
        return (int) Arrays.stream(array)
                .filter(h -> h > height)
                .count();
    }
```
- Stream으로 필터링 후, 카운팅

---
