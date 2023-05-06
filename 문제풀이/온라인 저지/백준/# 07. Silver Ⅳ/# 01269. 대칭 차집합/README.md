# 문제
- 플랫폼 : 백준
- 번호 : 01269
- 제목 : 대칭 차집합
- 난이도 : Silver 4
- 대칭 차집합의 원소의 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1269" target="_blank">링크</a>

---

# 필요 지식
- 수학?

---

# 풀이

## 풀이1: set 자료형 활용
```python
input()

a = set(map(int, input().split()))
b = set(map(int, input().split()))
print(len((a | b) - (a & b)))
```
- 각각의 set을 구하고 조건 그대로 합집합 후 교집합을 제한다.

## 풀이2: 원소의 갯수
```python
na, nb = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
print(2 * len(set(a+b)) - na - nb)
```
- 대칭차집합 = (합집합) - (교집합) 에서 수식을 유도해보면
    - 대칭차집합 = 2 * (합집합) - a - b

---
