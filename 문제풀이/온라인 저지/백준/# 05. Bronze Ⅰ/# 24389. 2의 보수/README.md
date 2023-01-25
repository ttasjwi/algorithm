# 문제
- 플랫폼 : 백준
- 번호 : 24389
- 제목 : 2의 보수
- 난이도 : Bronze 1
- 2의 보수는 해당하는 숫자의 모든 비트를 반전시킨 뒤, 1을 더해 만들 수 있다.
이때, 32비트 기준으로 처음 표현했던 수와 그 2의 보수의 서로 다른 비트 수를 출력하기
- 문제 : <a href="https://www.acmicpc.net/problem/24389" target="_blank">링크</a>

---

# 필요 알고리즘
- 비트 마스킹
- 진리표(비트의 합)
  - 두 비트 a, b가 있을 때 비트의 합 연산은 다음과 같다. carry_out은 자리 올림이고, sum은 해당 자리에 남는 수이다. 
    - carry_out : a and b
    - sum : a xor b

---

# 풀이
```python
bits_a = [True if bit == '1' else False for bit in bin(int(input()))[2:].rjust(32, '0')]
bits_b = [not bit for bit in bits_a]

carry = True
for idx in range(len(bits_b) - 1, -1, -1):
    if not carry:
        break
    bits_b[idx], carry = bits_b[idx] != carry, bits_b[idx] and carry

answer = len([1 for bit_a, bit_b in zip(bits_a, bits_b) if bit_a != bit_b])
print(answer, end='')
```
- 숫자를 입력받아서, bin을 통해 이진 문자열로 변환한다.
  - 이렇게 되면 2의 경우 0b10이 되는데 32비트에 맞추도록 rjust를 통해 32자리로 맞춘다.
- 계산의 편의를 위해 각 자리를 True, False 의 불값으로 변환한다.
- 이렇게 만들어진 bits_a는 원래 숫자를 비트로 변환한 것들의 배열이다.
- bits_b는 비트를 뒤집고 여기에 1을 더한 수의 배열이여야한다.
  - not 연산을 통해 모든 비트를 뒤집는다.
  - 1을 더하는 작업은 반복문을 통해 수행한다.
  - 비트의 덧셈은 두 비트 a, b가 있을 때 자리올림은 `a and b`이고, 남는 비트는 `a xor b`임을 활용한다.

---
