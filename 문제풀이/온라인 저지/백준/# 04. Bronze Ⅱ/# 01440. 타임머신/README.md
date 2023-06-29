# 문제
- 플랫폼 : 백준
- 번호 : 01440
- 제목 : 타임머신
- 난이도 : Bronze 2
- 첫째 줄에 시간을 읽을 수 있는 가능한 방법의 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1440" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```python
a, b, c = map(int, input().split(sep=':'))
combinations = [(a, b, c), (a, c, b), (b, a, c), (b, c, a), (c, a, b), (c, b, a)]

count = 0
for h, m, s in combinations:
    if 0 < h <= 12 and 0 <= m < 60 and 0 <= s < 60:
        count += 1
print(count)
```
- DD:DD:DD 꼴로 주어진 값을 읽는 방법은 최대 6개이다.
- 6개의 가지수는 충분히 수동으로 작성할 수 있으므로 배열로 조합으로 만들었다. (그 이상 가짓수는 combinations 를 사용하면 좋을 듯 하다.)
- 각 요소를 튜플로 읽어와서, h,m,s 로 변수를 나눠 읽고 각각이 주어진 조건에 부합하면 count를 1씩 증가시킨다.
- 최종적으로 count를 출력하면 된다.

---
