# 문제
- 플랫폼 : 백준
- 번호 : 02588
- 제목 : 곱셈
- 난이도 : Bronze 3
- 세로 곱셈의 중간단계, 결과를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2588" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
```python
a = int(input())
b = input()

answers = [int(n) * a for n in b[::-1]]
answers.append(a * int(b))
answers = '\n'.join(map(str, answers))
print(answers, end='')
```
- a는 숫자로 입력받고, b는 문자로 입력 받는다.
- b를 뒤집어서 순서대로 a와 곱하여 배열에 담는다.
- 최종적으로 a, b의 곱을 담는다.
- 문자열로 변환해 출력

---
