# 문제
- 플랫폼 : 백준
- 번호 : 10872
- 제목 : 팩토리얼
- 난이도 : Bronze 5
- N!을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10872" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```kotlin
fun main() {
    var k = 1
    for (i in 2..i()) k *= i
    print(k)
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while (System.`in`.read().also { c = it } > 47)
    return v
}
```

---
