# 문제
- 플랫폼 : 백준
- 번호 : 17388
- 제목 : 와글와글 숭고한
- 난이도 : Bronze 4
- 일처리가 잘 되면 OK, 잘 안 되고 있으면 가장 점수 낮은 대학 이름 출력
- 문제 : <a href="https://www.acmicpc.net/problem/17388" target="_blank">링크</a>

---

# 필요 지식
- 수학

---

# 풀이
```python
s, k, h = map(int, input().split())
min_value = min(s, k, h)

if s+k+h >= 100:
    print("OK")
else:
    if s == min_value:
        print("Soongsil")
    elif k == min_value:
        print("Korea")
    else:
        print("Hanyang")
```
- s, k, h를 하나씩 순서대로 입력받는다.
- 이들의 최솟값을 구한다.
- s, k, h의 합이 100 이상이면 OK를 출력
- 100 미만일 경우 최솟값에 해당하는 대학을 출력

---
