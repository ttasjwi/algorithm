# Programmers 120821 : 배열 뒤집기
- 난이도 : Level 0
- num_list의 원소의 순서를 거꾸로 뒤집은 배열 구하기
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120821)

---

## 풀이1
```java
public class Solution1 {
    public int[] solution(int[] num_list) {
        int lt = 0;
        int rt = num_list.length -1;
        int tmp;
        while (lt < rt) {
            tmp = num_list[lt];
            num_list[lt] = num_list[rt];
            num_list[rt] = tmp;

            lt ++;
            rt --;
        }
        return num_list;
    }
}
```
- 배열의 양끝 인덱스를 lt, rt라 명명
- 순서대로 배열의 양끝의 값을 swap

---

## 풀이2
```java
    public int[] solution(int[] num_list) {
        var numbers = Arrays.stream(num_list)
                .boxed()
                .collect(Collectors.toList());

        Collections.reverse(numbers);

        return numbers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
```
- Stream 사용
- 배열을 리스트로 변환 후 뒤집기(Collections.reverse)
- 뒤집은 리스트를 다시 int 배열로 변환

---
