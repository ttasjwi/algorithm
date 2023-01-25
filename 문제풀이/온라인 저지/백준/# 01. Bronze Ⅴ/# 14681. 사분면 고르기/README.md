# 문제
- 플랫폼 : 백준
- 번호 : 14681
- 제목 : 사분면 고르기
- 난이도 : Bronze 5
- 점의 좌표를 입력받아 그 점이 어느 사분면에 속하는지 출력
- 문제 : <a href="https://www.acmicpc.net/problem/14681" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
def main():
    x = int(input())
    y = int(input())
    answer = solution(x, y)
    print(answer, end='')


def solution(x, y):
    if y > 0:
        if x > 0:
            return '1'
        return '2'
    else:
        if x < 0:
            return '3'
        return '4'


if __name__ == '__main__':
    main()
```

---
