# 문제
- 플랫폼 : 인프런 알고리즘 문제풀이 입문
- 번호 : 1.12
- 제목 : 암호
- 문자열을 7자씩 끊어서, 2진수로 변환 후, 다시 10진수화 한다. 그리고 이를 아스키 번호에 따라 문자로 다시 바꾼다. 이런식으로, 주어진 암호를
문자열로 변환하여 출력하기.

---

# 필요 지식
- 문자열 처리
- 투 포인터

---

# 풀이
```python
def change_to_bit(s):
    result = []
    for char in s:
        if char == '#':
            result.append('1')
        else:
            result.append('0')
    return ''.join(result)

def convert_bin_number_str_to_digit_number(bin_number_str):
    return chr(int(bin_number_str, 2))

n = int(input())
word = change_to_bit(input())
answer = []
for i in range(n):
    lt = i * 7
    rt = (i+1) * 7
    ch = convert_bin_number_str_to_digit_number(word[lt:rt])
    answer.append(ch)
print(''.join(answer), end='')
```
- '#'을 '1'로, '*'를 '0'으로 변환
- 7자씩 쪼개서, 7자 문자열을 2진수 문자열로 취급하여 10진수 숫자로 변환하고, 이를 다시 아스키 코드값에 따라 문자열로 변환한다.
- 출력

---
