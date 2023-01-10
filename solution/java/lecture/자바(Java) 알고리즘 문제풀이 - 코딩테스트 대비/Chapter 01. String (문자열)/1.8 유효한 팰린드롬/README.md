# 1.8 유효한 팰린드롬

- 분류 : 문자열(String)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 1.8 문제)

---

## 풀이 : 정규표현식 사용, replaceAll
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