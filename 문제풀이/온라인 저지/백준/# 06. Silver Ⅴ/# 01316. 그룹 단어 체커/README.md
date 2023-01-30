# 문제
- 플랫폼 : 백준
- 번호 : 01316
- 제목 : 그룹 단어 체커
- 난이도 : Silver 5
- 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만 그룹단어라고 할 때, 주어진 단어들 중 그룹 단어의 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1316" target="_blank">링크</a>

---

# 필요 알고리즘
- 문자열 처리
- 정렬

---

# 풀이

## 풀이1 : 직접 따져보기
```python
import io, os, sys

print = sys.stdout.write

src = io.BytesIO(os.read(0, os.fstat(0).st_size))
lines = src.read().decode().rstrip().split(sep='\n')[1:]

answer = 0

for line in lines:
    chars = set()
    before = None
    is_group_word = True
    for ch in line:
        if before != ch:
            if ch in chars:
                is_group_word = False
                break
            chars.add(ch)
            before = ch
    if is_group_word:
        answer += 1

print(str(answer))
```
- 각 라인별로 단어를 하나하나 탐색하면서, 이전 것과 다른 문자는 set에 없다면 set에 추가한다.
  - 이전 것과 다른데 문자가 이미 set에 있다면 그룹 단어가 아니므로 바로 반복을 탈출한다.
- 끝까지 순회에 성공하면 answer를 증가한다.

## 풀이2 : 정렬 활용
```python
import io, os, sys

print = sys.stdout.write

src = io.BytesIO(os.read(0, os.fstat(0).st_size))
lines = src.read().decode().rstrip().split(sep='\n')[1:]

answer = sum(list(line) == sorted(line, key=line.find) for line in lines)
print(str(answer))
```
- 각 line별로, find함수 값을 기준으로 정렬한 상태가 line과 같으면 그룹단어이다.
  - 정렬 상태가 다르면 그룹단어가 아니다.

---
