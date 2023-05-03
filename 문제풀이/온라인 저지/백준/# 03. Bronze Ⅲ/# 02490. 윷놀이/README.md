# 문제
- 플랫폼 : 백준
- 번호 : 02490
- 제목 : 윷놀이
- 난이도 : Bronze 3
- 첫째 줄부터 셋째 줄까지 한 줄에 하나씩 결과를 도는 A, 개는 B, 걸은 C, 윷은 D, 모는 E로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2490" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
result_set = ['D', 'C', 'B', 'A', 'E']
for _ in range(3):
    score = sum(map(int, input().split()))
    print(result_set[score])
```
- 등의 갯수에 따라 점수가 달라지므로, 등의 갯수에 대응되는 등급을 배열에 순서대로 저장한다.
- 점수는 각 라인의 숫자를 합한 값과 같고, 그 결과를 기반으로 배열에서 등급을 꺼내 출력한다.

---

