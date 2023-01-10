
# 2.02 보이는 학생

- 분류 : 배열(Array)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 2.02)

---

## 풀이
```java
    private static int solution(int[] numbers) {
        int count = 0;
        int maxValue = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > maxValue) {
                count ++;
                maxValue = number;
            }
        }
        return count;
    }
```
- 값을 순서대로 읽고 최댓값보다 클 때마다 count를 증가시키고 최댓값을 갱신한다.

---