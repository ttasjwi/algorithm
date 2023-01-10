
# \[BOJ 01037\] 약수

- 난이도 : Bronze1
- '어떤 수'의 약수들(1, 자기자신 제외)이 주어졌을 때 '어떤 수' 찾기 
- 문제: <a href="https://www.acmicpc.net/problem/1037" target="_blank"> [링크]</a>

---

## 풀이
```java
    public static void main(String[] args) throws IOException {
        int n = readInt();

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            int value = readInt();
            maxValue = Math.max(value, maxValue);
            minValue = Math.min(value, minValue);
        }
        int answer = minValue * maxValue;
        System.out.print(answer);
    }
```
- 정수의 약수들을 작은 것부터 정렬 했을 때, 대칭된 숫자의 곱이 원래 값이다.
- 즉, '진짜 약수들'(1, 자기 자신 제외한 약수들) 기준으로 최솟값, 최댓값의 곱이 원래 수이다.
- 최대, 최소를 계속 저장/갱신하면서 구한 뒤 곱하면 됨

---
