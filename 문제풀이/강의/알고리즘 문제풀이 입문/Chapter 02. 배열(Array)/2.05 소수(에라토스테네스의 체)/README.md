
# 2.05 소수(에라토스테네스의 체)

- 분류 : 배열(Array)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 2.05)

---

## 풀이1 : 내 풀이
```java
    private static int solution(int n) {
        int count = 1; // 2는 소수
        for (int i=3; i<=n; i++) {
            if (isPrimeNumber(i)) {
                count ++;
            }
        }
        return count;
    }

    private static boolean isPrimeNumber(int i) {
        for (int j = 2; j<=Math.sqrt(i); j++) {
            if (i %j == 0) {
                return false;
            }
        }
        return true;
    }
```
- isPrimeNumber : 2부터 자기자신의 제곱근 사이의 수만큼 나누기를 반복하여, 약수가 존재하면 소수가 아님
  - 약수가 존재하지 않으면 소수다

---

## 풀이2: 에라토스테네스의 체
```java
    private static int solution(int n) {
        boolean[] isCompositeNumber = new boolean[n+1];

        for (int i=2; i<=n; i++) {
            if (!isCompositeNumber[i]) { // 소수이면
                for (int j= i*2; j<=n; j += i) {
                    isCompositeNumber[j] = true;
                }
            }
        }
        int count = 0;
        for (int i=2; i<=n; i++) {
            if (!isCompositeNumber[i]) {
                count ++;
            }
        }
        return count;
    }
```
- `isCompositeNumber` : 합성수인 지 여부를 기록하는 배열
- 반복의 시작은 2를 기준으로 시작되는데 2는 소수이므로 처음 판단시 소수로 판단되므로 자연스럽게 로직 적용이 가능하다.
- 2,3,4, ... 반복해서 반복을 돈다.
- `isCompositeNumber` 배열의 해당 인덱스가 false이면 소수라는 뜻이다.
- 자신의 배수 인덱스들을 전부 true로 만든다. (해당 숫자들은 어떤 수의 배수에 해당하므로 합성수다)
- 반복을 전부 돌리고 isCompositeNumber 배열에 저장된 값이 false일 경우 count를 증가시킨다. (소수라는 뜻)

---
