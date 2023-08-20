# 문제
- 플랫폼 : 백준
- 번호 : 24723
- 제목 : 녹색거탑
- 난이도 : Bronze 4
- 녹색거탑의 정상에서 바닥으로 내려오는 경우의 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/24723" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```kotlin
fun main() {
    print(Math.pow(2.0, i().toDouble()).toInt())
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while(System.`in`.read().also { c = it } > 47)
    return v
}
```
- 다음 층에 갈 때마다 경우의 수가 2배씩 증가한다.
- 따라서, 2의 거듭제곱 꼴로 증가한다.

---
