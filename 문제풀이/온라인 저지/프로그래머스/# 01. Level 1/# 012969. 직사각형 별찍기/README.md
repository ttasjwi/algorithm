# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012969
- 제목 : 직사각형 별찍기
- 난이도 : Level 1
- 별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12969" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
a, b = map(int, input().strip().split(' '))
print('\n'.join(['*' * a] * b), end='')
```

---
