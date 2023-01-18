import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int solution(int[][] dots) {
        boolean[][] checked = new boolean[4][4];
        for (int i = 0; i < checked.length; i++) {
            checked[i][i] = true;
        }

        Set<Double> gradients = new HashSet<>();
        boolean hasInfinity = false;

        double xDiff;
        double yDiff;
        double gradient;

        for (int i = 0; i < checked.length; i++) {
            for (int j = 0; j < checked[0].length; j++) {
                if (!checked[i][j]) {
                    checked[i][j] = checked[j][i] = true;

                    xDiff = dots[i][0] - dots[j][0];

                    if (xDiff == 0) {
                        if (hasInfinity) {
                            return 1;
                        }
                        hasInfinity = true;
                        continue;
                    }

                    yDiff = dots[i][1] - dots[j][1];
                    gradient = yDiff / xDiff;

                    if (gradients.contains(gradient)) {
                        return 1;
                    }
                    gradients.add(gradient);
                }
            }
        }
        return 0;
    }

}
