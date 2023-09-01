# 문제
- 플랫폼 : 백준
- 번호 : 11054
- 제목 : 가장 긴 바이토닉 부분 수열
- 난이도 : Gold 4
- 첫째 줄에 수열 A의 부분 수열 중에서 가장 긴 바이토닉 수열의 길이를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11054" target="_blank">링크</a>

---

# 필요 지식
- 다이나믹 프로그래밍

---

# 풀이
```python
fun main() {
    val n = i()
    val a = IntArray(n)
    val b = IntArray(n)
    val c = IntArray(n)
    for (i in a.indices) {
        a[i] = i()
    }
    for (i in a.indices) {
        b[i] = 1
        for (j in 0..i-1) {
            if (a[j] < a[i]) {
                b[i] = maxOf(b[i], b[j] + 1)
            }
        }
    }
    for (i in a.lastIndex downTo 0) {
        c[i] = 1
        for (j in a.lastIndex downTo i+1) {
            if (a[j] < a[i]) {
                c[i] = maxOf(c[i], c[j] + 1)
            }
        }
    }
    var answer = 0
    for (i in 0..n-1) {
        answer = maxOf(answer, b[i] + c[i] - 1)
    }
    print(answer)
}
```
- `a[i]` : 숫자
- `b[i]` : 순방향부터 시작하여 해당위치까지 왔을 때 최장 길이 증가부분 수열의 길이
- `c[i]` : 역방향부터 시작하여 해당위치까지 왔을 때 최장 길이 증가부분 수열의 길이
- 결국 최장길이 바이토닉 부분수열의 길이는 `b[i] + c[i] - 1`의 최댓값이다.

---
