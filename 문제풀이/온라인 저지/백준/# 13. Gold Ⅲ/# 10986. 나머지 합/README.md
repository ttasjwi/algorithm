# 문제
- 플랫폼 : 백준
- 번호 : 10986
- 제목 : 나머지 합
- 난이도 : Gold 3
- 첫째 줄에 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10986" target="_blank">링크</a>

---

# 필요 지식
- 누적합

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val m = i()
    var cnt = 0L
    val counter = IntArray(m)
    var v = 0
    counter[0] = 1 // 0번째 수를 m으로 나눈 나머지는 0으로 취급하므로, 1을 더해둠
    for (i in  1..n) {
        v = (v + i())%m
        counter[v] ++
    }
    for (c in counter) {
        cnt += c.toLong() * (c-1).toLong() / 2 // 각 나머지 등장횟수별로, 서로 다른 2개를 택한 경우의 수
    }
    print(cnt)
}
```
x번째 수부터 j번째 수까지의 합을 `a[x] + a[x+1] + ... + a[j]`라 하자  
특정 지점에서의 누적합을 dp라 하자. 이때 위의 식은 `dp[j] - dp[x-1]`과 같다.  
`dp[j]-dp[x-1]`%m == 0 인 서로 다른 두 수 x-1, j 를 찾아야한다. (x-1 >=0, j > i)  
여기서 x-1을 i로 변경해보면 `dp[j] - dp[i]`%m == 0 (0<= i < j)  
`dp[i] == dp[j]` 를 만족하는 모든 서로 다른 i, j 순서쌍을 구해야한다. (0<=i<j)  

그런데 모든 수 중 2개를 택해서 나머지를 비교하기엔 반복의 시간복잡도가 O(N^2)이 되버린다. 시간 초과가 날 듯.  

대신 0, 1, ... m-1 까지 `dp[i]`의 나머지별로 등장 횟수를 카운팅한다음  
카운팅된 갯수 중 서로 다른 두가지를 택한 경우의 수들의 합으로 간결화할 수 있다.(시간 복잡도 = O(N))
여기서 주의점은 dp[0] = 0 이므로, 나머지 0 카운터에 1을 미리 하나 더해둬야한다  

---
