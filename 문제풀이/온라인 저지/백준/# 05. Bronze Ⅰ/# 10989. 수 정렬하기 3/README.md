# 문제
- 플랫폼 : 백준
- 번호 : 10989
- 제목 : 수 정렬하기 3
- 난이도 : Bronze 1
- N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/10989" target="_blank">링크</a>

---

# 필요 지식
- 카운팅 정렬

---

# 풀이
```kotlin
fun main() {
    var n = readInt()
    val counter = IntArray(10001)
    while (n -- > 0) {
        counter[readInt()] ++
    }
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var line: String
    for (i in 1..10000) {
        if (counter[i] == 0) {
            continue
        }
        line = "$i\n"
        while (counter[i]-- >0) {
            bw.write(line)
        }
    }
    bw.flush()
}
```
- 카운팅 정렬을 통해 문제를 해결했다
