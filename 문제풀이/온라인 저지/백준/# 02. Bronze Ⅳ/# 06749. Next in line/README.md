# 문제
- 플랫폼 : 백준
- 번호 : 06749
- 제목 : Next in line
- 난이도 : Bronze 4
- 둘째와 막내의 나이 차이는 첫째와 둘째의 나이 차이와 동일하다. 막내, 둘째의 나이가 주어질 때 첫째의 나이를 출력 
- 문제 : <a href="https://www.acmicpc.net/problem/6749" target="_blank">링크</a>

---

# 필요 알고리즘
- 등차수열, 단순 산수

---

# 풀이
```python
a = int(input())
b = int(input())
answer = 2 * b - a
print(answer, end='')

```

---
