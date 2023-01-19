# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120899
- 제목 : 가장 큰 수 찾기
- 난이도 : Level 0
- array가 매개변수로 주어질 때, 가장 큰 수와 그 수의 인덱스를 담은 배열을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120899)

---

# 필요 알고리즘
- python : 리스트 사용법
- java : 최댓값 갱신

---

# Python
```python
from typing import List


def solution(array:List[int]):
    max_value = max(array)
    index = array.index(max_value)
    return [max_value, index]
```

---

# Java
```java
public class Solution {
    public int[] solution(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i=0; i<array.length; i++) {
            if (maxValue < array[i]) {
                maxValue = array[i];
                maxIndex = i;
            }
        }
        return new int[]{maxValue, maxIndex};
    }
}
```
- 최댓값과 그 인덱스를 동시에 갱신시킨다.
- 시간 복잡도 : O(N)

---
