# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120913
- 제목 : 잘라서 배열로 저장하기
- 난이도 : Level 0
- my_str을 길이 n씩 잘라서 저장한 배열을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120913)

---

# 필요 알고리즘
- 문자열 처리

---

# Python
```python
def solution(my_str: str, n: int):
    return [my_str[i:i + n] for i in range(0, len(my_str), n)]

```
- 문자열 슬라이싱, 리스트 컴프리헨션을 사용하면 한 줄로 가능하다.
- 파이썬의 문자열 슬라이싱은 인덱스를 벗어나더라도 마지막 길이에서 끊어준다.

---

# Java

## 풀이1
```java
public class Solution1 {

    public String[] solution(String my_str, int n) {
        int length = (my_str.length()%n != 0) ? my_str.length()/n +1 : my_str.length()/n;
        String[] results = new String[length];

        StringBuilder sb;

        for (int i=0; i<results.length; i++) {
            sb = new StringBuilder();
            for (int j=i*n; j<(i+1)*n; j ++) {
                if (j==my_str.length()) break;
                sb.append(my_str.charAt(j));
            }
            results[i] = sb.toString();
        }
        return results;
    }

}
```
- 결과물 배열의 길이를 할당받는다. 문자열 길이가 n으로 나누어 떨어지면 나눈 몫만큼 할당하고, 나머지가 있으면 몫+1 만큼 길이를 할당한다.
- 결과물 배열을 생성한다.
- n개 단위로 문자열을 만들어서, 결과물에 순서대로 저장한다.

## 풀이2
```java
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Solution2 {

    public String[] solution(String my_str, int n) {
        return IntStream.iterate(0, smallerThan(my_str), i -> i + n)
                .mapToObj(i -> getWord(my_str, n, i))
                .toArray(String[]::new);
    }

    private static IntPredicate smallerThan(String my_str) {
        return i -> i < my_str.length();
    }

    private static String getWord(String my_str, int n, int i) {
        int end = (i + n > my_str.length()) ? my_str.length() : i + n;
        return my_str.substring(i, end);
    }

}
```
- Stream을 사용하여 풀 수도 있다.
- 구조적으로 놓고보면 Python의 풀이와 유사하다.
- 하지만 여전히 Java API의 한계상 문자열을 subString으로 자르기 전에, 끝의 인덱스 범위를 확인하는
작업을 별도로 수행해야한다.

---
