# 문제
- 플랫폼 : 프로그래머스
- 번호 : 178870
- 제목 : 연속된 부분 수열의 합
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/178870" target="_blank">링크</a>

---

# 필요 지식
- 누적합
- 이분탐색
- 투포인터

---

# 풀이

## 풀이1: 투 포인터
```python
def solution(sequence, k):
    min_length = 1_000_001
    answer = [-1, -1]
    lt = 0
    rt = 0
    range_sum = sequence[0]

    while lt <= rt < len(sequence):
        if range_sum == k:
            length = rt - lt
            if length < min_length or (length == min_length and lt < answer[0]):
                answer[0] = lt
                answer[1] = rt
                min_length = length
            range_sum -= sequence[lt]
            lt += 1
            if rt < len(sequence) - 1:
                rt += 1
                range_sum += sequence[rt]
        elif range_sum < k:
            if rt < len(sequence) - 1:
                rt += 1
                range_sum += sequence[rt]
            else:
                break
        else:
            range_sum -= sequence[lt]
            lt += 1
    return answer
```
- 시작점, 끝점을 전진시켜가는 방법이다.
- 시간 복잡도는 O(n)이 된다.


## 풀이2: 이분탐색
```python
def solution(sequence, k):
    sums = [0] * len(sequence)
    sums[0] = sequence[0]
    for i in range(1, len(sequence)):
        sums[i] = sums[i - 1] + sequence[i]

    min_length = 1_000_001
    answer = [-1, -1]

    for start in range(len(sequence)):
        lt = start
        rt = len(sequence) - 1
        end = -1
        while lt <= rt:
            mid = (lt + rt) >> 1
            current_sum = sums[mid] - sums[start] + sequence[start]
            if current_sum == k:
                end = mid
                break
            elif current_sum > k:
                rt = mid - 1
            else:
                lt = mid + 1
        if end != -1:
            length = end - start
            if length < min_length or (length == min_length and start < answer[0]):
                answer[0] = start
                answer[1] = end
                min_length = length
    return answer
```
- 0,1,2,...마지막 인덱스까지 자기 자신을 시작점으로 잡고 끝점을 이분탐색으로 찾는다.
- 시작점~끝점의 합은 누적합을 이용해 계산하면 빠르게 계산할 수 있다.
- 이 풀이는 시간복잡도가 O(nlogn)이 된다.
