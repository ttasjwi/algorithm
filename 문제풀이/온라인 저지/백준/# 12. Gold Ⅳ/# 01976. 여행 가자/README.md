# 문제
- 플랫폼 : 백준
- 번호 : 01976
- 제목 : 여행 가자
- 난이도 : Gold 4
- 여행 계획에 속한 도시들을 방문 가능한지 가능하면 YES 불가능하면 NO 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1976" target="_blank">링크</a>

---

# 필요 지식
- 유니온 파인드

---

# 풀이
```kotlin
fun main() {
    val n = i()
    var m = i()
    var parent = IntArray(n+1) {it}

    fun find(x: Int) : Int {
        if (parent[x] == x) return x
        return find(parent[x]).also { parent[x] = it}
    }

    fun union(a:Int, b:Int) {
        val aRoot = find(a)
        val bRoot = find(b)
        if (aRoot < bRoot) parent[bRoot] = aRoot
        else if (aRoot > bRoot) parent[aRoot] = bRoot
    }

    for (i in 1..n) {
        for (j in 1..n) {
            if (i > j) {
                if (i() == 1) union(i, j)
            } else {
                i()
            }
        }
    }

    val root = find(i())
    m --
    while (m -- > 0) {
       if (root != find(i())) {
           print("NO")
           return
       }
    }
    print("YES")
}
```
- 집합적인 관점에서, 연결되어 있다는 것은 같은 집합이라는 것이다.
- 유니온 연산으로 루트 부모를 병합하고
- 파인드 연산으로 루트 부모를 찾고 부모를 루트 부모로 갱신한다.
- 여행 계획의 도시들을 순서대로 순회하면서 같은 집합인지 순서대로 확인하고 다른 집합의 원소가 속해있으면 NO 를 출력하고 모두 union 가능하면 yes를 출력한다

---
