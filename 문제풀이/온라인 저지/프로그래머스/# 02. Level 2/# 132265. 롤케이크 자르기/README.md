# 문제
- 플랫폼 : 프로그래머스
- 번호 : 132265
- 제목 : 롤케이크 자르기
- 난이도 : Level 2
- 롤케이크에 올려진 토핑들의 번호를 저장한 정수 배열 topping이 매개변수로 주어질 때, 롤케이크를 공평하게 자르는 방법의 수를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/132265" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```kotlin
class Solution {
    fun solution(topping: IntArray): Int {
        val counterA = HashMap<Int, Int>()
        val counterB = HashMap<Int, Int>()
        var answer = 0
        for (item in topping) {
            if (counterA.containsKey(item)) {
                counterA[item] = counterA[item]!! + 1
            } else {
                counterA[item] = 1
            }
        }
        for (item in topping) {
            counterA[item] = counterA[item]!! - 1
            if (counterA[item] == 0) counterA.remove(item)
            if (counterB.containsKey(item)) {
                counterB[item] = counterB[item]!! + 1
            } else {
                counterB[item] = 1
            }
            if (counterA.size == counterB.size) answer ++
        }
        return answer
    }
}
```
- 해시 테이블을 통해 철수/동생 각각이 가진 토핑의 갯수를 카운팅한다.
  - counterA : 철수의 토핑 갯수 / counterB : 동생의 토핑 갯수
- 우선 counterA에 토핑을 전부 몰아넣어서 카운팅한다.
- 그 후 toppings를 순서대로 탐색하면서, 반대쪽에 하나씩 토핑을 덜어준다. 이때 counterA 측에서 토핑 갯수가 0이 된 key는 제거한다.
- 매 순간 각각이 가진 토핑의 종류를 size 메서드를 통해 확인하여 같으면 answer를 증가시킨다.

---
