import java.util.stream.IntStream;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {

        int COUNT_OF_COMMANDS = commands.length;
        int[] answer = new int[COUNT_OF_COMMANDS];

        for (int i=0; i<COUNT_OF_COMMANDS; i++) {
            answer[i] = IntStream.of(array)
                    .limit(commands[i][1]) // 제한 : 끝 인덱스
                    .skip(commands[i][0]-1)
                    .sorted()
                    .toArray()[commands[i][2]-1];
        }
        return answer;
    }

}