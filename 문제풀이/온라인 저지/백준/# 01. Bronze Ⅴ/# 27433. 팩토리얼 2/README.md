# 문제
- 플랫폼 : 백준
- 번호 : 27433
- 제목 : 팩토리얼 2
- 난이도 : Bronze 5
- N!을 출력한다.
- 문제 : <a href="https://www.acmicpc.net/problem/27433" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이

## 풀이1: 반복문
```kotlin
fun main() {
    var a = 1L
    for (i in 2..i()) a *= i
    print(a)
}
```

## 풀이2: 재귀
```kotlin
fun main() {
    print(f(i()))
}

fun f(i: Int) : Long {
    return if (i == 0 || i == 1) 1L else i * f(i-1)
}
```
- 풀이1보다는 약간 느리다

---
