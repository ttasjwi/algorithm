# 문제
- 플랫폼 : 백준
- 번호 : 01149
- 제목 : RGB 거리
- 난이도 : Silver 1
- 첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1149" target="_blank">링크</a>

---

# 필요 지식
- 다이나믹 프로그래밍

---

# 풀이
```kotlin
fun main() {
    var n = i()
    var r = i()
    var g = i()
    var b = i()
    var br: Int
    var bg: Int
    var bb: Int

    while (n-- > 1) {
        br = r
        bg = g
        bb = b
        r = i() + if (bg < bb) bg else bb
        g = i() + if (br < bb) br else bb
        b = i() + if (br < bg) br else bg
    }
    print(minOf(r,g,b))
}
```
- i번째 지점을 r로 칠했을 때 여태까지의 최소 비용을 `dpr[i]`이라 하자
- i번째 지점을 g로 칠했을 때 여태까지의 최소 비용을 `dpg[i]`이라 하자
- i번째 지점을 b로 칠했을 때 여태까지의 최소 비용을 `dpb[i]`이라 하자
- 세가지 케이스 중 r 하나만 놓고 생각해보면 dpr[i] 는 현재 지점을 r로 칠하는 비용에, `dpg[i-1]`과 `dpb[i-1]`의 최솟값을 더하는 것과 같을 것이다.
- 이런 방식으로 매 지점의 dpr, dpg, dpb를 갱신해나가고 최종적으로는 마지막 dpr, dpg, dpb 중 최솟값을 출력하면 된다.
- 이 문제에서는 배열을 쓰지 않고 변수 6개를 사용해 문제를 해결했다

---
