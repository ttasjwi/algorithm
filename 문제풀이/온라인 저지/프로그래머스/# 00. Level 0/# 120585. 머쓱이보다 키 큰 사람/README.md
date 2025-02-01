# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120585
- 제목 : 머쓱이보다 키 큰 사람
- 난이도 : Level 0
- 배열의 평균값
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120585" target="_blank">링크</a>

---

# 필요 지식
- 시간복잡도

---

# 풀이
```python
def solution(array, height):
    return sum(1 for item in array if item > height)
```
- 배열을 전부 순회하면서 키가 큰 값들을 찾아 갯수를 구하는 방식이다.
- 다른 방법으로는 정렬 후 키가 처음으로 커지는 지점을 찾아서 그 후의 원소의 갯수를 구하는 방법을 고려할 수 있다. 
이 방식은 정렬을 해야하므로 시간복잡도가 `O(NlogN)` 이 되는데, 배열을 전부 순회하는 경우의 시간복잡도는 `O(N)` 보다 비용이 크므로
배열을 전부 순회하는 방식을 사용하기로 했다.
  
---
