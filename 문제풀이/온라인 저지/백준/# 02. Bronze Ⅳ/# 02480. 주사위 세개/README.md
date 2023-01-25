# 문제
- 플랫폼 : 백준
- 번호 : 02480
- 제목 : 주사위 세개
- 난이도 : Bronze 4
- 3개 주사위의 나온 눈이 주어질 때, 상금을 계산
- 문제 : <a href="https://www.acmicpc.net/problem/2480" target="_blank">링크</a>

---

# 필요 알고리즘
- 정렬

---

# 풀이
```python
def main():
    a, b, c = sorted(map(int, input().split()))
    price = solution(a, b, c)
    print(price, end='')


def solution(a, b, c):
    if a == c:  # 세 눈이 모두 같다
        return 10000 + a * 1000
    elif a != b and b != c:  # 모두 다르다
        return c * 100
    else:  # 두 가지가 같을 때
        return 1000 + b * 100


if __name__ == '__main__':
    main()
```
- 크기 순으로 숫자를 정렬하면 편리하다.
  - a,c가 같다 : 모든 수가 같다
  - a,b,c : 모두 다른 경우
  - 그 외 : 두 수가 같은 경우

---
