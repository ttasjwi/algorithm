# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012939
- 제목 : 최댓값과 최솟값
- 난이도 : Level 2
- 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12939" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
## 풀이1: 반복문
```kotlin
class Solution {
    fun solution(s: String): String {
        var v: Int
        var min = Integer.MAX_VALUE
        var max = Integer.MIN_VALUE
        for (x in s.split(' ')) {
            v = x.toInt()
            if (min > v) min = v
            if (max < v) max = v
        }
        return "$min $max"
    }
}
```
- 반복문을 통해 순회하면서  최소 최대를 갱신시키고 문자열 형태로 반환

## 풀이2: 고차함수
```kotlin
class Solution {
    fun solution(s: String): String = s.split(' ').map { it.toInt() }.let { "${it.min()} ${it.max()}" }
}
```
- map : 변환
- let : it을 매개변수로 사용하고 코드블록의 수행 결과값을 반환한다.
  - 비교) also : it을 매개변수로 사용하고 it 그 자체를 그대로 반환한다.

---
