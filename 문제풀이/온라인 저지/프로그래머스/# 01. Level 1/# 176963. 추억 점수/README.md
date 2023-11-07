# 문제
- 플랫폼 : 프로그래머스
- 번호 : 176963
- 제목 : 추억 점수
- 난이도 : Level 1
- 각 사진에 찍힌 인물의 이름을 담은 이차원 문자열 배열 photo가 매개변수로 주어질 때, 사진들의 추억 점수를 photo에 주어진 순서대로 배열에 담아 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/176963 target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```kotlin
class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val map = HashMap<String, Int>()
        for (i in name.indices) {
            map[name[i]] = yearning[i]
        }
        val result = IntArray(photo.size)
        for (i in photo.indices) {
            for (e in photo[i]) {
                if (map.containsKey(e)) {
                    result[i] += map[e]!!
                }
            }
        }
        return result
    }
}
```
- 추억점수를 해싱해둔다.
- 그림에서 나오는 사람들을 맵에서 꺼내 점수를 계산한다. 맵에 없으면 점수를 계산하지 않는다.

---
