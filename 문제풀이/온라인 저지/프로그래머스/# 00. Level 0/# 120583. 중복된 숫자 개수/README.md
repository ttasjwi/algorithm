# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120583
- 제목 : 중복된 숫자 개수
- 난이도 : Level 0
- array에 n이 몇 개 있는 지
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120583)

---

# 필요 지식
- 없음

---

# 풀이
## Kotlin
```kotlin
class Solution {
    fun solution(array: IntArray, n: Int): Int {
        return array.count { it == n }
    }
}
```


## Python
```python
from typing import List


def solution(array: List[int], n: int):
    return array.count(n)

```
- 리스트의 count 메서드는 해당 요소의 갯수를 반환한다.

---

## Java
## 풀이1 : 반복문
```java
    public int solution(int[] array, int n) {
        int answer = 0;
        for (int number : array) {
            if (number == n) {
                answer ++;
            }
        }
        return answer;
    }
```

---

## 풀이2 : Stream 사용
```java
    public int solution(int[] array, int n) {
        return (int) Arrays.stream(array)
                .filter(number -> number == n)
                .count();
    }
```

---
