# 문제
- 플랫폼 : 백준
- 번호 : 04101
- 제목 : 크냐?
- 난이도 : Bronze 5
- 각 테스트 케이스마다, 첫 번째 수가 두 번째 수보다 크면 Yes를, 아니면 No를 한 줄에 하나씩 출력
- 문제 : <a href="https://www.acmicpc.net/problem/4101" target="_blank">링크</a>

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
    answer = '\n'.join(get_result(line) for line in inputs()[:-1])
    print(answer)


def get_result(line: str):
    a, b = map(int, line.split())
    return 'Yes' if a > b else 'No'


if __name__ == '__main__':
    main()
```
- 입력의 마지막 라인까지 읽어들이고, 라인별로 비교결과를 리스트에 누적한다.
- 누적 결과를 `'\n'`으로 조인하여 출력

---
