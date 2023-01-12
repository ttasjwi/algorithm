import java.util.Stack;

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

    private static int calculatePositionIndex(int move) {
        return move - 1;
    }

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
}
