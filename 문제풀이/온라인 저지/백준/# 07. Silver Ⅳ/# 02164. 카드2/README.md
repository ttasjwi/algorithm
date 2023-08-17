# 문제
- 플랫폼 : 백준
- 번호 : 02164
- 제목 : 카드2
- 난이도 : Silver 4
- 첫째 줄에 남게 되는 카드의 번호를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2164" target="_blank">링크</a>

---

# 필요 지식
- 큐

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val c = n + 1
    val q = IntArray(c)
    var f = 0
    var r = n
    var s = n
    for (i in 1..n) q[i] = i

    while (s > 1) {
        f = (f + 2 + c) % c
        r = (r + 1 + c) % c
        q[r] = q[f]
        s --
    }
    print(q[r])
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while(System.`in`.read().also { c = it } > 47)
    return v
}
```
- 원형 큐를 구현했다.
- f는 제일 앞 요소 앞의 인덱스이고, r은 맨 뒤 인덱스이다.
- f로부터 2칸 뒤에 있는 요소가 맨 뒤에 옮길 요소다.
- r로부터 1칸 뒤 자리는 우리가 새로 요소를 삽입할 위치다.
- 삽입할 위치에 추출할 요소를 옮긴다.
- s(사이즈)를 1 감소 시킨다
- 이 과정을 s가 1이 될 때까지 반복하고 마지막에 남은 요소를 출력하면 된다

---
