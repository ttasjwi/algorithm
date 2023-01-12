# Programmers 120835 : 진료순서 정하기
- 난이도 : Level 0
- 정수 배열 emergency가 매개변수로 주어질 때 응급도가 높은 순서대로 진료 순서를 정한 배열을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120835)

---

## 풀이1
```java
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
```
- 순서대로 각 인덱스의 rank를 구하고 결과를 반환

---

## 풀이2
```java
public class Solution2 {

    public int[] solution(int[] emergency) {
        Map<Integer, Integer> rankMap = getRankMap(emergency);
        return getResult(emergency, rankMap);
    }

    private static Map<Integer, Integer> getRankMap(int[] emergency) {
        Map<Integer, Integer> ranks = new HashMap<>();

        int[] sortedEmergency = Arrays.copyOfRange(emergency, 0, emergency.length);
        Arrays.sort(sortedEmergency);

        for (int i=0; i<sortedEmergency.length; i++) {
            int e = sortedEmergency[i];
            ranks.put(e, sortedEmergency.length - i);
        }
        return ranks;
    }

    private static int[] getResult(int[] emergency, Map<Integer, Integer> rankMap) {
        int[] result = new int[emergency.length];
        for (int i=0; i<result.length; i++) {
            result[i] = rankMap.get(emergency[i]);
        }
        return result;
    }
}
```
- 배열을 통채로 복사하고 정렬
- 정렬한 결과를 기반으로 맵을 만든다.(key로 emergency를 하고, value로 등수를 놓음)
- result 배열을 만들어, emergency를 key로 하여 value로 바로 접근해 결과를 가져옴 (시간 복잡도 : O(1))

## 풀이3
```java
public class Solution3 {

    public int[] solution(int[] emergency) {
        List<Integer> sortedEmergency = Arrays
                .stream(emergency)
                .mapToObj(Integer::valueOf)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        return Arrays.stream(emergency)
                .map(e -> sortedEmergency.indexOf(e) + 1)
                .toArray();
    }
}
```
- 정렬된 리스트를 만든다.
- indexOf 메서드를 통해 등수를 구하고, 등수 배열을 만들어 반환한다.

---
