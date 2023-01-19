class Solution1 {
    public int solution(String my_string) {
        int sum = 0;
        String[] numbers = my_string.replaceAll("\\s\\-\\s", " + -").split("\\s\\+\\s");

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
