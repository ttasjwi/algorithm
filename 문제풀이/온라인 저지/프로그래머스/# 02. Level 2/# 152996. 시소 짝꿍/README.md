# 문제
- 플랫폼 : 프로그래머스
- 번호 : 152996
- 제목 : 시소 짝꿍
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/152996" target="_blank">링크</a>

---

# 필요 지식
- 메모이제이션
- 해시

---

# 풀이
```python
def solution(weights):
    rates = {4/2, 4/3, 3/2, 2/4, 3/4, 2/3, 1}
    counter = dict() # 어떤 무게의 등장 횟수
    answer = 0
    for w in weights:
        for r in rates:
            nw = w * r # 자신의 무게에 대해 모든 배율 적용 곱들
            
            # 자신의 r배에 해당하는 무게가 존재하면
            if nw in counter:
                # 그 무게에 해당하는 갯수만큼 가능한 선택 가짓수 증가 (case : 나자신- 반대쪽[기존 존재하는 해당무게 등장횟수])
                answer += counter[nw]
                
        # 내 무게에 해당하는 counter 값 증가
        if w not in counter:
            counter[w] = 1
        else:
            counter[w] += 1
    return answer
```
- 모든 가짓수를 탐색하는 방법도 있긴한데 시간 복잡도가 O(N2) 이므로 시간 초과됨
- 메모이제이션을 통해 문제를 O(N)으로 해결할 수 있도록 변형
