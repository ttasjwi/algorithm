# 문제
- 플랫폼 : 백준
- 번호 : 15000
- 제목 : CAPS
- 난이도 : Bronze 5
- 소문자 영단어 입력이 주어질 때, 이들을 모두 대문자로 바꿔서 출력
- 문제 : <a href="https://www.acmicpc.net/problem/15000" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리

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
