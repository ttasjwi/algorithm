# 문제
- 플랫폼 : 백준
- 번호 : 17608
- 제목 : 막대기
- 난이도 : Bronze 2
- 오른쪽에서 N개의 막대기를 보았을 때, 보이는 막대기의 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/17608" target="_blank">링크</a>

---

# 필요 지식
- 자료구조
- 스택

---

# 풀이
```kotlin
fun main() {
  val n = i()
  val sticks = Sticks(n)
  repeat(n) { sticks.push(i()) }
  writeInt(sticks.size)
  flushBuffer()
}

class Sticks(cap: Int) {
  private val arr = IntArray(cap)
  var size = 0
  fun push(e: Int) {
    while(isNotEmpty()) {
      if (peek() <= e) pop()
      else break
    }
    arr[size++] = e
  }
  private fun pop() { --size }
  private fun peek() = arr[size-1]
  private fun isNotEmpty() = size != 0
}
```
- 스택을 사용해서 기능을 구현했다.
- 새로 삽입하는 막대기의 길이를 확인한다.
  - 스택의 최상단 요소가 막대기의 길이보다 작거나 같은 동안 계속 꺼낸다
  - 스택에 막대기를 삽입한다.
- 스택의 크기를 출력한다.

---
