import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {

    public int[] solution(int[] numbers, String direction) {
        Deque<Integer> deque = new LinkedList<>();

        for (int i=0; i< numbers.length; i++) {
            deque.addLast(numbers[i]);
        }

        switch (direction) {
            case "left" -> rotateLeft(deque);
            case "right" -> rotateRight(deque);
        }
        return deque.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private void rotateLeft(Deque<Integer> deque) {
        deque.addLast(deque.getFirst());
        deque.removeFirst();
    }

    private void rotateRight(Deque<Integer> deque) {
        deque.addFirst(deque.getLast());
        deque.removeLast();
    }
}
