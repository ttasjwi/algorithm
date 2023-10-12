# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012985
- 제목 : 예상 대진표
- 난이도 : Level 2
- 처음 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12985" target="_blank">링크</a>

---

# 필요 지식
- 수학

---

# 풀이
```kotlin
class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var x = a-1
        var y = b-1
        while (true) {
            answer ++
            if ((x%2 == 0 && y == x+1) || (x%2 == 1 && y == x-1)) break
            x /= 2
            y /= 2
        }
        return answer
    }
}
```
- 2로 나눠서 나누어 떨어지는 연산을 따지기에는 0,1,2,3... 순으로 따지는게 편해서 우선 a,b에서 1을 차감한 값을 각각 x, y에 할당했다.
- 다음을 반복한다.
  - answer를 증가시킨다.
  - x,y가 같은 스테이지에 속하는 경우는 x가 짝수인데 y가 x 다음인 경우 또는 x가 홀수인데 y가 x 이전인 경우다. 이를 만족하면 탈출한다.
  - x, y를 2로 나눈다.
- answer를 출력한다.
