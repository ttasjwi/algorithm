# 문제
- 플랫폼 : 백준
- 번호 : 01620
- 제목 : 나는야 포켓몬 마스터 이다솜
- 난이도 : Silver 4
- 입력으로 숫자가 들어왔다면 그 숫자에 해당하는 포켓몬의 이름을, 문자가 들어왔으면 그 포켓몬의 이름에 해당하는 번호를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1620" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```kotlin
fun main() {
    System.`in`.read(B, 0, S)
    val n = i()
    var m = i()
    val arr = arrayOfNulls<String>(n + 1)
    val map = HashMap<String, Int>()
    var word: String
    for (i in 1..n) {
        word = s()
        arr[i] = word
        map[word] = i
    }
    while (m-- > 0) {
        word = s()
        wsb.append(if (word[0].isDigit()) arr[word.toInt()] else map[word]).append('\n')
    }
    print(wsb)
}
```
- 라인들을 입력받아서, 배열과 맵에 저장
- 입력이 숫자가 들어오면 배열의 인덱스에 위치한 포켓몬을, 문자열이 들어오면 맵에서 번호를 꺼낸다.

---
