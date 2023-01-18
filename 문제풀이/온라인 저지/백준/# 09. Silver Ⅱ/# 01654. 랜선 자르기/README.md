# \[BOJ 1654\] 랜선 자르기

- 난이도 : Silver 2
- 매개변수 탐색
- 문제 : <a href="https://www.acmicpc.net/problem/1654" target="_blank"> [링크]</a>

---  

## 풀이
```java
    public static void main(String[] args) throws IOException {
        int k = readInt(); // 가진 랜선의 갯수 (1<=k<=10000)
        int n = readInt(); // 만들어야하는 랜선의 갯수 (1<=n<=10000000)

        int[] lengths = new int[k]; // 가진 랜선의 길이들

        long lt = 1;
        long rt = 0;
        for (int i=0; i<k; i++) {
            lengths[i] = readInt();
            rt = Math.max(rt, lengths[i]);
        }
        long answer = 0;

        long mid;
        long count;
        boolean success;
        while (lt<=rt) {
            mid = (lt +rt) >> 1; // 탐색 대상 : 랜선의 길이
            success = false;
            count = 0;
            for (int length : lengths) {
                count += length/mid;
                if (count >= n) {
                    success = true;
                    break;
                }
            }

            if (success) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid -1;
            }
        }
        System.out.print(answer);
    }
```
- 입력 받을 때 길이의 최댓값을 찾아 rt로 한다.
- lt는 1로 잡는다.
- lt, rt로 매개변수 탐색을 수행한다.
  - 각각의 길이를 mid로 나눴을 때의 몫들의 합이 n 이상일 때가 성공 조건이다.
  - 성공조건을 만족하면 answer를 갱신시킨다.
  - 성공조건을 만족시키지 못 하면 rt를 mid -1 로 줄여서 success 할 수 있게 시도해본다.
  - 더 큰 mid값에서 성공할 수 있는지 시도하기 위해 lt를 mid +1로 증가시킨다.

---
