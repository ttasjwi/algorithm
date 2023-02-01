# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042576
- 제목 : 완주하지 못한 선수
- 난이도 : Level 1
- 완주하지 못한 선수의 이름을 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42576" target="_blank">링크</a>

---

# 필요 지식
- 해시
- 파이썬 : Counter

---

# 풀이

## Python

### 풀이1
```python
from collections import Counter


def solution(participant, completion):
    participant, completion = Counter(participant), Counter(completion)
    for key, value in participant.items():
        if key not in completion or completion[key] != value:
            return key
```
- 파이썬에서는 Counter를 통해, 각각의 요소들의 등장횟수를 카운터로 모을 수 있다.
- participant를 순회하면서, completion에 없거나, value가 다른 값을 찾아 바로 반환한다.

### 풀이2
```python
from collections import Counter


def solution(participant, completion):
    return list((Counter(participant) - Counter(completion)).keys())[0]
```
- Counter 끼리는 뺄 수 있는데, 연산의 결과 카운트가 0이면 해당 key, value 쌍은 삭제시키는 식으로 카운트를 차감한다. 연산의 결과
남아있는 요소가 우리가 찾는 답이다.
- 이 점을 이용하여 Counter를 바로 list화 하고, 0번 인덱스의 요소를 반환시키면 된다.

## Java
```java
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String solution(String[] participants, String[] completions) {
        Map<String, Integer> counter = new HashMap<>();
        for (String p : participants) counter.put(p, counter.getOrDefault(p, 0) + 1);
        for (String c : completions) counter.put(c, counter.get(c) - 1);

        for (String key : counter.keySet()) {
            if (counter.get(key) != 0) {
                return key;
            }
        }
        return "";
    }

}
```
- 자바에서는 카운터가 없으므로 직접 카운터를 만들어야한다.
- 카운터에, 참가자가 등장할 때마다 참가자의 카운트를 증가시킨다.
  - key를 참가자명, value를 참가자 등장 횟수로 한다.
  - `.getOrDefault(...)`를 사용하면 기본값을 지정하여 가져올 수 있다.
- 완주자를 순서대로 참가자 카운터에서 차감한다.
- 카운터의 keySet을 순서대로 탐색하면서, 해당 key의 카운트가 0이 아닌 key를 찾아내 바로 반환하면 된다.
- 마지막에 있는 null은 문제의 조건대로라면 절대 반환될 일이 없지만 작성하지 않으면 컴파일 에러가 발생하기 때문에 작성했다.

---
