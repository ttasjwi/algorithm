# 5.1 올바른 괄호

- 분류 : Stack
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 5.1)

---

## 풀이
```java
    private static String solution(String word) {
        Stack<Character> charStack = new Stack<>();

        for (char ch : word.toCharArray()) {
            if (ch == '(') {
                charStack.push(ch);
            } else if (charStack.isEmpty()) {
                return "NO";
            } else {
                charStack.pop();
            }
        }
        return (charStack.isEmpty()) ? "YES" : "NO";
    }
```
- stack에 괄호를 쌓는다.
- 괄호를 한 자 한자 읽는다.
  - `(`을 만나면 stack에 쌓는다.
  - `)`을 만날 경우
    - 기존 stack이 비워있으면 잘못된 문자이므로 NO 반환
    - 기존 stack이 비워져 있지 않으면 stack에 있는 `(`을 꺼낸다.
- 최종적으로 stack이 비워있으면 괄호가 맞고, 비어있지 않으면 괄호가 안 맞음

---
