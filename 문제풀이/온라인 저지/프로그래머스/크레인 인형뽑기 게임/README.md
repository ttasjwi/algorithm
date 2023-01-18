
---

# 크레인 인형뽑기 게임
2019 카카오 개발자 겨울 인턴십

https://programmers.co.kr/learn/courses/30/lessons/64061

---

## Solution1 - 내 풀이

```
    public int solution(int[][] board, int[] moves) {

        int answer = 0;

        Stack<Integer> dollStack = new Stack<>();

        for (int i=0; i<moves.length; i++) { // moves의 순서대로

            for (int j=0; j<board.length; j++) {
                Integer doll = board[j][moves[i]-1]; //
                if (doll > 0) { // 인형이 존재하면
                    board[j][moves[i]-1] = 0; // 인형을 뽑는다.

                    if (dollStack.isEmpty()) { // 인형박스가 비어있으면 push한다.
                        dollStack.push(doll);
                    } else { // 인형 스택이 안 비어있다면
                        if (dollStack.peek().equals(doll)) { // 인형박스에서 제일 위에 있는 요소를 확인하고 동등하면
                            dollStack.pop(); // 제거한다.
                            answer += 2; // 쌍으로 터짐.
                        } else {
                            dollStack.push(doll);
                        }
                    }
                    break; // 찾았고, 작업을 종료했으니 현재 반복을 탈출한다.
                }
            }

        }

        return answer;
    }
```
- moves 배열의 순서대로 지정 열을 탐색
- board의 모든 행마다 지정 열에 인형이 존재하는지 탐색하고, 존재하면
  - 인형을 뽑고 doll에 저장한다. 뽑고나면 board의 지정 인덱스에 0을 저장한다.
    - stack에서 doll이 비어있으면 push함.
    - 비어있지 않으면 stack의 제일 마지막에 위치한 요소와 비교하여
      - 같으면 pop한뒤 answer 2 증가
      - 같지 않으면 stack에 push
    - 반복 탈출

---