# 문제
- 플랫폼 : 프로그래머스
- 번호 : 076502
- 제목 : n^2 배열 자르기
- 난이도 : Level 2
- 정수 n, left, right가 매개변수로 주어집니다. 주어진 과정대로 만들어진 1차원 배열을 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/76502" target="_blank">링크</a>

---

# 필요 지식
- 배열
- 구현

---

# 풀이
```kotlin
class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val answer = IntArray((right - left).toInt() + 1)
        var r: Int
        var c: Int
        for (i in left..right) {
            r = (i / n).toInt()
            c = (i % n).toInt()
            answer[(i - left).toInt()] = if (r >= c) r + 1 else c + 1
        }
        return answer
    }

}
```
- left..right 사이의 인덱스를 i라 할 때
- 원본 이차원 배열에서의 행(r), 열(c)은 i/n, i%n이다. (행-열의 인덱스를 0,1,2... n-1로 환산했을 때)
- answer[i]는
  - 행>=열 일 때는 r+1 이고
  - 행<열 일 때는 c+1 이다.

---
