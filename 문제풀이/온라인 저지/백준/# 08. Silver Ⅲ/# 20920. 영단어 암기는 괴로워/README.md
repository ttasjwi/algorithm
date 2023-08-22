# 문제
- 플랫폼 : 백준
- 번호 : 20920
- 제목 : 영단어 암기는 괴로워
- 난이도 : Silver 3
- 단어장에 들어 있는 단어를 단어장의 앞에 위치한 단어부터 한 줄에 한 단어씩 순서대로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/20920" target="_blank">링크</a>

---

# 필요 지식
- 해시
- 정렬

---

# 풀이
```kotlin
fun main() {
    var n = i()
    val m = i()
    var s: String
    val map = HashMap<String, Int>()
    while (n-- > 0) {
        s = s()
        if (s.length < m) continue
        if (map.containsKey(s)) {
            map[s] = map[s]!! + 1
        } else {
            map[s] = 1
        }
    }
    val set = TreeSet<Str>()
    for (key in map.keys) {
        set.add(Str(key, map[key]!!))
    }
    for (str in set) {
        sb.append(str.s).append('\n')
    }
    print(sb)
}

data class Str(val s: String, val c: Int) : Comparable<Str> {

    override fun compareTo(other: Str): Int {
        var tmp = other.c - this.c
        if (tmp != 0) {
            return tmp
        }
        tmp = other.s.length - s.length
        if (tmp != 0) {
            return tmp
        }
        return s.compareTo(other.s)
    }

}
```
- map에서 단어 등장 빈도를 카운팅
- map에 수집한 카운팅 정보를 기반으로 Str객체 생성하고, TreeSet에 저장
  - Str (단어, 등장횟수)
  - 정렬 기준 : 등장횟수 내림차 -> 단어 길이 내림차 -> 단어 사전순 오름차
- 정렬된 결과 기준으로 출력

---
