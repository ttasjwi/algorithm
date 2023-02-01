# 문제
- 플랫폼 : 프로그래머스
- 번호 : 138477
- 제목 : 명예의 전당 (1)
- 난이도 : Level 1
- 매일 발표된 명예의 전당의 최하위 점수를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/138477" target="_blank">링크</a>

---

# 필요 지식
- 삽입 정렬
- 파이썬의 팀소트 == 병합정렬과 삽입정렬을 휴리스틱하게, 적절히 조합해 사용 

---

# 풀이
```python
def solution(k, score):
    answer = []
    record = []
    for i in range(len(score)):
        if 0 <= i < k:
            record.append(score[i])
            record.sort()
        elif record[0] < score[i]:
            record[0] = score[i]
            record.sort()
        answer.append(record[0])
    return answer
```
- k-1번 인덱스까지는 계속 점수를 삽입하고, 매번 정렬한다.
- k번 인덱스부터는 0번 인덱스의 요소보다 큰 값이면 대체하고 정렬한다.
  - 이미 정렬되어 거의 정렬 되어있는 상태면 시간복잡도가 거의 O(N)이 된다. 파이썬의 정렬함수는 팀소트를 사용하면서, 저수준 언어의 언어를 사용해
  매우 신중하게 작성되었기 때문에 매우 빠르다.
- 0번 인덱스의 요소(제일 작은 값)를 answer에 삽입한다.

---
