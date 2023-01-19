# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120905
- 제목 : n의 배수 고르기
- 난이도 : Level 0
- numlist에서 n의 배수가 아닌 수들을 제거한 배열을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120905)

---

# 필요 알고리즘
- Python : 리스트 관련 함수
- Java : 가변 배열 ArrayList 활용

---

# Python
```python
def solution(n, numlist):
    return list(filter(lambda x: x%n ==0, numlist))
```
- 필터링 -> 리스트화 -> 반환

---

# Java

## 풀이1 : ArrayList
```java
import java.util.ArrayList;

public class Solution1 {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int num : numlist) {
            if (num%n == 0) {
                numbers.add(num);
            }
        }
        int[] answer = new int[numbers.size()];

        for (int i=0; i<numbers.size(); i++) {
            answer[i]= numbers.get(i);
        }
        return answer;
    }
}
```
- 가변 배열 만들고, 배열 순서대로 탐색하면서 ArrayList에 삽입
- ArrayList의 size만큼의 배열을 만듬
- 순서대로 배열에 담아서 반환
- 스트림을 이용해서 풀이할 수도 있긴한데 속도가 쓸데 없이 길어지기도 하고 사용 안하기로.

## 풀이2 : Stream
```java
public class Solution2 {
    public int[] solution(int n, int[] numlist) {
        return Arrays.stream(numlist)
                .filter(num -> num%n == 0)
                .toArray();
    }
}
```
- 가독성은 좋은데, 속도가 엄청 느려짐

---
