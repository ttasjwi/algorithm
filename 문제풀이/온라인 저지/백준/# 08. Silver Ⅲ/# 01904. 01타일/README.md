# 문제
- 플랫폼 : 백준
- 번호 : 01904
- 제목 : 01타일
- 난이도 : Silver 3
- 첫 번째 줄에 지원이가 만들 수 있는 길이가 N인 모든 2진 수열의 개수를 15746으로 나눈 나머지를 출력한다.
- 문제 : <a href="https://www.acmicpc.net/problem/1904" target="_blank">링크</a>

---

# 필요 지식
- 다이나믹 프로그래밍

---

# 풀이
```kotlin
fun main() {
    val n = i()
    if (n == 1) {
        print(1)
        return
    }
    var a = 1
    var b = 2
    for (i in 3..n) b = ((a+b)%15746).also { a = b }
    print(b)
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while (System.`in`.read().also { c = it } > 47)
    return v
}
```
- n이 주어질 때(n>=3) 앞에 0을 두고 뒤에 n-1 자리에 숫자를 배치하는 방법, 11을 두고 n-2 자리에 숫자를 배치하는 방법 두 가지로 분리할 수 있다.
- 최종적으로 구하는 것은 15746 으로 나눈 나머지인데, 그대로 계속 더해나가면 오버플로우가 발생할 가능성이 있다.
- 이를 효율적으로 관리하려면 매 순간 15746으로 나눈 나머지를 저장하면 된다.

---
