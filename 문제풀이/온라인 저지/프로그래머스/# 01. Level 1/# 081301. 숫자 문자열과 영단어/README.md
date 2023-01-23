# 문제
- 플랫폼 : 프로그래머스
- 번호 : 081301
- 제목 : 숫자 문자열과 영단어
- 난이도 : Level 1
- 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어질 때
s가 의미하는 원래 숫자를 return 
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/81301" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
## 풀이1 : 투포인터
```python
def solution(s: str):
    results = []
    word_dict = {
        'zero': '0',
        'one': '1',
        'two': '2',
        'three': '3',
        'four': '4',
        'five': '5',
        'six': '6',
        'seven': '7',
        'eight': '8',
        'nine': '9'
    }

    lt, rt = 0, 0

    while lt <= rt and lt < len(s):
        current = s[lt:rt+1]

        if current.isnumeric():
            results.append(str(current))
            lt = rt+1
            rt = rt+1

        elif current in word_dict:
            results.append(word_dict[current])
            lt = rt+1
            rt = rt+1

        else:
            rt += 1

    return int(''.join(results))
```
- lt, rt 포인터를 두고 포인터를 전진시켜 가면서 문자가 같으면 변경 결과물을 배열에 담음

## 풀이2 : replace
```python
def solution(s: str):
    word_dict = {
        'zero': '0',
        'one': '1',
        'two': '2',
        'three': '3',
        'four': '4',
        'five': '5',
        'six': '6',
        'seven': '7',
        'eight': '8',
        'nine': '9'
    }

    answer = s

    for key, value in word_dict.items():
        answer = answer.replace(key, value)

    return int(answer)
```
- replace를 사용해서 순서대로 영단어를 숫자로 변경

---
