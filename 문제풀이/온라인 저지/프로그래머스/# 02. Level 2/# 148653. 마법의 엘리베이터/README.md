# 문제
- 플랫폼 : 프로그래머스
- 번호 : 148653
- 제목 : 마법의 엘리베이터
- 난이도 : Level 2
- 민수가 어떤 층에서 엘리베이터를 타고 0층으로 내려가는데 필요한 마법의 돌의 최소 개수
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/148653" target="_blank">링크</a>

---

# 필요 지식
- 그리디 알고리즘
- 구현

---

# 풀이
```kotlin
class Solution {
    fun solution(storey: Int): Int {
        var cur = storey
        var mod: Int
        var answer = 0
        while (cur > 0) {
            mod = cur % 10
            if (mod == 0) {
                cur /= 10
            } else if (mod == 5) {
                if ((cur / 10) % 10 < 5) {
                    answer += mod
                    cur /= 10
                } else {
                    answer += (10 - mod)
                    cur = cur / 10 + 1
                }
            } else if (mod <= 4) {
                answer += mod
                cur /= 10
            } else {
                answer += (10 - mod)
                cur = cur / 10 + 1
            }
        }
        return answer
    }
}
```
- 끝자리를 보면서 판단한다.
- 판단의 기준은 끝자리가 0인 경우, 1~4인 경우, 5인 경우, 6~9인 경우로 나뉜다.
  - 0인 경우 다음 자리수를 만들기 위해 버튼을 누를 필요가 없다.
  - 1~4인경우 해당 횟수만큼 다음 자리수를 만들기 위해 아래로 향하는 버튼을 눌러야한다. (예: 11 -> 10)
  - 6~9인 경우 다음 자리수를 만들기 위해 위로 향하는 버튼을 눌러야한다. (예: 27 -> 30)
  - 5인 경우는 두 가지 경우로 나눠서 생각해봐야한다.
    - 다음 자리수가 0~4인 경우 : 내려가는게 이득이다.
    - 다음 자리수가 5~9인 경우 : 올라가는게 이득이다.(다음 자리수 올림)
- 최종적으로 버튼을 누른 횟수를 출력한다.

---

