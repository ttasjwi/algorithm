# 문제
- 플랫폼 : 백준
- 번호 : 13909
- 제목 : 창문 닫기
- 난이도 : Silver 5
- 마지막에 열려 있는 창문의 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/13909" target="_blank">링크</a>

---

# 필요 지식
- 수학

---

# 풀이
```kotlin
import kotlin.math.sqrt

fun main() {
    val n = i()
    val answer = sqrt(n.toDouble()).toInt()
    print(answer)
}
```
- 약수의 갯수가 짝수이면 켜졌다 꺼지고, 홀수이면 켜지고 끝난다.
- 그리고 약수개가 홀수인 경우는 완전제곱수인 경우 뿐이다.
  - 예를 들어 25의 약수는 1,5,25이다. 따라서 모든 작업이 수행되고 나면 불이 켜져있다.
- 따라서 n까지의 완전제곱수의 수를 구하면 된다.
  - 여기서는 n의 거듭제곱근의 정수부분을 반환했다

---
