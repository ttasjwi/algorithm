# \[BOJ 10799\] 쇠막대기

- 난이도 : Silver 3
- 구현 / Stack
- 문제 : <a href="https://www.acmicpc.net/problem/10799" target="_blank"> [링크]</a>

---  

## 풀이 1: 내 풀이(반복)
### 입출력
```java
    public static void main(String[] args) throws IOException {
        int answer = getCount();
        System.out.print(answer);
    }
```
- getCount에서 입력과 로직을 모두 수행한다.
- 결과를 출력한다.

### 로직
```java
    private static int getCount() throws IOException {
        int count = 0;
        int stick = 0;
        int before = 0;
        int input;

        while ((input = System.in.read()) != '\n') {
            if (input == '(') { // 기본적으로 '('은 stick으로 본다.
                stick++;
            } else {
                stick --; // '('이 아니면 일단 stack의 요소를 하나 뽑는다.
                if (before == '(') { // 이전 문자가 '('이면 레이저
                    count += stick; // stick의 갯수만큼 count를 증가
                } else {
                    count ++; // stick이 끝난 것이므로 count +1
                }
            }
            before = input; // 이전 문자를 input으로 한다.
        }
        return count;
    }
```
- 변수
    - `input` : 입력받은 문자를 저장한다.
    - `before` : 직전에 입력받은 문자를 기록한다.
    - `count` : 잘려진 막대의 갯수를 기록한다.
    - `stick` : '현재'까지 식별된 잘려질 stick의 갯수이다.
- 입력이 개행문자 또는 공백이면, 줄이 끝난 것으로 보고 count를 반환한다.
- 입력 문자가 `(` 이면, stick이 하나 추가된 것으로 보고 stick을 증가시킨다.
- 입력 문자가 `)`일 때
    - 이전 문자가 `(` 일 경우 방금 `( )`은 막대가 아니라 레이저이다.
        - 레이저는 stick이 아니므로 stick의 갯수를 1 차감한다.
        - 잘릴 예정인 stick의 갯수만큼 count가 증가된다.
    - 이전 문자가 `(`이 아니면 stick이 하나 끝난 것이다.
        - stick의 갯수를 1 차감한다.
        - count를 1 증가 시킨다.
- before를 input 으로 하고 다음 입력을 읽는다.

---

## 풀이2 : Stack 활용
```java
    private static int solution(String line) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') stack.push(line.charAt(i));
            else {
                stack.pop();
                if (line.charAt(i - 1) == '(') count += stack.size();
                else count++;
            }
        }
        return count;
    }
```
- 문자를 읽었을 때 `(`이면 stack에 push한다.
- 문자를 읽었을 때 `)`이면
    - 일단 stack에서 최상단 요소를 pop한다.
    - 이전 문자가 `(`이면, 레이저이므로, 스택에 쌓인 `(`의 갯수만큼 count를 증가
    - 이전 문자가 `(`가 아니면, 막대이고 막대가 끝난 것이므로, count를 1 증가
- 최종적으로 count를 반환한다.

---
