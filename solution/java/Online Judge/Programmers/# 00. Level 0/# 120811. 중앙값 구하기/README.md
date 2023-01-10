# Programmers 120811 : 중앙값 구하기
- 난이도 : Level 0
- 숫자를 순서대로 정렬하였을 때의 가운데 값인 '중앙값' 구하기
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120811)

---

## 풀이
```java
import java.util.*;

public class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    }
}
```
- 정렬
- 가운데 인덱스의 숫자 반환

---
