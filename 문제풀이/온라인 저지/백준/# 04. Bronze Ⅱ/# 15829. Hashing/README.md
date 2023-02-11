# 문제
- 플랫폼 : 백준
- 번호 : 15829
- 제목 : Hashing
- 난이도 : Bronze 2
- 문제에서 주어진 해시함수와 입력으로 주어진 문자열을 사용해 계산한 해시 값을 정수로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/15829" target="_blank">링크</a>

---

# 필요 알고리즘
- 문자열 처리

---

# 풀이
```python
input()
print(sum((ord(ch) - 96) * (31 ** i) for i, ch in enumerate(input())) % 1234567891)
```
- 'a'의 아스키 코드는 97이므로 1로 바꾸기 위해 96을 차감한다.
- 그 후 문제에서 주어진 대로 해시함수를 적용해 값을 반환하면 된다.
