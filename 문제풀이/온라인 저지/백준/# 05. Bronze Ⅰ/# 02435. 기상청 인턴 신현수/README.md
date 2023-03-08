# 문제
- 플랫폼 : 백준
- 번호 : 02435
- 제목 : 기상청 인턴 신현수
- 난이도 : Bronze 1
- 온도의 수열에서 연속적인 K일의 온도의 합이 최대가 되는 값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2435" target="_blank">링크</a>

---

# 필요 지식
- 슬라이딩 윈도우

---

# 풀이
```python
n, k = map(int, input().split())
temperatures = [0] + list(map(int, input().split()))

total = sum(temperatures[1:k + 1])
max = total

for i in range(k + 1, n+1):
    total = total - temperatures[i - k] + temperatures[i]
    if total > max:
        max = total
print(max)
```
- 슬라이딩 윈도우 방식으로 연속한 온도합을 변화시켜가고, 최댓값을 계산한다.

---

