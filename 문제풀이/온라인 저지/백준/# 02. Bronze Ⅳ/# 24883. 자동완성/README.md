# 문제
- 플랫폼 : 백준
- 번호 : 24883
- 제목 : 자동완성
- 난이도 : Bronze 4
- 주어진 알파벳이 N 또는 n 이면 "Naver D2", 아니라면 "Naver Whale"을 따옴표를 제외하고 출력
- 문제 : <a href="https://www.acmicpc.net/problem/24883" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
print('Naver D2' if input() in ['N', 'n'] else 'Naver Whale')
```
- `in` 키워드를 통해 주어진 배열에 요소가 있는 지를 확인하게 했다.

---
