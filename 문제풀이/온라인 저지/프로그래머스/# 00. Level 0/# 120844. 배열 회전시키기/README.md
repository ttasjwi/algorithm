# 문제
- 번호 : 120844
- 제목 : 배열 회전시키기
- 난이도 : Level 0
- direction 방향으로 한 칸씩 회전시킨 배열을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120844)

---

# 필요 알고리즘
- 배열의 요소 이동
- LinkedList

---

# 풀이1
```java
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
```
- 고정길이 배열의 요소를 순서대로 미는 방식
- 이 경우 배열의 요소를 모두 한 칸씩 움직여야하므로 시간 복잡도는 O(N)이 된다.

---

# 풀이2
```java
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
```
- Deque를 LinkedList로 사용
- 데이터를 복사하는 비용이 문제긴 하지만, 중간데이터 삭제에 있어서 이득이다.

---
