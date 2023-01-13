public class Solution1 {

    public int[] solution(int[] numbers, String direction) {
        switch (direction) {
            case "left" -> rotateLeft(numbers);
            case "right" -> rotateRight(numbers);
        }
        return numbers;
    }

    private void rotateLeft(int[] numbers) {
        int tmp = numbers[0];
        for (int i=1; i<numbers.length; i++) {
            numbers[i-1] = numbers[i];
        }
        numbers[numbers.length-1] = tmp;
    }

    private void rotateRight(int[] numbers) {
        int tmp = numbers[numbers.length -1];
        for (int i=numbers.length-1; i>=1; i--) {
            numbers[i] = numbers[i-1];
        }
        numbers[0] = tmp;
    }
}
