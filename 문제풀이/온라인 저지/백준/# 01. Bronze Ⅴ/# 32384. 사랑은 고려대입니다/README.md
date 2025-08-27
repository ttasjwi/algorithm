# 문제
- 플랫폼 : 백준
- 번호 : 32384
- 제목 : 사랑은 고려대입니다
- 난이도 : Bronze 5
- 문제 : <a href="https://www.acmicpc.net/problem/32384" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
n = int(input())
arr = ["LoveisKoreaUniversity"] * n
print(*arr, end = '')
```
- 반복 출력을 하는 것인데 리스트 반복 연산자를 사용하면 편할 것 같아서, 리스트 반복 연산자를 사용함.
