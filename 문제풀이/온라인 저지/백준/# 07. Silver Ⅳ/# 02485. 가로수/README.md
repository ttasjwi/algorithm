 # 문제
- 플랫폼 : 백준
- 번호 : 02485
- 제목 : 가로수
- 난이도 : Silver 4
- 모든 가로수가 같은 간격이 되도록 새로 심어야 하는 가로수의 최소수를 첫 번째 줄에 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2485" target="_blank">링크</a>

---

# 필요 지식
- GCD/LCM

---

# 풀이
```kotlin
fun main() {
    val n = i()
    var lt = i()
    var rt = i()

    var diffSum = rt - lt
    var gcd = diffSum
    var currentDiff: Int
    for (i in 0 until n-2) {
        lt = rt
        rt = i()
        currentDiff = rt - lt
        diffSum += currentDiff
        gcd = if (gcd >= currentDiff) gcd(gcd, currentDiff) else gcd(currentDiff, gcd)
    }
    print(diffSum / gcd - (n - 1))
}

private fun gcd(a: Int, b: Int): Int {
    val r = (a % b)
    return if (r == 0) b else gcd(b, r)
}
```
- diffSum : 가로수 사이 간격의 합
- currentDiff : 현 시점 가로수 사이 간격
- gcd : 가로수 사이 간격의 최대 공약수
- 매 순간 가로수 사이 간격과 gcd의 최대 공약수를 계산하여 gcd를 갱신하고 현재 가로수 사이 간격을 diffSum에 합산한다.
- 최종적으로는 가로수 사이 간격 합을 gcd로 나눈 값에 n-1만큼 차감한 값이 심어야 할 가로수의 갯수이다

---
