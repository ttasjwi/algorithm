# 문제
- 플랫폼 : 프로그래머스
- 번호 : 070129
- 제목 : 이진 변환 반복하기
- 난이도 : Level 2
- 0과 1로 이루어진 문자열 s가 매개변수로 주어지고  s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때,
이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/70129" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리
- 구현

---

# 풀이
```kotlin
fun solution(s: String): IntArray {
    var x = s
    val sb= StringBuilder()
    var cnt = 0
    var delete = 0
    while (x != "1") {
        for (ch in x) {
            if (ch == '0') delete ++
            else sb.append(ch)
        }
        x = sb.length.toString(2)
        cnt ++
        sb.setLength(0)
    }
    return intArrayOf(cnt, delete)
}
```
- while 문을 통해 루프를 돌리며 변환 작업을 한다.(x가 1이 아니게 될 때까지)
  - 문자를 하나하나 읽어가며 0이면 delete 증가 1이면 sb에 append
  - sb의 길이를 2진 문자열로 변환한뒤 x에 재할당
  - cnt 증가 후 sb 초기화
- 이렇게 구해진 cnt와 delete를 배열에 담아 반환한다.

---
