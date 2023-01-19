# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120897
- 제목 : 약수 구하기
- 난이도 : Level 0
- n의 약수를 오름차순으로 담은 배열을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120897)

---

# 필요 알고리즘
- Python : Counter, 리스트 컴프리헨션, 정렬
- Java : 연결 리스트, 체크배열

---

# Python
```python
from collections import Counter


def solution(s):
    return ''.join(sorted([key for key, value in Counter(s).items() if value == 1]))
```
- Counter 객체는 아이템에 대한 빈도수를 계산해 딕셔너리로 반환한다.
- 딕셔너리의 `.items()` 함수를 사용하여, `dic_items()`를 얻어올 수 있다.
- 리스트 컴프리헨션을 통해 value가 1인 것들만 필터링하고, key를 요소로 한 리스트를 얻어온다.
- 이를 정렬하고 `''`으로 join하여 문자열로 반환한다.


---

# Java
## 풀이1 : LinkedList 사용
```java
import java.util.LinkedList;

public class Solution1 {
    public int[] solution(int n) {
        LinkedList<Integer> numbers = new LinkedList<>();

        int idx = 0;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                numbers.add(idx, i);
                if (n / i != i) {
                    numbers.add(idx + 1, n / i);
                }
                idx++;
            }
        }
        int[] answer = new int[numbers.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = numbers.pop();
        }
        return answer;
    }
}
```
- 제곱근까지 순회하면서 약수쌍을 찾는다.
- LinkedList를 생성하고, 약수쌍을 대칭된 위치에 삽입한다.
  - LinkedList는 중간 삽입에 유리한 구조이므로 LinkedList를 사용했다.
- LinkedList의 요소들을 순서대로 pop해가면서(매순간 O(1)로 접근), answer에 순서대로 저장하고 반환한다.
- 제곱근까지만 순회하면 된다. 따라서 시간 복잡도는 O(sqrt(N))이다.


## 풀이2 : 체크배열 사용
```java
public class Solution2 {
    public int[] solution(int n) {
        boolean[] checked = new boolean[n+1];

        int length = 0;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                checked[i] = true;
                length ++;
                if (n / i != i) {
                    checked[i] = true;
                    length ++;
                }
            }
        }

        int[] answer = new int[length];

        int index = 0;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (checked[i]) {
                answer[index] = i;
                if (n/i != i) {
                    answer[length-1-index] = n/i;
                }
                index ++;
            }
        }
        return answer;
    }

}

```
- 체크배열을 이용해 약수인 위치들을 체크한다. 동시에 size를 계산한다.
- size 계산이 완료되면 정적 배열을 생성하여 체크된 약수들을 다시 삽입한다.
- 제곱근까지만 순회하면 된다. 따라서 시간 복잡도는 O(sqrt(N))이다.
- 이쪽은 기본형만을 갖고 작업을 수행하다보니 객체 생성 비용이 없고 제일 빠르다.

---
