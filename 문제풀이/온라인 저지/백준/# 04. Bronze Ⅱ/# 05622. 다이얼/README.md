# 문제
- 플랫폼 : 백준
- 번호 : 05622
- 제목 : 다이얼
- 난이도 : Bronze 2
- 다이얼을 걸기 위해서 필요한 최소 시간을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/5622" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
## Kotlin
```kotlin
fun main() {
  var value = 0
  var input: Int
  while (true) {
    input = System.`in`.read()
    value += when (input){
      10, 32 -> {
        break
      }
      in 65..79 -> (input-65)/3 + 3
      in 80..83 -> 8
      in 84..86 -> 9
      else -> 10
    }
  }
  println(value)
}
```
- 한 글자씩 읽어서, 알파벳의 범위에 도달하는 시간을 더함
- 출력

---
