# 문제
- 플랫폼 : 백준
- 번호 : 10870
- 제목 : 피보나치 수 5
- 난이도 : Bronze 2
- n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/10870" target="_blank">링크</a>

---

# 필요 지식
- 재귀

---

# 풀이
## 풀이1: 반복문
```python
fun main() {
    var a = 0
    var b = 1
    val x = i()
    if (x == 0 || x == 1) {
        print(x)
    }
    else {
        var tmp: Int
        for (i in 2..x) {
            tmp = b
            b += a
            a = tmp
        }
        print(b)
    }
}
```
- 0 또는 1이 입력 -> 그대로 출력
- 그 외 : 차례로 반복문 돌려서 구하기

---

## 풀이2: 재귀 + DP
```kotlin
private val p = IntArray(21)

fun main() {
    print(p(i()))
}

private fun p(x: Int): Int {
    if (x == 0 || p[x] > 0) {
        return p[x]
    }
    if (x == 1) {
        p[x] = 1
        return p[x]
    }
    p[x] =  p(x-2) + p(x-1)
    return p[x]
}
```
- 재귀적으로 x번째 피보나치 수를 구하는 함수를 구현한다.
- 중간 결과를 재사용하는 점을 고려하여 p 배열에 캐싱했다.

---
