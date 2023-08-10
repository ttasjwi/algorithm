# 문제
- 플랫폼 : 백준
- 번호 : 11478
- 제목 : 서로 다른 부분 문자열의 개수
- 난이도 : Silver 3
- S의 서로 다른 부분 문자열의 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11478" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```kotlin
fun main() {
    val s = s()
    val set = HashSet<String>()

    var lt = 0
    var rt = 0

    while (lt < s.length) {
        while (rt < s.length) {
            sb.append(s[rt])
            set.add(sb.toString())
            rt ++
        }
        sb.setLength(0)
        lt ++
        rt = lt
    }
    print(set.size)
}
```
- 2중 while문으로 시작점 기준 연속적인 문자를 계속 set에 모아둠
- 최종적인 set의 size 출력

---
