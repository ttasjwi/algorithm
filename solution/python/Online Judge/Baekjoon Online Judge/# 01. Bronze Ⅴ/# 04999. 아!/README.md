# BOJ 04999 : 아!
- 난이도 : Bronze 5
- 병원에 가야하는지 아닌지 판별
- 문제 : [링크](https://www.acmicpc.net/problem/4999)

---

## 풀이
```python
print('no' if len(input()) < len(input()) else 'go', end='')

```
- 첫번째 입력은 재환이 낼 수 있는 aah고, 둘째 입력은 의사가 듣기 원하는 aah다.
- 첫번째 입력의 길이가 의사가 듣기 원하는 aah의 길이보다 작으면, 갈 수 없고, 같거나 크면 갈 수 있다

---

