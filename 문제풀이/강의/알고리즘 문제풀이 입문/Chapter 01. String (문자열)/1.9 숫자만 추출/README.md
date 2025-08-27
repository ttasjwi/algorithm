# 문제
- 플랫폼 : 인프런 알고리즘 문제풀이 입문
- 번호 : 1.9
- 제목 : 숫자만 추출
- 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수 만들기

---

# 필요 지식
- 문자열 처리
- 정규 표현식

---

# Python
## 풀이1 : 정규 표현식 사용
```python
import re

answer = int(re.sub(r'[^0-9]', '', input()))
print(answer, end='')
```

## 풀이2 : 리스트 컴프리헨션 사용
```python
arr = [ch for ch in input() if ch.isnumeric()]
answer = int(''.join(arr))
print(answer, end='')
```

# Java
## 풀이1 : Character.isDigit, Integer.parseInt 활용
```java
    private static int solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (Character.isDigit(ch)) {
                sb.append(ch);
            }
        }
        return Integer.parseInt(sb.toString());
    }
```
- isDigit : 숫자인지 여부 반환
- Integer.parseInt : 문자열을 숫자로 파싱

---

## 풀이2: 아스키 코드 활용
```java
    private static int solution(String word) {
        int value = 0;
        for (int ch : word.toCharArray()) {
            if (48 <= ch && ch <= 57) {
                value = value * 10 + (ch - 48);
            }
        }
        return value;
    }
```
- 숫자의 아스키 코드는 48 ~ 57
- value에 `value * 10 + (ch -48)`을 갱신

---
