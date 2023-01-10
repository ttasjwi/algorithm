import java.util.Stack;

public class Solution1 {

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

}
