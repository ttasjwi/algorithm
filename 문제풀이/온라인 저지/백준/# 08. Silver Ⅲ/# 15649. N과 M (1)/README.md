# 문제
- 플랫폼 : 백준
- 번호 : 15649
- 제목 : N과 M (1)
- 난이도 : Silver 3
- 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열들을 사전식으로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/15649" target="_blank">링크</a>

---

# 필요 지식
- 백트래킹(DFS)

---

# 풀이
```kotlin
var n = 0
var m = 0
lateinit var c: BooleanArray
lateinit var arr: CharArray
val sb = StringBuilder()

fun main() {
    n = i()
    m = i()
    arr = CharArray(2 * m)
    for (i in 0 until m) arr[2*i + 1] = ' '
    arr[2 * m - 1] = '\n'
    c = BooleanArray(n + 1)
    bt(0)
    print(sb)
}

private fun bt(idx: Int) {
    if (idx == m) { sb.append(arr);return }
    for (i in 1..n) {
        if (!c[i]) {
            c[i] = true
            arr[idx * 2] = (i + 48).toChar()
            bt(idx + 1)
            c[i] = false
        }
    }
}
```
- DFS를 이용한 백트래킹을 사용했다.
- 함수의 idx는 말 그대로 nums의 인덱스이다. 해당 인덱스에 삽입할 값을 결정하고, 다음 인덱스의 값을 결정하기 위해 bt를 재귀적으로 호출한다.
- 이미 사용된 값은 다시 사용하지 않도록 체크처리하고, 다음 반복에서는 사용할 수 있도록 체크처리를 해제한다.
- idx가 m과 같아지면 배열의 마지막 인덱스까지 모두 채운 상태이므로 그대로 출력한다.

---
