# 문제
- 플랫폼 : 백준
- 번호 : 14720
- 제목 : 우유 축제
- 난이도 : Bronze 3
- 영학이가 마실 수 있는 우유의 최대 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/14720" target="_blank">링크</a>

---

# 필요 알고리즘
- 그리디 알고리즘

---

# 풀이
```kotlin
fun main() {
    var cur = 0
    var cnt = 0
    repeat(i()) {
        if (i() == cur) {
            cnt++
            cur = (cur + 1) % 3
        }
    }
    writeInt(cnt)
    flushBuffer()
}
```
- 현 위치 포인터 : 0, 1, 2, 0 ...
- 방문하자마자 현재 방문해야하는 우유 가게인지 확인하고 맞으면 마신뒤 다음으로 진행
- 이렇게만 해도 최대한 마실 수 있는 우유를 마실 수 있다

---
