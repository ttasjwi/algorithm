# 문제
- 플랫폼 : 백준
- 번호 : 10950
- 제목 : A+B - 3
- 난이도 : Bronze 5
- 각 테스트 케이스마다 A+B를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10950" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import io, os, sys

inputs = io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines
print = sys.stdout.write


def main():
    answer = '\n'.join(str(get_sum(line)) for line in inputs()[1:])
    print(answer)


def get_sum(line: str):
    a, b = map(int, line.split())
    return a + b


if __name__ == '__main__':
    main()
```

---
