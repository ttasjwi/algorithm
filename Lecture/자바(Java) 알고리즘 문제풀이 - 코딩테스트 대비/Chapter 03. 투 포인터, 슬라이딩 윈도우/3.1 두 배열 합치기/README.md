
# 3.1 두 배열 합치기

- 분류 : 투 포인터(Two Pointers)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 3.1)

---

## 알고리즘 개요
- 두 배열을 덧붙인 뒤 정렬한다면 퀵 정렬 기준 `o(nlogn)`의 시간복잡도를 가진다.
- 정렬된 두 배열을 정렬할 때는 투 포인터 알고리즘을 사용하면 `o(n)`의 시간복잡도로 정렬을 할 수 있다.

---

## 풀이 : 투 포인터 사용
```java
    private static String solution(int[] numbers1, int n, int[] numbers2, int m) {
        StringBuilder sb = new StringBuilder();
        int p1=0; //numbers1의 포인터
        int p2=0; //numbers2의 포인터

        while(p1 < n || p2 < m) {
            if (p1 == n) {
                sb.append(numbers2[p2++]).append(' ');
                continue;
            }
            if (p2 == m) {
                sb.append(numbers1[p1++]).append(' ');
                continue;
            }
            if (numbers1[p1] <= numbers2[p2]) {
                sb.append(numbers1[p1++]).append(' ');
            } else {
                sb.append(numbers2[p2++]).append(' ');
            }
        }
        return sb.toString();
    }
```
- 배열1의 포인터, 배열2의 포인터를 둔다.
- 포인터가 위치한 곳의 값을 비교 후 더 작은 값을 StringBuilder에 덧붙인 뒤, 포인터를 다음으로 이동시킨다.

---
