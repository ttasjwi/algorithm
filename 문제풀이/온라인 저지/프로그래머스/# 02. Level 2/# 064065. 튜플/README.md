# 문제
- 플랫폼 : 프로그래머스
- 번호 : 064065
- 제목 : 튜플
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/64065" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리
- 구현

---

# 풀이
```python
def solution(s):
    result = []
    num_set = set()
    for num_list in sorted([list(map(int, x.split(','))) for x in s[2:-2].split('},{')], key=lambda x: len(x)):
        for i, num in enumerate(num_list):
            if num not in num_set:
                result.append(num)
                num_set.add(num)
                break

    return result
```
- `s[2:-2]` : 먼저 문자열 양 끝의 `{{`, `}}` 를 제거한다.
  - 이렇게 하면 `2},{2,1},...},{2,1,3,4` 꼴이 된다.
- 이를 다시 `},{` 을 기준으로 구분한다.
  - 이렇게 하면 `2 / 2,1 / 2,1,3 / 2,1,3,4` 꼴이 된다.
- 각각을 다시 , 로 구분 한뒤, 모두 숫자화 시킨 것을 list 로 구성한다.
  - `[2], [2,1], [2,1,3], [2,1,3,4]`
- 이들을 배열 길이 순으로 오름차순 정렬한다.
- 배열은 원소수가 적은 순으로 구성되는데, 이 상태에서 원소수가 작은 리스트부터 순서대로 num_set 에 등장한 숫자를 넣고, num_set 에 포함되지 않은
숫자를 result 에 삽입한다. (포함되지 않은 숫자가 등장했다면 더 이상 그 리스트에서는 숫자를 삽입하지 않아도 되므로 그 부분은 탈출하는 식으로 최적화)

---
