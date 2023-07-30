# 문제
- 플랫폼 : 백준
- 번호 : 05086
- 제목 : 배수와 약수
- 난이도 : Bronze 3
- 각 테스트 케이스마다 첫 번째 숫자가 두 번째 숫자의 약수라면 factor를, 배수라면 multiple을, 둘 다 아니라면 neither를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/5086" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
## Kotlin
```kotlin
fun main() {
    val sb = StringBuilder()
    var a: Int
    var b: Int
    while (true) {
        a = readInt()
        b = readInt()
        when {
            a==0 && b==0 -> break
            b%a == 0 -> sb.append("factor\n")
            a%b == 0 -> sb.append("multiple\n")
            else -> sb.append("neither\n")
        }
    }
    print(sb)
}
```
- when문을 이용해서 분기처리를 했다. if문에 비해 좀 더 가독성이 좋다.

---
