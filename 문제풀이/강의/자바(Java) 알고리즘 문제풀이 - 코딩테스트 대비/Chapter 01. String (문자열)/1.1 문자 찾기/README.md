
# 1-1. 문자 찾기

- 분류 : 문자열(String)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 1-1 문제)

---

## 시간복잡도

- 문자열의 첫번째 자리부터 단어를 순차적으로 비교하므로 문자열의 길이를 N이라 할 때, O(N)

---

## 풀이
- 문자열과 문자의 대소문자가 맞으리란 보장이 없으므로 대소문자 통일
  - 문자열 : toUpperCase, toLowerCase
  - 문자 : Character.toUpperCase(ch), Character.toLowerCase(ch)
- 문자의 비교는 `==` 사용

---

## 삽질과정
```java
    private static boolean isSameAlphabet(char ch1, char ch2) {
        if (ch1 == ch2) {
            return true;
        } else if (ch1 > ch2 && (ch1-ch2 == 32)) {
            return true;
        } else if (ch1 < ch2 && (ch2-ch1 == 32)) {
            return true;
        } else {
            return false;
        }
    }
```
- 문자 통일시키는 방법이 당장 생각 안 나서 급한대로 아스키 코드 값을 비교해서 풀었다...

---
