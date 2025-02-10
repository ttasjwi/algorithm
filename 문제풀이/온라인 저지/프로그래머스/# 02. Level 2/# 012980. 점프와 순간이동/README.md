# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012980
- 제목 : 점프와 순간이동
- 난이도 : Level 2
-  아이언 슈트 구매자가 이동하려는 거리 N이 주어졌을 때, 사용해야 하는 건전지 사용량의 최솟값을 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12980" target="_blank">링크</a>

---

# 필요 지식
- 비트마스킹

---

# 풀이
### 풀이1: 나머지 연산
```python
def solution(n):
    answer = 0
    while n:
        if not n % 2:
            n >>= 1
        else:
            answer += 1
            n -= 1
    return answer
```
- n이 짝수인 동안 2로 나누어가다가, 홀수가 되면 1을 빼고 answer 를 증가시킨다.

### 풀이2: 비트
```python
def solution(n):
    return bin(n).count('1')
```
- 결국 이진수 문자열로 변환했을 때 1의 갯수를 세는 문제가 된다.

---
