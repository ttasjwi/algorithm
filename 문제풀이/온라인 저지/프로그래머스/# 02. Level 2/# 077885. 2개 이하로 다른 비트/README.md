# 문제
- 플랫폼 : 프로그래머스
- 번호 : 077885
- 제목 : 2개 이하로 다른 비트
- 난이도 : Level 2
- 각 수의 f 값을 배열에 차례대로 담아 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/77885" target="_blank">링크</a>

---

# 필요 지식
- 비트 마스킹
- 문자열 처리

---

# 풀이
```kotlin
import java.util.*

class Solution {
    fun solution(numbers: LongArray): LongArray {
        fun f(x: Long): Long {
            if (x % 2 == 0L) return x + 1
            val chars = x.toString(2).toCharArray()
            val index = chars.lastIndexOf('0')
            if (index == -1) return (1L shl chars.size) or (x shr 1)
            chars[index] = '1'
            chars[index+1] = '0'
            return String(chars).toLong(2)
        }
        for (i in numbers.indices) {
            numbers[i] = f(numbers[i])
        }
        return numbers
    }

}
```
- 짝수는 숫자가 xxxx0 으로 끝나는데, 끝의 0만 1로 바꾸면 된다. 따라서 이 경우, 1을 더해서 반환하면 된다.
- 홀수는 숫자가 xxxx1로 끝난다. 이 경우 오른쪽 끝에서 0을 찾아서 그걸 1로 바꾸고 그 아래 자리의 1을 0으로 바꾸면 된다.
  - `chars = x.toString(2).toCharArray()` : 숫자를 2진 문자열로 변환하고 문자 배열로 변환한다.
  - lastIndexOf 메서드를 통해 끝에서 '0' 이 속한 인덱스를 찾는다.
    - 찾지 못 할 경우(-1) 모든 비트가 1111...1 인 경우인데 이 경우 한자리 큰 100000..00 을 구한뒤 그 뒤에 원본 숫자의 비트를 오른쪽으로 1칸 민 숫자를 or로 붙이면 된다.
    - 찾았다면 그 위치를 '1' 로 바꾸고 그 다음 인덱스의 비트를 '0'으로 바꾼다.
  - chars를 문자열로 변환하고(chars) toLong 함수를 통해 다시 Long으로 바꾼다.
---
