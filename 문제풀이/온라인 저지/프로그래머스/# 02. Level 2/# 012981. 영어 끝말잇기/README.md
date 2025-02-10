# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012981
- 제목 : 영어 끝말잇기
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12981" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```python
def solution(n, words):
    # 사용된 단어들을 set 에 기록
    word_set = set()
    word_set.add(words[0])
    turn = 1 # 현재 몇 번째 주기인지
    cur = 1 # 현재 가리키고 있는 사람의 인덱스 (0, 1, 2, ...) => 몇 번째인지는 1을 더해주면 됨
    for i in range(1, len(words)):
        
        # set 에 단어가 없거나, 이전 단어의 마지막 문자와 현재 문자의 첫 문자가 다르면
        if words[i] in word_set or words[i-1][-1] != words[i][0]:
            # 사람의 번호와 현재 주기를 반환
            return [cur + 1, turn]
        
        # 사용됐던 단어를 set 에 추가
        word_set.add(words[i])
        
        # 가리키는 사람에 대한 인덱스 증가
        cur += 1
        
        # 사람을 가리키는 인덱스가 n 이 되면
        if cur == n:
            turn += 1 # 주기 증가
            cur %= n # n 으로 나눈 나머지 인덱스로 다시 돌아감
    return [0, 0]
```
