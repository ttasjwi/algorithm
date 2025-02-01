# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012932
- 제목 : 자연수 뒤집어 배열로 만들기
- 난이도 : Level 1
- 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12932" target="_blank">링크</a>

---

# 필요 지식
- 문자열
- 수학

---

# 풀이

### 풀이1: 문자열 처리
```python
def solution(n):
    return [int(ch) for ch in str(n)][::-1]
```
- 문자열화 시킨 후 뒤집기
- int 배열로 변환
- 뒤집기 (리스트 슬라이싱)

### 풀이2: 수학적 접근
```python
def solution(n):
    result = []
    while n:
        n, r = divmod(n, 10)
        result.append(r)
    return result
```
- 계속적으로 10으로 나눠가면서 나머지를 배열에 추가

---
