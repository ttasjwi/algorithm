# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120956
- 제목 : 옹알이 (1)
- 난이도 : Level 0
- 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120956)

---

# 필요 알고리즘
- 문자열 처리

---

# Python
```python
from typing import List


def solution(babbling: List[str]):
    return sum(1
               for word in babbling
               if word.replace("aya", " ").replace("ye", " ").replace("woo", " ").replace("ma", " ").isspace())

```
- 정규표현식을 이용한 풀이도 있을 수 있겠으나 현실적으로 시험 중에 정규표현식을 쓰는건 힘들다.
- 단어들을 빈 문자열로 만들면 잘려지고 붙여진 단어가 맞아지는 상황이 발생하기에 공백으로 변경하는 과정을 거친다.
- 마지막에, 단어가 공백 문자열이면 말할 수 있는 단어이므로 1을 합산한다.


---

# Java
```java
public class Solution {

    public int solution(String[] babbling) {
        int answer = 0;
        for (String word : babbling) {
            if (speakable(word)) {
                answer ++;
            }
        }
        return answer;
    }

    private boolean speakable(String word) {
        return word.replace("aya", " ")
                .replace("ye", " ")
                .replace("woo", " ")
                .replace("ma", " ")
                .isBlank();
    }

}
```
- 위와 마찬가지의 풀이

---
