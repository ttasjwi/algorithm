public class Solution1 {

    public int[] solution(int[][] scores) {
        boolean[] checked = new boolean[scores.length];

        int[] sums = new int[scores.length];
        for (int i = 0; i < sums.length; i++) {
            sums[i] = (scores[i][0] + scores[i][1]);
        }

        int[] ranks = new int[scores.length];
        for (int i = 0; i < ranks.length; i++) {
            ranks[i] = 1;
        }

        int max;
        int sameCount;

        for (int i = 0; i < sums.length - 1; i++) {
            max = -1;
            sameCount = -1;

            for (int j = 0; j < sums.length; j++) {
                if (checked[j]) {
                    continue;
                }

                if (sums[j] > max) {
                    max = sums[j];
                    sameCount = 1;
                } else if (sums[j] == max) {
                    sameCount++;
                }
            }

            for (int j = 0; j < sums.length; j++) {
                if (checked[j]) {
                    continue;
                }

                if (sums[j] == max) {
                    checked[j] = true;
                } else {
                    ranks[j] += sameCount;
                }
            }
        }

        return ranks;
    }

}
