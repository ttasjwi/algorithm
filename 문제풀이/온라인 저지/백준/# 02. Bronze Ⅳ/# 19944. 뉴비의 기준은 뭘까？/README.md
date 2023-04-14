# 문제
- 플랫폼 : 백준
- 번호 : 19944
- 제목 : 뉴비의 기준은 뭘까?
- 난이도 : Bronze 4
- M학년이 뉴비라면 NEWBIE!를, 올드비라면 OLDBIE!를 TLE이라면 TLE!을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/19944" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
n, m = map(int, input().split())
print('NEWBIE!' if m == 1 or m == 2 else 'OLDBIE!' if m <= n else 'TLE!')
```
- m이 1 또는 2이면, 'NEWBIE!'
- 그것도 아니고 n보다 작거나 같으면 'OLDBIE!'
- 그 외엔 모두 'TLE!'

---
