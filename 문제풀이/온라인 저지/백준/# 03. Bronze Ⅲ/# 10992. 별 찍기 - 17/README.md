# 문제
- 플랫폼 : 백준
- 번호 : 10992
- 제목 : 별 찍기 - 17
- 난이도 : Bronze 3
- 예제를 보고 규칙을 유추한 뒤에 별을 찍기
- 문제 : <a href="https://www.acmicpc.net/problem/10992" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
def main():
    n = int(input())
    answer = '\n'.join(make_line(i, n) for i in range(1, n + 1))
    print(answer, end='')


def make_line(i, n):
    if i == 1:
        return ' ' * (n - 1) + '*'
    if i == n:
        return '*' * (2 * n - 1)
    else:
        return ' ' * (n - i) + '*' + ' ' * (2 * i - 3) + '*'


if __name__ == '__main__':
    main()
```

---
