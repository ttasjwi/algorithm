# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012949
- 제목 : 행렬의 곱셈
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12949" target="_blank">링크</a>

---

# 필요 지식
- 수학
- 구현

---

# 풀이

### 풀이1: 3중 for 문
```python
def solution(arr1, arr2):
    result = [[0 for _ in range(len(arr2[0]))] for _ in range(len(arr1))]

    for i in range(len(arr1)):
        for j in range(len(arr2[0])):
            for k in range(len(arr2)):
                result[i][j] += arr1[i][k] * arr2[k][j]
    return result
```
- 행렬 A, 행렬 B 에 대해서 이 둘의 곱 `A * B [i][j]` 는
  - 행렬 A의 i행: `A[i][k]`
  - 행렬 B 의 j열: `B[k][j]`
  - 여기서 k를 계속 증가시켜가면서 곱쌍을 합한다

### 풀이2: python 스러운 풀이
```python
def solution(A, B):
    return [[sum(a*b for a,b  in zip(a_row, b_col)) for b_col in zip(*B)] for a_row in A]
```
- 리스트 컴프리헨션, zip 함수를 이용해 이를 좀 더 풀어서 해결할 수 있다.
- 뭔 소리지?!
  - `for a_row in A` : A 의 모든 행에 접근해서, 순서대로 사용한다. (i행)
  - `for b_col in zip(*B)` : B의 모든 행을 zip 으로 엮음(순서대로 호출하면 각 행의 j 열이 된다.)
  - 이제 i행 j 열을 채워야한다. a_row 와 b_col 의 요소를 순서대로 접근해서 곱해나가서 합한다.

---
