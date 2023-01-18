# BOJ 02475 : 검증수

- 난이도 : Bronze 5
- 제곱의 합을 10으로 나눈 나머지
- 문제 : [링크](https://www.acmicpc.net/problem/2475)

---  

## 풀이
```python
numbers = list(map(int, input().split()))
total = 0
for number in numbers:
    total += number ** 2
answer = total % 10
print(answer, end='')

```
- 숫자들을 입력받고, 반복문 돌려서 제곱합
- 10으로 나눈 나머지 반환
- 출력
