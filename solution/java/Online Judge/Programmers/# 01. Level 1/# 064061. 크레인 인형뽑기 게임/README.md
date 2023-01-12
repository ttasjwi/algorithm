# Programmers 064061 : 크레인 인형뽑기 게임

- 난이도 : Level 1
- 크레인 인형뽑기 기계
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/64061)

---

## 풀이

### 전체 로직
```java

public class Solution {

    private static int answer = 0;
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int position;
        int doll;

        for (int move : moves) {
            position = calculatePositionIndex(move);
            doll = extractDoll(board, position);
            putDoll(stack, doll);
        }
        return answer;
    }
}
```
- 인형을 담는 바구니를 Stack으로 한다.
- moves 배열을 순차대로 읽고, 지시대로 인형을 뽑아서 Stack에 놓는다.
- 계산의 편의를 위해 answer를 클래스 변수로 삼고 이를 사용해서 쓰도록 했다.

### calculatePositionIndex
```java

    private static int calculatePositionIndex(int move) {
        return move - 1;
    }
```
- board의 각 위치에 접근할 때는 인덱스로 접근하는데 move 값은 1,2,3,4,... 의 값을 가지므로 인덱스보다 1 크다.
- 이 차이가 매우 불편하므로 인덱스로 변환한다.

### extractDoll
```java
    private static int extractDoll(int[][] board, int position) {
        int current = 0;
        for (int i=0; i<board.length; i++) {
            current = board[i][position];
            if (current > 0) {
                board[i][position] = 0;
                return current;
            }
        }
        return current;
    }
```
- 지정 위치의 인형을 추출한다.
- 인형을 찾아내면 그 값을 반환하고, 해당 위치의 인형을 지운다.(0으로 바꿈)
- 만약 인형이 없으면 0을 반환한다.

### putDoll
```java
    private void putDoll(Stack<Integer> stack, int doll) {
        if (doll == 0) {
            return;
        }
        if (!stack.isEmpty() && stack.peek() == doll) {
            stack.pop();
            answer += 2;
            return;
        }
        stack.push(doll);
    }
```
- 위에서 가져온 인형을 stack에 놓는다.
- 인형이 0이면 아무 것도 하지 않는다.
- stack 최상단에 같은 인형이 있으면 쌍으로 터뜨린다.
- 같은 인형이 없으면 그냥 push 한다.

---
