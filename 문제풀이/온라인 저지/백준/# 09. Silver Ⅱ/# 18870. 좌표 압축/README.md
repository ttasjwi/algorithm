# 문제
- 플랫폼 : 백준
- 번호 : 188870
- 제목 : 좌표 압축
- 난이도 : Silver 2
- X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/18870" target="_blank">링크</a>

---

# 필요 지식
- 정렬
- 해시

---

# 풀이
```kotlin
import java.util.*

fun main() {
    val n = readInt()
    val original = IntArray(n)
    val sorted = IntArray(n)

    for (i in 0 until n) {
        original[i] = readInt()
        sorted[i] = original[i]
    }
    Arrays.sort(sorted)
    val map = HashMap<Int, Int>()
    var rank = -1
    for (i in sorted.indices) {
        if (!map.containsKey(sorted[i])) {
            map[sorted[i]] = ++ rank
        }
    }
    val sb = StringBuilder()
    for (num in original) {
        sb.append(map[num]).append(' ')
    }
    print(sb)
}
```
- 원본 숫자들을 원본 배열 입력받고, 정렬 배열에도 같은 순서로 저장한다.
- 정렬 배열을 정렬한다.
- 정렬 배열을 순서대로 순회하면서, Map에 각각의 랭킹을 저장한다.
- 원본배열 순서대로 Map을 따라가 값을 출력한다

---
