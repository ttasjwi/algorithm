public class Solution {

    private static final char SCISSORS = '2';
    private static final char ROCK = '0';
    private static final char PAPER = '5';

    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        for (char ch : rsp.toCharArray()) {
            switch (ch) {
                case SCISSORS -> sb.append(ROCK);
                case ROCK -> sb.append(PAPER);
                case PAPER -> sb.append(SCISSORS);
            }
        }
        return sb.toString();
    }
}
