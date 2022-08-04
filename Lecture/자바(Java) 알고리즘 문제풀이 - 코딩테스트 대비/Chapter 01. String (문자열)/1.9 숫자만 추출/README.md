# 1.9 숫자만 추출

- 분류 : 문자열(String)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 1.9 문제)

---

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