# 6.01 선택정렬

- 분류 : 정렬 - 선택정렬
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 6.01)

---

## 선택 정렬 (오름차순 기준)

```java
    private static String solution(int[] numbers, int n) {
        StringBuilder sb = new StringBuilder();
        int idx;
        int tmp;
        for (int i=0; i<n; i++) {
            // i번 인덱스의 값을 정함
            idx = i;
            for (int j=i+1; j<n; j++) {
                if (numbers[idx] > numbers[j]) {
                    idx = j;
                }
            }
            tmp = numbers[i];
            numbers[i] = numbers[idx];
            numbers[idx] = tmp;

            sb.append(numbers[i]).append(' ');
        }
        return sb.toString();
    }
```
1. 주어진 리스트를 쭉 탐색하여, 최솟값을 찾아 0번 인덱스의 데이터와 교체한다.
2. 0번 데이터를 제외한 나머지 리스트에서 최솟값을 찾아, 1번 인덱스의 데이터와 교체한다.
3. 0,1번 데이터를 제외한 나머지 리스트에서 최솟값을 찾아, 2번 인덱스의 데이터와 교체한다.
4. 마찬가지의 방법으로 n-1번 반복하면 오름차순 정렬이 완료된다.

---

## 시간복잡도
- N-1번만큼 가장 작은 수를 찾아서 맨 앞으로 보내야한다.
- 대강 연산 횟수는 `N + N-1 + ... + 2` 정도가 된다.
- 근사치로 `N(N+1)/2` 정도의 연산을 수행한다.
- 빅오 표기법으로 `O(N^2)`의 시간복잡도를 가진다.

---
