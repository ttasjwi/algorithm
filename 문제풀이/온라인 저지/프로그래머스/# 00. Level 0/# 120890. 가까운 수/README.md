# 문제
- 번호 : 120890
- 제목 : 가까운 수
- 난이도 : Level 0
- array에 들어있는 정수 중 n과 가장 가까운 수를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120890)

---

# 필요 알고리즘
- 최솟값 알고리즘
- 정렬 기준 구현
- 자바로도 풀 수 있긴한데, 코테 준비 관점에서는 코드의 간결성 면에서 이런 문제는 Python으로 빨리 푸는게 낫다.

---

# Python
```python
def solution(array, n):
    return min(array, key=lambda x: (abs(n-x), x-n))
```
- min 함수를 통해 다음 기준에 따른 최솟값을 구한다.
  - 첫번째 정렬 기준 : n과 x의 차의 최솟값
  - 두번째 정렬 기준 : x-n (차가 같을 경우 x-n 값이 작을 수록 더 작다)

---

# Java
## 풀이1 : Stream 사용
```java
import java.util.Arrays;
import java.util.Comparator;

public class Solution1 {

    public int solution(int[] array, int n) {
        return Arrays.stream(array)
                .mapToObj(Integer::valueOf)
                .min(Comparator.comparing(x-> Math.abs(n - (int) x)).thenComparing(x-> (int) x-n))
                .get();
    }
}
```
- 배열을 스트림으로 변환 후, 박싱한다.
- 이하의 정렬기준에 따라 최솟값을 구한다.
  - 첫번째 정렬 기준 : n과 x의 차의 최솟값
  - 두번째 정렬 기준 : x-n (차가 같을 경우 x-n 값이 작을 수록 더 작다)

## 풀이2 : 반복문을 통한 갱신
```java
public class Solution2 {

    public int solution(int[] array, int n) {

        int diff;
        int minDiff = Integer.MAX_VALUE;
        int answer = -1;

        for (int i : array) {
            diff = Math.abs(n - i);

            if (minDiff > diff) {
                minDiff = diff;
                answer = i;
            } else if (minDiff == diff) {
                if (answer > i) {
                    answer = i;
                }
            }
        }

        return answer;
    }
}
```
- diff : 차
- minDiff : 최소 차
- answer : 정답
- 배열을 순회하며 다음을 반복한다.
  - 최소차 갱신 : 더 작은 차가 발생하면, 해당 숫자로 answer를 갱신하고 최소차를 갱신한다.
  - 최소차와 같은 차가 등장했을 때 : 더 작은 숫자로 answer를 갱신한다.
- 마지막에 answer를 반환한다.
- java 기준 이 방식이 제일 빠르다.

---
