# 문제
- 플랫폼 : 백준
- 번호 : 10250
- 제목 : ACM 호텔
- 난이도 : Bronze 3
- N 번째 손님에게 배정되어야 하는 방 번호를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10250" target="_blank">링크</a>

---

# 필요 알고리즘
- 나머지 연산

---

# 풀이

```python
import io, os


def solution(line):
    h, w, n = map(int, line.split())
    div, mod = divmod(n - 1, h)
    return str((mod + 1) * 100 + (div + 1))


result = '\n'.join(
    solution(line) for line in io.BytesIO(os.read(0, os.fstat(0).st_size)).read().decode().rstrip().split(sep='\n')[1:])
print(result, end='')
```
- h, w, n 입력받기
- n에서 1을 뺀 값을 기준으로 h로 나눈 몫, 나머지 구하기
- 몫 + 1이 호수이고, 나머지 + 1이 층수이다.

---
