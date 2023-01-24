# 문제
- 플랫폼 : 백준
- 번호 : 10809
- 제목 : 알파벳 찾기
- 난이도 : Bronze 5
- 각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10809" target="_blank">링크</a>

---

# 필요 알고리즘
- 없음

---

# 풀이
## 풀이1
```python
results = ['-1'] * 26
word = input()

for i in range(len(word)):
    index = ord(word[i]) - 97

    if results[index] == '-1':
        results[index] = str(i)

answer = ' '.join(results)
print(answer, end='')
```
- 배열의 각 인덱스를 '-1'로 초기화
- 반복
  - index : 현재 인덱스의 아스키 코드 - 97 값
  - 해당 index에 위치한 값이 '-1'이면 현재 현재 인덱스로 갱신함
- 이렇게 모인 결과들을 join하여, 출력

## 풀이2
```python
s = input()
answer = ' '.join(str(s.find(chr(i))) for i in range(97, 123))
print(answer, end='')
```
- find 함수를 통해 인덱스를 반복해서 찾아 출력

---
