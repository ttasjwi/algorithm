# 문제
- 플랫폼 : 인프런 알고리즘 문제풀이 입문
- 번호 : 1.8
- 제목 : 유효한 팰린드롬
- 알파벳(대소문자 구분 안 함)만 따졌을 때 주어진 문자열이 팰린드롬인지 확인

---

# 필요 지식
- 문자열 처리
- 정규 표현식

---

# 풀이

## Python
```python
import re

s = re.sub(r'[^a-z]', '', input().lower())
answer = 'YES' if s == s[::-1] else 'NO'

print(answer, end='')
```
- `re.sub` : 정규표현식을 통해 문자열 변환
- 문자열 슬라이싱 활용

## Java
```java
    private static String solution(String word) {
        word = word.toLowerCase().replaceAll("[^a-z]", "");
        String reverse = new StringBuilder(word).reverse().toString();
        return (word.equals(reverse)) ? "YES" : "NO";
    }
```
- replaceAll : 정규표현식에 매칭되는 문자를 다른 문자로 대체
  - 정규표현식 `[a-z]` : 모든 소문자 a~z
  - 정규표현식 `[^a-z]` : 소문자 a~z가 아닌 모든 문자

---
