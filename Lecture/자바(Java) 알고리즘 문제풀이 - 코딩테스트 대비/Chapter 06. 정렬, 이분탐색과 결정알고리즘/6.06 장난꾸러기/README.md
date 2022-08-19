# 6.06 장난꾸러기

- 분류 : 정렬
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 6.06)

---

## 풀이
```java
    private static String solution(int[] numbers, int n) {
        int[] copy = numbers.clone();
        Arrays.sort(copy);
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) {
            if (numbers[i] != copy[i]) {
                sb.append(i).append(' ');
            }
        }
        return sb.toString();
    }
```
- 배열을 복사하고, 오름차순 정렬한다.
- 각 인덱스의 데이터를 비교하여, 다른 값이 있는 두 부분이 순서대로 철수, 짝꿍이다.

---
