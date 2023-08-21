# 문제
- 플랫폼 : 백준
- 번호 : 25192
- 제목 : 인사성 밝은 곰곰이
- 난이도 : Silver 4
- 채팅 기록 중 곰곰티콘이 사용된 횟수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/25192" target="_blank">링크</a>

---

# 필요 지식
- 해시


---

# 풀이
```kotlin
fun main() {
    var n = i()
    var cnt = 0
    val set = HashSet<String>()
    var word: String
    while (n-- > 0) {
        word = s()
        when (word) {
            "ENTER" -> set.clear()
            else -> if (word !in set) { set.add(word); cnt ++;}
        }
    }
    print(cnt)
}
```
- `ENTER` 때마다 Set을 비우고, 그 후의 첫 입력은 인사로 간주하고 SET에 수집한다