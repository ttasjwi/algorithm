# 문제
- 플랫폼 : 프로그래머스
- 번호 : 131704
- 제목 : 택배상자
- 난이도 : Level 2
- 영재가 몇 개의 상자를 실을 수 있는지 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/131704" target="_blank">링크</a>

---

# 필요 지식
- 스택

---

# 풀이
```kotlin
class Solution {
    fun solution(order: IntArray): Int {
        var answer = 0
        val sub = Stack(order.size)
        var box = 1
        for (curOrder in order) {
            if (box <= curOrder) {
                while (box < curOrder) sub.push(box++)
                answer++
                box++
                continue
            }
            if (sub.isNotEmpty() && sub.pop() == curOrder) {
                answer++
            } else {
                break
            }
        }
        return answer
    }
}

class Stack(cap: Int) {
    private val arr = IntArray(cap)
    private var size = 0
    fun push(e: Int) {
        arr[size++] = e
    }

    fun pop(): Int = arr[--size]
    fun isNotEmpty(): Boolean = size != 0
}
```
- answer : 트럭에 실은 화물의 갯수
- sub : 서브 컨테이너 (스택)
- box : 현재 메인 컨테이너에서 바라보고 있는 상자
- order 배열에서 curOrder(현재 상자)를 확인한다.
  - 현재 바라보고 있는 상자가 curOrder보다 작거나 같으면 상자번호가 같아질 때까지 서브 컨테이너에 옮긴뒤.(push), 트럭에 curOrder의 상자를 옮긴다.(answer 증가)
  - 현재 바라보고 있는 상자가 curOrder보다 크면, 보조 컨테이너 최상단에 있는 상자가 원하는 상자인지 확인한다.
  원하는 상자가 아니면 반복을 멈추고 원하는 상자면 꺼내서 트럭에 옮긴다.(answer 증가)
- answer를 반환한다.

---
