# 문제
- 플랫폼 : 프로그래머스
- 번호 : 131127
- 제목 : 할인 행사
- 난이도 : Level 2
- 회원등록시 정현이가 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수를 return 하는 solution 함수 작성
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/131127" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```kotlin
class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        val wantCounter = HashMap<String, Int>()
        val counter = HashMap<String, Int>()
        for (i in 0 until want.size) {
            wantCounter[want[i]] = number[i]
            counter[want[i]] = 0
        }
        for (item in discount) {
            if (!counter.containsKey(item)) counter[item] = 0
            if (!wantCounter.containsKey(item)) wantCounter[item] = 0
        }
        for (i in 0 until 10) counter[discount[i]] = counter[discount[i]]!! + 1

        var answer = 0
        if (wantCounter == counter) answer ++
        for (day in 10 until discount.size) {
            counter[discount[day-10]] = counter[discount[day-10]]!! - 1
            counter[discount[day]] = counter[discount[day]]!! + 1
            if (wantCounter == counter) answer ++
        }
        return answer
    }
}
```
- wantCounter : 내가 원하는 갯수를 가리키는 카운터
- counter : 최근 10일간, 각 제품 할인일수 누적 카운터
- 카운터를 비교하기 위해서는 각 카운터가 가진 제품군의 종류를 맞춰줘야한다.
  - 우선 want/number를 읽고 내가 원하는 제품의 카운트를 전부 맵에 해싱한다. counter에도 품목의 갯수를 0으로 초기화한다.
  - discount 배열을 모두 읽고, wantCounter 또는 counter에 없는 제품군의 카운트를 0으로 초기화한다.
- 처음 10일치 discount 내열에 맞춰서 count 배열 카운트를 초기화한다.
- 처음 10일치 할인 내역과 wantCouter 맵을 비교하여 같은지 확인 후 answer를 증가시킨다. (equals를 이용해 비교)
- 이후 날짜를 하루 증가시켜가면서 10일 전 할인품목의 카운트를 1 감소시키고 현재 날짜 할인품목의 카운트를 1 증가시킨다.
- 날짜마다 counter, wantCounter가 동등한지 비교하고 answer를 증가시킨다.

---
