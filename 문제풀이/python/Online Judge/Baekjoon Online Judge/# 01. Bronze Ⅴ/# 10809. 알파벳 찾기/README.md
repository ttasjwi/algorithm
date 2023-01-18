# BOJ 10809 : 알파벳 찾기
- 난이도 : Bronze 5
- 문자열에서 알파벳 찾아서 위치 출력
- 문제 : [링크](https://www.acmicpc.net/problem/10809)

---

## 풀이
```python
word = input()
answer = [word.find(chr(i)) for i in range(97, 123)]
print(*answer, sep=' ', end='')

```
- 소문자의 아스키 코드는 97 ~ 122
- `chr(숫자)` : 해당 아스키 코드의 문자 
- `find(문자)` : 해당 문자의 인덱스 (없으면 -1)
  - (참고) `index(문자)` : 해당 문자의 인덱스 (없으면 에러)

---
