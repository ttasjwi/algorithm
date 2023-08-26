# 문제
- 플랫폼 : 백준
- 번호 : 15650
- 제목 : N과 M (2)
- 난이도 : Silver 3
- 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 사전순으로 증가하는 수열들을 사전식으로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/15650" target="_blank">링크</a>

---

# 필요 지식
- 백트래킹(DFS)

---

# 풀이
```kotlin
var n = 0
var m = 0
lateinit var arr: CharArray
val sb = StringBuilder()

fun main() {
    n = i()
    m = i()
    arr = CharArray(2 * m) {' '}
    arr[2 * m - 1] = '\n'
    bt(0, 1)
    print(sb)
}

private fun bt(idx: Int, start: Int) {
    if (idx == m) {
        sb.append(arr);return
    }
    for (i in start..n) {
        arr[idx * 2] = (i + 48).toChar()
        bt(idx + 1, i + 1)
    }
}
```
- DFS를 이용한 백트래킹을 사용했다.
- 함수의 idx는 말 그대로 nums의 인덱스이다. 해당 인덱스에 삽입할 값을 결정하고, 다음 인덱스의 값을 결정하기 위해 bt를 재귀적으로 호출한다.
- start는 선택의 시작 인덱스이다. 해당 숫자부터 선택해야하므로 start 변수를 따로 넘겨야한다.
- idx가 m과 같아지면 배열의 마지막 인덱스까지 모두 채운 상태이므로 그대로 출력한다.

---
