# 5.2 괄호 문자 제거

- 분류 : Stack
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 5.2)

---

## 풀이
```java
    private static String solution(String word) {
        Stack<Character> charStack = new Stack<>();

        for (char ch : word.toCharArray()) {
            if (ch == ')') {
                while(charStack.pop() != '('); // '(' 만날 때까지 계속 pop
            } else {
                charStack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : charStack) {
            sb.append(ch);
        }
        return sb.toString();
    }
```
- stack에 문자를 순서대로 쌓는다.(push)
- `)`을 만나면, `(`을 뽑을 때까지 계속 pop하여 stack을 비운다.
- 최종적으로 남은 문자를 for문으로 쭉 출력한다.

---
