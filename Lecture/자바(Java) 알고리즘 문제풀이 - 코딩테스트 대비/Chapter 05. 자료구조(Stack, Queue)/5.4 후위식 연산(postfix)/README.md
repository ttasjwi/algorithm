# 5.4 후위식 연산(postfix)

- 분류 : Stack
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 5.4)

---

## 풀이
```java
    private static int solution(String line) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : line.toCharArray()) {
            if (Character.isDigit(ch)) {
            // if ('0' <= ch && ch <= '9') {
                stack.push(ch-48);
                continue;
            }
            int b = stack.pop();
            int a = stack.pop();
            
            if (ch == '+') stack.push(a+b);
            else if (ch == '-') stack.push(a-b);
            else if (ch == '*') stack.push(a*b);
            else if (ch == '/') stack.push(a/b);
        }
        return stack.pop();
    }
```
- 문자를 읽고 숫자이면 stack 에 push
- 문자를 읽고 연산자면
  - 값 두개를 꺼낸다. (이때 순서에 주의해야한다. 나중에 꺼낸걸 a,  처음 꺼낸결 b로 둔다.)
  - 연산자의 정의에 따라 연산한다.
  - 연산한 결과를 stack에 push 한다.
- 최종적으로 stack에 남은 값이 연산 결과다.(`pop`)

---
