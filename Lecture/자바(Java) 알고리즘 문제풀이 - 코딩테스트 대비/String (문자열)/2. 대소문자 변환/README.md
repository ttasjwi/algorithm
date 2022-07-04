
# 1-2. 대소문자 변환

- 분류 : 문자열(String)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 1-2 문제)

---

## 시간복잡도

- 문자열의 첫번째 자리부터 단어를 순차적으로 변환하므로 문자열의 길이를 N이라 할 때, O(N)

---

## 풀이
```java
    private static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                sb.append(Character.toLowerCase(ch));
            } else {
                sb.append(Character.toUpperCase(ch));
            }
        }
        return sb.toString();
    }
}
```
- 방법 1 : isLowerCase, isUpperCase 확인 후 분기처리(대 -> 소, 소 -> 대)
- 방법 2 : 아스키코드 값 활용
  - 대문자 : 65~90
  - 소문자 : 97~122

---
