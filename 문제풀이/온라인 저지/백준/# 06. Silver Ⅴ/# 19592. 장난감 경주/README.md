# 문제
- 플랫폼 : 백준
- 번호 : 19592
- 제목 : 장난감 경주
- 난이도 : Silver 5
- 각 테스트 케이스에 대해 단독 우승을 위해 부스터를 사용해서 이동해야하는 최소한의 거리를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/19592" target="_blank">링크</a>

---

# 필요 지식
- 이분 탐색

---

# 풀이
```kotlin
fun main() {
    var t = i()
    var n: Int
    var x: Int
    var y: Int
    var minTime: Double
    var time: Double
    var speed = -1
    var lt: Int
    var rt: Int
    var mid: Int
    var answer: Int

    loop@ while (t-- > 0) {
        n = i()
        x = i()
        y = i()
        minTime = Double.MAX_VALUE
        while (n-- > 0) {
            speed = i()
            time = x / speed.toDouble()
            if (minTime > time) {
                if (n == 0) {
                    writeInt(0)
                    continue@loop
                }
                minTime = time
            }
        }
        lt = 1
        rt = y
        answer = -1
        while (lt <= rt) {
            mid = (lt + rt) shr 1
            time = if (x < mid) x / mid.toDouble() else 1 + (x - mid) / speed.toDouble()
            if (minTime > time) {
                answer = mid
                rt = mid - 1
            } else {
                lt = mid + 1
            }
        }
        writeInt(answer)
    }
    flushBuffer()
}
```
- 여기서 속도 계산은 나눗셈 연산을 통해 계산하고 소숫점 단위로 따져야한다. 따라서 실수 타입으로 계산해야한다.
- 입력을 받을 때마다 최소시간을 갱신한다.
- 이 때 '당신'의 자동차 속도가 제일 빠르면 그냥 바로 0을 출력하고 다음 반복으로 넘어간다.
- 1부터 y까지 이분탐색하여 최소시간이 되도록 하는 부스터 속도를 구한다. 구해지지 않으면 -1을 출력하고 다음 반복으로 넘어간다.
  - 부스터 덕에 1초 이전에 목표 지점까지 도착하는 경우도 있어서 분기처리했다.

---
