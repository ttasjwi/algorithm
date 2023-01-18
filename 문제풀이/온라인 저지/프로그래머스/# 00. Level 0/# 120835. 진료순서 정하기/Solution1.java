public class Solution1 {

    public int[] solution(int[] emergency) {
        int[] ranks = new int[emergency.length];

        for (int i=0; i<ranks.length; i++) {
            ranks[i] = getRank(emergency, i);
        }
        return ranks;
    }

    private static int getRank(int[] emergency, int index) {
        int rank = 1;
        for (int j = 0; j< emergency.length; j++) {
            if (emergency[index] < emergency[j]) {
                rank ++;
            }
        }
        return rank;
    }
}
