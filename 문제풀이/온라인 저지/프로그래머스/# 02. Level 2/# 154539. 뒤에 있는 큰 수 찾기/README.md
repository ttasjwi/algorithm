# 문제
- 플랫폼 : 프로그래머스
- 번호 : 154539
- 제목 : 뒤에 있는 큰 수 찾기
- 난이도 : Level 2
- 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/154539" target="_blank">링크</a>

---

# 필요 지식
- 스택

---

# 풀이
```kotlin
class Solution {
    fun solution(numbers: IntArray): IntArray {
        val stack = IntArray(numbers.size)
        val result = IntArray(numbers.size)
        var size = 0
        for (i in numbers.indices) {
            while(size > 0) {
                if (numbers[stack[size-1]] < numbers[i]) {
                    result[stack[size-1]] = numbers[i]
                    size --
                } else {
                    break
                }
            }
            stack[size++] = i
        }
        while (size > 0) {
            result[stack[size-1]] = -1
            size --
        }
        return result
    }
}
```
- 스택에는 오큰수(오른쪽에서 가장 가까운 큰 수)를 찾는 지점의 인덱스를 삽입한다.
- numbers의 인덱스를 순서대로 탐색하면서 다음을 수행한다.
  - 다음을 반복한다. (스택이 비어있을 경우 반복을 멈춘다.)
    - 스택의 최상단 요소(인덱스)가 가리키는 값이 현재 값보다 작으면 스택에서 해당 인덱스를 꺼내고, `results[꺼낸 인덱스] = 현재값` 으로 갱신한다.
      - 해당 인덱스보다 더 오른쪽에서 큰 값이 발견됐기 때문이다.
    - 스택의 최상단 요소(인덱스)가 가리키는 값이 현재 값보다 크거나 같으면 더 이상 꺼낼 수 없으므로 반복을 탈출한다.
      - 스택 최상단 요소(인덱스) 아래에 있는 요소(인덱스)가 가리키는 값들은 애시당초 더 크므로 탐색할 가치가 없다.
  - 스택에 현재 인덱스를 삽입한다.
- 이렇게 끝까지 반복하고나면 스택에 남은 인덱스들은 오큰수를 찾지 못 한 인덱스들이다. 하나씩 꺼내가면서 그 값을 -1로 갱신한다.

---
