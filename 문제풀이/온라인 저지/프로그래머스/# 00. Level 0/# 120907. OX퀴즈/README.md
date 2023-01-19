# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120907
- 제목 : OX퀴즈
- 난이도 : Level 0
- 수식이 옳다면 "O"를 틀리다면 "X"를 순서대로 담은 배열을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120907)

---

# 필요 알고리즘
- 문자열 처리

---

# Python
## 풀이1
```python
import re
from typing import List


def is_right(q):
    g = re.match(r'(-?\d+)\s([+-])\s(-?\d+)\s=\s(-?\d+)', q).groups()
    x, oper, y, z = int(g[0]), g[1], int(g[2]), int(g[3])
    return (x + y == z) if oper == '+' else (x - y == z)


def solution(quiz: List[str]):
    return ["O" if is_right(q) else 'X' for q in quiz]
```
- 정규 표현식으로 쪼갠 뒤, 그룹핑하여 튜플로 받아온 뒤 비교하였다.

## 풀이2
```python
from typing import List

RIGHT_MARK = 'O'
WRONG_MARK = 'X'


def solution(quiz: List[str]):
    return [RIGHT_MARK if is_right(q) else WRONG_MARK for q in quiz]


def is_right(q: str):
    x, oper, y, _, z = q.split(' ')
    return int(x) + get_sign(oper) * int(y) == int(z)


def get_sign(oper):
    return 1 if oper == '+' else -1

```
- is_right 함수로 판단 여부 위임
  - 분리 : x, oper, y, z
  - get_sign : oper를 통해 y에 취해줘야 하는 부호값을 구함
  - 비교

## 풀이3
```python
from typing import List


def solution(quiz: List[str]):
  return ["O" if eval(q.replace('=', '==')) else 'X' for q in quiz]

```
- 킹갓 eval

---

## Java
```java
public class Solution {

    private static final String ANSWER_MARK = "O";
    private static final String WRONG_MARK = "X";

    public String[] solution(String[] quizs) {
        String[] answer = new String[quizs.length];
        for (int i=0; i<quizs.length; i++) {
            answer[i] = isAnswer(quizs[i]) ? ANSWER_MARK : WRONG_MARK;
        }
        return answer;
    }

    private boolean isAnswer(String quiz) {
        String[] splited = quiz.split(" ");
        // 0번 : 피제수 1
        // 1번 : 연산자
        // 2번 : 피제수 2
        // 3번 : =
        // 4번 : 결과

        return Integer.parseInt(splited[0]) + getSign(splited[1]) * Integer.parseInt(splited[2])
                == Integer.parseInt(splited[4]);
    }

    private int getSign(String operator) {
        return (operator.charAt(0) == '+')
                ? 1
                : -1;
    }

}
```
- Python의 2번 풀이 방식

---
