public class Solution2 {

    public int solution(String my_string) {
        String[] words = my_string
                .replaceAll("[a-zA-Z]", " ")
                .split(" ");

        int sum = 0;

        for (String word : words) {
            if (!word.isEmpty()) {
                sum += Integer.parseInt(word);
            }
        }

        return sum;
    }

}
