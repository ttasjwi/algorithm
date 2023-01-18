# \[BOJ 12847\] 꿀 아르바이트

- 난이도 : Silver4
- 슬라이딩 윈도우
- 문제 : <a href="https://www.acmicpc.net/problem/12847" target="_blank"> [링크]</a>

---  

## 풀이
```java
   public static void main(String[] args) throws IOException {
        int n = readInt();
        int m = readInt();
        int[] numbers = new int[n];

        long sum = 0;
        for (int i=0; i<n; i++) {
            numbers[i] = readInt();
        }
        
        // 후술
```
- 숫자들을 입력 받을 때, 배열에 값을 저장한다.
```java
        for (int i=0; i<m; i++) {
            sum += numbers[i];
        }
        long maxSum = sum;
```
- 이 때, 처음 m개는 합을 미리 구해둔다.
- maxSum을 sum으로 갱신한다.
```java
        for (int i=m; i<n; i++) {
            sum -= numbers[i-m];
            sum += numbers[i];

            maxSum = Math.max(maxSum, sum);
        }
        System.out.print(maxSum);
    }
```
- 그 이후부터 윈도우를 밀어가면서, 최댓값을 갱신한다.

---
