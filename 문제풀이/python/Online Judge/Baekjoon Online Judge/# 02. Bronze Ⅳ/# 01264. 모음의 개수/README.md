# BOJ 01264 : 모음의 개수
- 난이도 : Bronze 4
- 문자열에서 모음의 갯수를 새서 반환하기
- 문제 : [링크](https://www.acmicpc.net/problem/1264)

---  

## 풀이
```python
import sys

input = lambda: sys.stdin.readline().rstrip()

find_char = 'aeiouAEIOU'
while True:
    word = input()
    if word == '#':
        break
    else:
        count = 0
        for char in word:
            if char in find_char:
                count += 1
        print(count)
```
- 기본적으로 무한 반복
- '#'을 찾으면 while문에서 break
- '#'이 아니면, 문자열의 문자 각각에 순서대로 접근하여, 모음 목록에 있는지 확인 후, 포함되면 카운팅
- 매 라인마다 출력
