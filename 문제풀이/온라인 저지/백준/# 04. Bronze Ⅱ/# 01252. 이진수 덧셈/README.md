# 문제
- 플랫폼 : 백준
- 번호 : 01252
- 제목 : 이진수 덧셈
- 난이도 : Bronze 2
- 첫째 줄에 이진수 덧셈 결과를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1252" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
print(bin(sum(map(lambda x: int(x, 2), input().split())))[2:])
```
- 입력값을 2진법 숫자로 간주해서, 그들의 합을 구한뒤 다시 이진수로 변환한다.
- 파이썬의 bin 함수로 얻어낸 문자열을 앞의 0b를 잘라내서 출력한다.

---


