# 문제
- 플랫폼 : 백준
- 번호 : 02941
- 제목 : 크로아티아 알파벳
- 난이도 : Silver 5
- 입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2941" target="_blank">링크</a>

---

# 필요 알고리즘
- 문자열 처리

---

# 풀이
```python
word = input()
items = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
for item in items:
    word = word.replace(item, '#')
print(len(word))
```
- 크로아티아 알파벳들을 전부 영어 소문자가 아닌 임의의 문자로 변경후 문자열 길이를 반환하면 된다.

---
