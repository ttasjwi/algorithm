# 문제
- 플랫폼 : 인프런 알고리즘 문제풀이 입문
- 번호 : 1.11
- 제목 : 문자열 압축
- 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로
문자열을 압축

---

# 필요 지식
- 문자열 처리
- 투 포인터

---

# 풀이
```python
word = input()
lt = 0
rt = 0
result = []
while rt < len(word) and word[lt] == word[rt]:
    count = 0
    while rt < len(word) and word[lt] == word[rt]:
        count += 1
        rt += 1
    result.append(word[lt])
    if count > 1:
        result.append(str(count))
    lt = rt
print(''.join(result), end='')
```
- lt, rt를 둔다.
- 반복한다.
  - 우선 현재 문자를 answer에 append 둔다.
  - lt의 문자와 rt의 문자가 같을 동안 rt를 전진시키고 카운트를 센다.
  - cnt가 1보다 크면, answer에 숫자를 append한다.
  - lt를 rt의 위치로 이동한다.
- 출력

---
