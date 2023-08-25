# 문제
- 플랫폼 : 백준
- 번호 : 11729
- 제목 : 하노이의 탑 이동 순서
- 난이도 : Silver 1
- 첫째 줄에 옮긴 횟수 K를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11729" target="_blank">링크</a>

---

# 필요 지식
- 재귀

---

# 생각
시작점, 경유지, 종점으로 나누고 재귀적으로 생각한다.  
- 시작점에 있는 석판이 1개라면 바로 종점으로 옮기면 된다.  
- 시작점에 있는 석판이 1개가 아니라면 시작점에서, 맨 아래를 제외한 나머지를 경유지에 모두 옮겨야한다.(재귀)
그리고 시작점에 있는 제일 큰 원판을 종점으로 바로 옮긴뒤, 나머지 경유지에 위치한 석판을 종점으로 옮기면 된다.(재귀)

---

# 전체코드
```kotlin
val sb = StringBuilder()
var cnt = 0
fun main() {
    val n = i()
    hanoi(n, '1', '3', '2')
    println(cnt)
    print(sb)
}

private fun hanoi(n: Int, from: Char, to: Char, by: Char) {
    if (n == 1) {
        // 원판이 1개이면 종점으로 바로 옮기기
        sb.append(from).append(' ').append(to).append('\n')
        cnt ++
        return
    }
    // 나머지 원판을 경유지로 옮기기
    hanoi(n-1, from, by, to)
    // 남은 제일 큰 원판을 종점으로 옮기기
    sb.append(from).append(' ').append(to).append('\n')
    cnt ++
    // 경유지에 위치한 나머지 원판을 종점으로 옮기기
    hanoi(n-1, by, to, from)
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while(System.`in`.read().also { c = it } > 47)
    return v
}
```