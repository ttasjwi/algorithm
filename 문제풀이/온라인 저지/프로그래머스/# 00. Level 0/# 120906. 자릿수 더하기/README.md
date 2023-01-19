# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120906
- 제목 : 자릿수 더하기
- 난이도 : Level 0
- numlist에서 n의 배수가 아닌 수들을 제거한 배열을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120906)

---

# 필요 알고리즘
- Java : 나머지 연산, 문자열 처리
- Python : 문자열, 리스트 관련 여러가지 함수 활용(파이썬다운 풀이)

---

# Java

## 풀이1 : 나머지 연산
```java
public class Solution1 {

    public int solution(int n) {
        int answer = 0;
        while (n>0) {
            answer += n%10;
            n = n/10;
        }
        return answer;
    }
}
```

## 풀이2 : 문자열로 변환
```java
public class Solution2 {

    public int solution(int n) {
        int answer = 0;
        for (int ch : String.valueOf(n).toCharArray()) {
            answer += ch - 48;
        }
        return answer;
    }
}
```

---

## Python
```python
def solution(n):
    return sum(map(int, list(str(n))))
```
- n을 문자열로 변환(str)
- 문자열을 그대로 리스트화 (list)
- map 함수로 각 요소를 숫자(int 함수 사용)로 변환(map)
- 합산(sum)

---
