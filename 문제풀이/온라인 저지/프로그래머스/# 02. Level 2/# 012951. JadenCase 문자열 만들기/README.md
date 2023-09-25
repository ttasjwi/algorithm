# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012951
- 제목 : JadenCase 문자열 만들기
- 난이도 : Level 2
- 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12951" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리

---

# 풀이

## 풀이1: 반복문
```kotlin
class Solution {
    fun solution(s: String): String {
        var isStartChar = true
        val sb = StringBuilder()
        for (i in s.indices) {
            if (s[i] == ' ') {
                sb.append(s[i])
                isStartChar = true
            } else if (isStartChar) {
                sb.append(s[i].uppercaseChar())
                isStartChar = false
            } else {
                sb.append(s[i].lowercaseChar())
            }
        }
        return sb.toString()
    }
}
```
- StringBuilder에 순서대로 문자를 수집한다.
- 단어의 시작점임을 구분하기 위해 isStartChar를 사용한다.
- 공백문자를 만나면 isStartChar를 true로 초기화한다.
- isStartChar가 true이면 첫문자이므로 대문자화한다. 그리고 isStartChar를 false로 변경한다.
- isStartChar가 false이면 중간문자이므로 소문자화한다.

## 풀이2: 고차함수
```kotlin
class Solution2 {
    fun solution(s: String) = s.lowercase().split(' ').map { it.capitalize() }.joinToString(" ")
}
```
- 이 방식을 쓰면 좀 더 간편하게 문제를 해결할 수 있긴하다.
- 하지만 1번 방식은 0.1ms 로 해결할 수 있지만 2번 방식은 10ms 넘게 걸린다.

---
