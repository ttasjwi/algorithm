# 6.02 버블정렬

- 분류 : 정렬 - 버블정렬
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 6.02)

---

## 버블정렬 (오름차순 기준)
![bubble_sort](bubble_sort.gif)
```java
    private static String solution(int[] numbers, int n) {
        int tmp;
        for (int i=0; i<n-1; i++) { // n-1번 뒷값을 결정한다.
            for (int j=1; j< n-i; j++) {
                if (numbers[j-1] > numbers[j]) {
                    tmp = numbers[j-1];
                    numbers[j-1] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number).append(' ');
        }
        return sb.toString();
    }
```
1. 0번 인덱스부터 n-1번 인덱스까지 연속된 두 데이터를 비교하여 큰 것을 뒤로 스와핑하기를 반복한다.
2. 이렇게 하면 n-1 인덱스에는 최댓값이 자리잡는다.
3. 0번 인덱스부터 n-2 인덱스까지 연속된 두 데이터를 비교하여 큰 것을 뒤로 스와핑하기를 반복한다.
4. 이렇게 하면 n-2 인덱스에는 두번째 최댓값이 자리잡는다.
5. 마찬가지의 방법으로 총 n-1번 반복하면 정렬이 완료된다.

---

## 시간복잡도
- N-1번만큼, 처음부터 스와핑을 반복한다.
- 대강 연산 횟수는 `(n-1) + (n-2) + ... + 1`쯤 된다.
- 근사치로 `N(N+1)/2` 정도 연산을 수행한다.
- 빅오 표기법으로 `O(N^2)`의 시간복잡도를 가진다.
- 매번 스와핑을 하는 시간비용도 있고, 선택정렬보다 더 느릴듯.

---
