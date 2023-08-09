# 문제
- 플랫폼 : 백준
- 번호 : 01764
- 제목 : 듣보잡
- 난이도 : Silver 4
- 듣보잡의 수와 그 명단을 사전순으로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1764" target="_blank">링크</a>

---

# 필요 지식
- 해시
- 정렬

---

# 풀이
```kotling
fun main() {
    var n = i()
    var m = i()
    val list = mutableListOf<String>()
    val set = HashSet<String>()
    var p: String
    while (n-- > 0) set.add(s())
    while (m-- > 0) {
        p = s()
        if (p in set) {
            list.add(p)
        }
    }
    list.sort()
    val sb = StringBuilder()
    sb.append(list.size).append('\n')
    for (e in list) {
        sb.append(e).append('\n')
    }
    print(sb)
}
```
- set에 듣도 못 한 사람 저장
- 그 다음 입력되는 보도 못 한 사람 중에 듣도 못한 사람은 리스트에 추가(앞에서 해싱한 set 활용)
- 리스트 정렬
- 길이 구하여 출력
- 요소들 순서대로 출력

---
