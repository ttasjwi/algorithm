# 문제
- 플랫폼 : 백준
- 번호 : 01439
- 제목 : 뒤집기
- 난이도 : Silver 5
- 연속된 같은 값만 한 번에 뒤집을 수 있고 문자열 S에 있는 모든 숫자를 전부 같게 만들려 할 때, 뒤집는 행동의 최솟값 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/1439" target="_blank">링크</a>

---

# 필요 알고리즘
- 문자열 처리
- 그리디 알고리즘

---

# 풀이

## 풀이1
```python
word = input()

counts = {'0': 0, '1': 0}

for i in range(len(word)):
    if i + 1 == len(word) or word[i + 1] != word[i]:
        counts[word[i]] += 1

answer = min(counts.values())
print(answer, end='')
```
- 다음 문자와 현재 문자가 다르면 해당 문자의 카운트를 증가시킨다.
- 연속된 숫자의 갯수가 적은 쪽만큼 뒤집으면 최소한의 횟수로 뒤집을 수 있다.

## 풀이2
```python
c = input().count
print(max(c("01"), c("10")))
```
- 0에서 1로 뒤집힌 횟수, 1에서 0으로 뒤집힌 횟수를 각각 집계해서 큰 값을 출력한다.
- 결국 숫자가 급변한 횟수 중 큰 값만큼은 뒤집어야 숫자를 모두 같게 만들 수 있기 때문에 이 코드가 동작하는 것 같다.

---
