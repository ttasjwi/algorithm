class Solution {
    public long solution(String numbers) {
        String[] words = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < words.length; i++) {
            numbers = numbers.replaceAll(words[i], String.valueOf(i));
        }
        return Long.valueOf(numbers);
    }
}
