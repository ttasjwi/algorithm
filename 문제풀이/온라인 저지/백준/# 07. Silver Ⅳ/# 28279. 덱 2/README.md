# 문제
- 플랫폼 : 백준
- 번호 : 28279
- 제목 : 덱 2
- 난이도 : Silver 4
- 정수를 저장하는 덱을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/28279" target="_blank">링크</a>

---

# 필요 알고리즘
- 덱
- 원형 덱

---

# 풀이
```kotlin
fun main() {
    val sb = StringBuilder()
    var n = i()
    val c = n+1
    var f = 0
    var r = 0
    var s = 0
    val d = IntArray(c)
    var tmp: Int
    while(n-- > 0) {
       sb.append(when(i()) {
           1 -> {s++; d[f] = i(); f = (f-1+c)%c; continue}
           2 -> {s++; r = (r+1+c)%c;  d[r] = i(); continue}
           3 -> if (s == 0) -1 else {s--; f = (f+1+c)%c; d[f]}
           4 -> if (s == 0) -1 else {s--; tmp = d[r]; r = (r-1+c)%c; tmp}
           5 -> s
           6 -> if (s == 0) 1 else 0
           7 -> if (s == 0) -1 else d[(f+1+c)%c]
           else -> if (s == 0) -1 else d[r]
       }).append('\n')
    }
    print(sb)
}
```
- 원형 덱을 구현하여 문제를 풀었다

---
