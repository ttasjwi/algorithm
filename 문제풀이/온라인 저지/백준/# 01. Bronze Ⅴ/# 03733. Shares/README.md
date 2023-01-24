# 문제
- 플랫폼 : 백준
- 번호 : 03733
- 제목 : Shares
- 난이도 : Bronze 5
- 주를 여러명이 균등하게 나눴을 때 각 사람이 받을 수 있는 최대 배당주
- 문제 : <a href="https://www.acmicpc.net/problem/3733" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import io, os, sys

inputs = io.BytesIO(os.read(0, os.fstat(0).st_size))
print = sys.stdout.write


def main():
    answer = '\n'.join(str(get_share(line)) for line in inputs)
    print(answer)


def get_share(line: str):
    s, n = map(int, line.split())
    return n // (s + 1)


if __name__ == '__main__':
    main()
```
- n명의 사람과, 수석심판이 S개 지분을 균등하게 나누어 가지는 상황이다.
- s를 n+1로 나눈 몫이 각 상황별 인원당 취득 주식수이며 이를 리스트로 모으면 된다.
- 모은 결과를 join해서 출력

---
