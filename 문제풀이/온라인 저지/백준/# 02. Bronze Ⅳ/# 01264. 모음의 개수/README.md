# 문제
- 플랫폼 : 백준
- 번호 : 01264
- 제목 : 모음의 개수
- 난이도 : Bronze 4
- 각 줄마다 모음의 개수를 세서 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1264" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
import io, os, sys

print = sys.stdout.write
find_chars = 'aeiouAEIOU'


def main():
    lines = io.BytesIO(os.read(0, os.fstat(0).st_size)).readlines()[:-1]
    answer = '\n'.join(str(calculate_count(line.decode())) for line in lines)
    print(answer)


def calculate_count(line):
    count = 0
    for ch in line:
        if ch in find_chars:
            count += 1
    return count


if __name__ == '__main__':
    main()
```

---
