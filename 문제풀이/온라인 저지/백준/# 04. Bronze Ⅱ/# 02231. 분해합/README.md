# 문제
- 플랫폼 : 백준
- 번호 : 02231
- 제목 : 분해합
- 난이도 : Bronze 2
- N과 N을 이루는 각 자리수의 합을 분해합이라 할 때, 어떤 자연수 M의 분해합이 N인 경우 N을 M의 생성자라고 한다. 입력된 값의 최소의 생성자를
찾으시오. (생성자가 없을 수 있는데 이 경우 0을 반환하게 하라.)
- 문제 : <a href="https://www.acmicpc.net/problem/2231" target="_blank">링크</a>

---

## 필요 지식
- 브루트 포스

---

## 풀이

### 1. 무작정 전부 따지기
- 1부터 모든 숫자를 다 따져가면서, n의 생성자를 찾아내는 방법이다.

### 2. 범위 줄이기
예를 들어, 4자리 자연수가 있고, 이 수의 생성자를 k라 할 때  
n = k + k1 + k2 + k3 + k4라 하자. 이 때 `1 <= k1 + k2 + k3 + k4 <= 36`이 된다.  
k = n - (k1 + k2 + k3 + k4)이고, n- 36 <= k <= n-1  
이렇게 k의 후보 범위를 대폭 줄일 수 있다.

---

## 코드

### 풀이1 : 전부 따지기
```python
num = int(input())

answer = 0

if num < 10:
    answer = num
else:
    for n in range(1, num + 1):
        s = 0
        tmp = n
        while tmp > 0:
            s += tmp % 10
            tmp //= 10
        if num - s == n:
            answer = n
            break
print(answer)
```
- 그냥 무작정 1부터 num까지 쭉 따진다.

## 풀이2: 조회 범위 조정
```kotlin
fun main() {
    val n = readInt()
    // n = k + k1 + k2 + ... k4 + ...
    // 1<= k1 + k2 +... <= length * 9
    // n-length *9 <= k <= n-1
    for (k in n- 9 * n.toString().length until n) {
        if (k + sum(k) == n) {
            print(k)
            return
        }
    }
    print(0)
}

private fun sum(n: Int): Int {
    var sum = 0
    for (ch in n.toString()) {
        sum += ch.code - 48
    }
    return sum
}


private fun readInt(): Int {
    var value = 0
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return value // 공백이나 개행자
            else -> value = value * 10 + (input - 48)
        }
    }
}
```

---
