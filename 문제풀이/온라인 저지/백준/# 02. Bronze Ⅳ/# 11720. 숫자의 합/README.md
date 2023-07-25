# 문제
- 플랫폼 : 백준
- 번호 : 11720
- 제목 : 숫자의 합
- 난이도 : Bronze 4
- 입력으로 주어진 숫자 N개의 합을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11720" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```kotlin
fun main() = with(System.`in`.bufferedReader()) {
    readln()
    var sum = 0
    readln().forEach {
        sum += (it - 48).code
    }
    print(sum)
}
```
- 첫줄은 무의미하다.
- 두번째 줄을 입력받고 forEach 함수를 통해 (문자 아스키코드 값 - 48) 값을 sum에 합산
- 출력

---
