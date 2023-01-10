# BOJ 01330 : 두 수 비교하기
- 난이도 : Bronze 5
- 문제 : [링크](https://www.acmicpc.net/problem/1330)

---  

## 풀이
```python
def main():
    a, b = input_numbers()  # 숫자를 입력받아 튜플에 저장
    answer = solution(a, b)  # 결과 문자열을 얻어옴
    print(answer, end='')  # 출력


# 숫자를 입력받음
def input_numbers():
    return map(int, input().split())


# 결과 문자열 생성
def solution(a, b):
    if a > b:
        return '>'
    elif a < b:
        return '<'
    else:
        return '=='


main()
```
- 숫자를 입력받고 비교하여 결과 문자열을 얻어온다.
- 결과 문자열을 출력한다.

---
