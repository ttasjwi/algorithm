# BOJ 01000 : A+B
- 난이도 : Bronze 5
- 입력값 두개를 받고 합산한 결과 값 출력 하기(단순 입출력)
- 문제 : [링크](https://www.acmicpc.net/problem/1000)

---  

## 풀이
```python
def main():
    numbers = input_numbers()
    answer = get_sum(numbers)
    print(answer)
    return


# 정수들 입력
def input_numbers():
    return list(map(int, input().split()))


# 정수들의 합을 구함
def get_sum(numbers):
    return sum(numbers)


main()

```

---

## Review
- 파이썬 사용법이 익숙치 않아서 약간 애를 먹고 있다.
- 확실히 입출력이 편하긴 하다.
- 코드의 간결성이라는 장점을 이용하기 위해 일부 손실이 있더라도 가독성을 우선시할 것이다.

---
