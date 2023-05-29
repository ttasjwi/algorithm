# 문제
- 플랫폼 : 백준
- 번호 : 01544
- 제목 : 사이클 단어
- 난이도 : Silver 4
- 첫째 줄에 서로 다른 단어가 몇 개인지 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1544" target="_blank">링크</a>

---

# 필요 지식
- 문자열 슬라이싱
- 해시, 집합

---

# 풀이
```python
word_set = set()

n = int(input())

for _ in range(n):
    word = input()
    find = False
    for i in range(len(word)):
        tmp = word[i:] + word[0: i]
        if tmp in word_set:
            find = True
    if not find:
        word_set.add(word)
print(len(word_set))
```
- `word_set`: 단어의 SET
- 문자열을 입력받고, 문자열의 각 인덱스를 시작점으로 삼아 단어를 재구성한다. word_set에 현재 단어가 없으면 word_set에 단어를 추가한다.
- 최종적으로 word_set의 size를 반환한다.
---
