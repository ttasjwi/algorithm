# 문제
- 플랫폼 : 백준
- 번호 : 07785
- 제목 : 회사에 있는 사람
- 난이도 : Silver 5
- 현재 회사에 있는 사람의 이름을 사전 순의 역순으로 한 줄에 한 명씩 출력
- 문제 : <a href="https://www.acmicpc.net/problem/7785" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```kotlin
fun main() {
    System.`in`.read(B, 0, S)
    var n = i()
    var name: String
    var command: String
    val people = sortedMapOf<String, Boolean>(reverseOrder())

    while (n-- > 0) {
        name = s()
        command = s()
        people[name] = command == "enter"
    }
    val sb = StringBuilder()
    for (entry in people.entries) {
        if (entry.value) {
            sb.append(entry.key).append('\n')
        }
    }
    print(sb)
}

const val S = 12000008
private val B = ByteArray(S)
private var p = 0
fun i(): Int {
    var v = 0
    var c = B[p++]
    do v = v * 10 + c - 48 while (B[p++].also { c = it } > 47)
    return v
}

fun s(): String {
    val f = p
    var l = 0
    while (B[p++] > 64) l++
    return String(B, f, l)
}
```
- 회사의 사람들을 Map에 저장한다.
  - name을 key로 하고, 회사에 있는지 여부를 value로 함
  - 여기서 왜 set을 안 쓰고 map으로 했는가?
    - 사용자가 나갈 때마다 set에서 제거하면 매번 제거하고 넣기를 반복해야한다
    - 정렬이 필요한 Map이므로 제거하고 삽입을 다시 할 때마다 정렬이 매 순간 일어나게 하고 싶지 않다
    - boolean 상태를 주어, 사람이 회사에 있는지 없는지 플래그만 지정하면 회사원이 나갈 때마다 map에서 빼낼 필요가 없어진다
- Map을 순회하면서, 회사원이 회사에 있으면 출력한다

---
