public class Solution1 {

    public String[] solution(String my_str, int n) {
        int length = (my_str.length()%n != 0) ? my_str.length()/n +1 : my_str.length()/n;
        String[] results = new String[length];

        StringBuilder sb;

        for (int i=0; i<results.length; i++) {
            sb = new StringBuilder();
            for (int j=i*n; j<(i+1)*n; j ++) {
                if (j==my_str.length()) break;
                sb.append(my_str.charAt(j));
            }
            results[i] = sb.toString();
        }
        return results;
    }

}
