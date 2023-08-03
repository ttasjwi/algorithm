# 문제
- 플랫폼 : 백준
- 번호 : 24267
- 제목 : 알고리즘 수업 - 알고리즘의 수행 시간 5
- 난이도 : Bronze 2
- 첫째 줄에 코드1 의 수행 횟수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/24267" target="_blank">링크</a>

---

# 필요 지식
- 수학
- 시간 복잡도

---

# 풀이
```kotlin
fun main() {
    val n = readLong()
    val sb = StringBuilder()
    val result = n * (n-1) * (n-2) / 6
    sb.append(result).append('\n').append('3')
    print(sb)
}
```
- 잘 생각해보면 문제 상황은 서로 다른 3개의 숫자를 구하는 것과 구조적으로 동일하다
- 따라서 n개의 요소 중 3개를 택하는 조합수를 구하는 문제와 같다.
- nC3 = n * (n-1) * (n-2) /6
- 시간복잡도는 O(n^3) 이다

---
