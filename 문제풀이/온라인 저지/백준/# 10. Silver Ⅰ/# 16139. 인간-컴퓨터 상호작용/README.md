# 문제
- 플랫폼 : 백준
- 번호 : 16139
- 제목 : 인간-컴퓨터 상호작용
- 난이도 : Silver 1
- 특정 문자열 s, 특정 알파벳 x와 문자열의 구간 `[l,r]`이 주어지면
s의 l번째 문자부터 r번째 문자 사이에 x가 몇 번 나타나는지 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/16139" target="_blank">링크</a>

---

# 필요 지식
- 누적

---

# 풀이
```kotlin
fun main() {
    val s = s()
    val dp = Array(26){IntArray(s.length + 1)}
    for (i in s.indices) {
        for (ch in 'a'..'z') {
            dp[ch.code-97][i+1] =
                if (ch == s[i]) dp[ch.code - 97][i] + 1
                else dp[ch.code-97][i]
        }
    }
    var q = i()
    var x: Byte
    var i: Int
    var j: Int
    while(q-- > 0 ) {
        x = r()
        r()
        i = i() + 1
        j = i() + 1
        sb.append(dp[x.toInt()-97][j] - dp[x.toInt()-97][i-1]).append('\n')
    }
    print(sb)
}
```
- dp 배열 : a,..z 까지 매 인덱스마다 누적 등장횟수
- dp 배열을 활용하여 라인 입력마다, 구간 합 출력

---
