# \[BOJ 1929\] 소수 구하기

- 난이도 : Silver 3
- 요구사항 : m 이상 n 이하 소수를 모두 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1929" target="_blank"> [링크]</a>

---  

## 풀이
```java
    public static void main(String[] args) throws IOException {
        int m = readInt(); // 시작 범위
        int n = readInt(); // 끝 범위

        boolean[] isCompositeNumber = new boolean[1_000_001];
        isCompositeNumber[1] = true;

        for (int i = 2; i <= n; i++) {
            if (!isCompositeNumber[i]) {
                for (int j = i + i; j <= n; j += i) {
                    isCompositeNumber[j] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (!isCompositeNumber[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.print(sb);
    }
```
- 특정 범위 내의 소수들을 구하는 문제이므로, "에라토스테네스의 체" 알고리즘을 적용한다.
- `isCompositeNumber` : 합성수인가?
- 1은 합성수 취급한다.
- i에 대해서, 2부터 n까지 다음을 반복한다.
  - `isCompositeNumber[i]`가 false이면 소수라는 뜻이다. 해당 수의 배수들을 모두 합성수 처리 한다.
- 소수들을 순차적으로 출력한다.
