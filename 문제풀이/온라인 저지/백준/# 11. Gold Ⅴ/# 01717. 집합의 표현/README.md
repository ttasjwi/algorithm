# 문제
- 플랫폼 : 백준
- 번호 : 01717
- 제목 : 집합의 표현
- 난이도 : Gold 5
- a, b 가 같은 집합에 포함되어 있으면 "YES", 그렇지 않으면 "NO" 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1717" target="_blank">링크</a>

---

# 필요 지식
- 유니온 파인드

---

# 풀이
```kotlin
fun main() {
    val n = i()
    var m = i()
    val parent = IntArray(n + 1) { it }
    val sb = StringBuilder()
    var o: Int
    var a: Int
    var b: Int

    fun find(x: Int): Int {
        if (parent[x] == x) return x
        return find(parent[x]).also { parent[x] = it }
    }

    fun union(a: Int, b:Int) {
        val aRoot = find(a)
        val bRoot = find(b)
        if (aRoot < bRoot) parent[bRoot] = aRoot
        else if (aRoot > bRoot) parent[aRoot] = bRoot

    }

    while (m-- > 0) {
        o = i()
        a = i()
        b = i()

        if (o == 0) {
            union(a, b)
        } else {
            sb.append(if (find(a) == find(b)) "YES\n" else "NO\n")
        }
    }
    print(sb)
}
```
- find : 루트 부모를 찾고, 부모를 루트 부모로 변경하는 연산
- union : 각 집합의 루트 부모를 통합하는 연산

---

