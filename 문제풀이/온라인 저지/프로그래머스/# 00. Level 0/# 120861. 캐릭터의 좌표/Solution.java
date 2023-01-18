import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final Map<String, int[]> DIRECTIONS = new HashMap<>() {{
        put("up", new int[]{0, 1});
        put("down", new int[]{0, -1});
        put("left", new int[]{-1, 0});
        put("right", new int[]{1, 0});
    }};

    public int[] solution(String[] keyInputs, int[] board) {
        int xMax = board[0] / 2;
        int xMin = -xMax;
        int yMax = board[1] / 2;
        int yMin = -yMax;

        int[] answer = new int[2];

        for (String keyInput : keyInputs) {
            int[] direction = DIRECTIONS.get(keyInput);

            int nextX = answer[0] + direction[0];
            int nextY = answer[1] + direction[1];

            if (xMin <= nextX && nextX <= xMax && yMin <= nextY && nextY <= yMax) {
                answer[0] = nextX;
                answer[1] = nextY;
            }
        }
        return answer;
    }
}
