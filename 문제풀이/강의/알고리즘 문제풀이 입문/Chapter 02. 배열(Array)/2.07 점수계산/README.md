# 문제
- 플랫폼 : 인프런 알고리즘 문제풀이 입문
- 번호 : 2.07
- 제목 : 점수계산
- 여러 개의 OX 문제로 만들어진 시험에서 연속적으로 답을 맞히는 경우에는 매 회마다 1씩 가산점을 추가 부여함. 총점을 구하여라.

---

# 필요 지식
- 리스트 처리

---

# 풀이

## 풀이1: for문 방식
```python
input()

answer = 0
bonus = 0
for point in input().split():
    if point == '1':
        bonus += 1
        answer += bonus
    else:
        bonus = 0
print(answer, end='')
```
- bonus : 가산점
- total : 총점
- 정답이면 가산점 +1 후 추가, 틀리면 가산점을 0으로 초기화

## 풀이2: 투 포인터
```python
input()
points = input().split()
lt = 0
answer = 0
while lt < len(points):
    rt = lt
    bonus = 0
    while rt < len(points) and points[rt] == '1':
        bonus += 1
        answer += bonus
        rt += 1
    lt = rt + 1
print(answer)
```
- 두 개의 포인터를 준비하고
  - lt 는 처음 따지기 시작하는 지점
  - rt 는 lt에서 시작하여 연속해서 맞을 때마다 전진하는 포인터로 삼는다. 이떄 bonus를 1씩 증가시켜가면서 answer 에 bonus를 더한다.
- 계속 맞는동안 rt 를 전진시키고, 틀리는 지점이 오면 더 rt를 전진하지 않는다.
- 마지막에 lt 를 rt + 1 로 이동시킨다.

---
