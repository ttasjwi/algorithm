# 문제
- 플랫폼 : 백준
- 번호 : 17202
- 제목 : 핸드폰 번호 궁합
- 난이도 : Bronze 1
- A와 B의 핸드폰 번호 궁합률을 두자리 정수로 출력(십의 자리가 0이어도 앞에 0을 붙여 두자리로 출력)
- 문제 : <a href="https://www.acmicpc.net/problem/17202" target="_blank">링크</a>

---

# 필요 지식
- DP

---

# 풀이

## 내 풀이
```python
def foo(x):
    y = []
    for i in range(len(x) - 1):
        y.append((x[i] + x[i + 1]) % 10)
    return y

# 입력
a = [int(ch) for ch in input()]
b = [int(ch) for ch in input()]

# 입력값들을 순서대로 교차해서 리스트에 추가
x = []
for i in range(len(a)):
    x.append(a[i])
    x.append(b[i])

# 리스트의 길이가 2가 넘는 동안 반복하여 핸드폰 번호 처리
while len(x) > 2:
    x = foo(x)

# 출력
print(''.join(map(str, x)))
```
- 배열 두 개에 숫자를 저장
- x 배열에 두 배열을 번갈아가면서 저장
- x 배열의 길이가 2가 넘는 동안 반복해서, 핸드폰 번호 숫자 처리
- 출력

## 다른 사람 풀이
```python
# 입력을 짝, 홀 인덱스에 번갈아가며 저장
x = [0] * 16
x[::2] = map(int, input())
x[1::2] = map(int, input())

# 리스트의 길이가 2가 넘는 동안 반복하여 핸드폰 번호 처리
while len(x) > 2:
    x = [(i + j) % 10 for i, j in zip(x, x[1:])]

print(''.join(map(str, x)))
```
- 입력을 배열의 짝 홀 인덱스에 번갈아 받으며 입력할 수 있는 파이썬 리스트 슬라이싱 기법 활용
- zip을 활용하여, 배열 자신과, 한칸 뒤부터 시작되는 배열을 엮어서 표현을 간결화

---
