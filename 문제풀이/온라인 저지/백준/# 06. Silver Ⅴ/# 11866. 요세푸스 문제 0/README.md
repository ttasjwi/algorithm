# 문제
- 플랫폼 : 백준
- 번호 : 11866
- 제목 : 요세푸스 문제 0
- 난이도 : Silver 5
- 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라 할 때, N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/11866" target="_blank">링크</a>

---

# 필요 지식
- 연결 리스트

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val k = i()
    val l = LinkedList<Int>()
    for (i in 1..n) l.add(i)
    var idx = 0
    val sb = StringBuilder()
    sb.append('<')
    while (!l.isEmpty()) {
        idx = (idx - 1 + k + l.size) % l.size
        sb.append(l.removeAt(idx)).append(',').append(' ')
    }
    sb.deleteRange(sb.length - 2, sb.length)
    sb.append('>')
    print(sb)
}
```
- k번 오른쪽으로 이동 후, 해당 요소를 삭제해야한다.
- 배열 자료구조를 사용할 경우 중간 삭제 비용이 비싸다.
- 연결 리스트 자료 구조를 사용하면 삭제가 빠르게 수행된다.

---
