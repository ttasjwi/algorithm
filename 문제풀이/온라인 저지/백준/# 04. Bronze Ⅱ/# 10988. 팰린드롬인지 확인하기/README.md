# 문제
- 플랫폼 : 백준
- 번호 : 10988
- 제목 : 팰린드롬인지 확인하기
- 난이도 : Bronze 2
- 첫째 줄에 팰린드롬이면 1, 아니면 0을 출력 
- 문제 : <a href="https://www.acmicpc.net/problem/10988" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리

---

# 풀이
## Kotlin
```kotlin
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val word = br.readLine()
    var lt = 0
    var rt = word.length - 1
    var answer = "1"
    while (lt < rt) {
        if (word[lt] != word[rt]) {
            answer = "0"
            break
        }
        lt += 1
        rt -= 1
    }
    bw.write(answer)
    bw.flush()
}
```
- lt, rt를 두고 각각 전후진 시켜가면서 비교하면 된다

---

