# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120585
- 제목 : 머쓱이보다 키 큰 사람
- 난이도 : Level 0
- 키가 담긴 정수 배열 array와 머쓱이의 키 height가 매개변수로 주어질 때, 머쓱이보다 키 큰 사람 수를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120585)

---

# 필요 알고리즘
- python : 리스트 필터링, 특정 조건 만족 요소 카운팅
- java : 반복문

---

# Python
## 풀이1
```python
from typing import List


def solution(array: List[int], height: int):
    return len(list(filter(lambda num: num > height, array)))

```
- 필터링 -> 리스트화 -> 리스트 길이 반환


## 풀이2
```python
from typing import List


def solution(array: List[int], height: int):
    return sum(1 for h in array if h > height)

```
- 리스트 컴프리헨션을 통해 조건을 만족하는 각 요소들을 숫자 1로 변환한 리스트로 만든 뒤, 이 값들을 모두 합산


---

# Java

## 풀이1
```java
    public int solution(int[] array, int height) {
        int answer = 0;
        for (int h : array) {
            if (h > height) {
                answer ++;
            }
        }
        return answer;
    }
```
- 반복 순회하면서, 키가 더 크면 answer 증가

---

## 풀이2
```java
    public int solution(int[] array, int height) {
        return (int) Arrays.stream(array)
                .filter(h -> h > height)
                .count();
    }
```
- Stream으로 필터링 후, 카운팅

---
