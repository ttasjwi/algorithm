public class Solution {

    int[] check = new int[200];
    // 0 : 아직 아무 것도 겹치지 않았다
    // 1 : 한번 체크됨
    // 2 : 중복됨, 중복이 계산 됨.

    public int solution(int[][] lines) {
        int start;
        int end;

        int duplicateLength = 0;

        for (int[] line : lines) {
            start = line[0] + 100;
            end = line[1] + 100;

            for (int i=start; i<end; i++) {
                if (check[i] == 0) {
                    check[i]++;
                } else if (check[i] == 1){
                    check[i]++;
                    duplicateLength ++;
                }
            }
        }
        return duplicateLength;
    }

}
