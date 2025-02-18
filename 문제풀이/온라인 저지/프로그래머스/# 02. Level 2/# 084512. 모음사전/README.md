# 문제
- 플랫폼 : 프로그래머스
- 번호 : 084512
- 제목 : 모음사전
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/84512" target="_blank">링크</a>

---

# 필요 지식
- DFS

---

# 풀이
```python

def solution(word):
    answer = 0
    find = False # 찾았나?
    chars = ['A', 'E', 'I', 'O', 'U']
    
    def dfs(idx, arr):
        nonlocal answer, find
        for i in range(5):
            if find:
                return
            answer += 1
            arr.append(chars[i])
            current_word = ''.join(arr)
            if word == current_word: # 만들어진 단어가 목표 단어와 같으면 찾았다는 플래그를 True
                find = True
                return
            if not find and idx + 1 <= 4: # 찾지 않았고, 다음 인덱스가 4 이하이면
                dfs(idx + 1, arr) # 다음 단어도 탐색
            arr.pop()
    dfs(0, []) # 0번 인덱스부터 시작
    return answer
```
- 처음 단어를 선택할 때, AEIOU 순으로 탐색한다.
- 근데 그 A에서 시작하여 다시 AEIOU 순으로 탐색한다. 그리고 다시 돌아와서 E부터 시작한다.
- 이 문제 해결 과정은 깊이우선탐색(DFS) 방식으로 해석할 수 있다.

---
