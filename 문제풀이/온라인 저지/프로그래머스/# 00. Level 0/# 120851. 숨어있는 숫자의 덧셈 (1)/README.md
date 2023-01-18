# 문제
- 번호 : 120851
- 제목 : 숨어있는 숫자의 덧셈 (1)
- 난이도 : Level 0
- my_string안의 모든 자연수들의 합을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120851)

---

# 필요 알고리즘
- ASCII에서 숫자 범위

---

# 풀이1
```java
    public int solution(String my_string) {
        int sum = 0;
        for (char ch : my_string.toCharArray()) {
            if (48 <= ch && ch < 58) {
                sum += ch-48;
            }
        }
        return sum;
    }
```
- 문자열을 순서대로 체크하면서 숫자이면 합산

# 풀이2
```java
    public int solution(String my_string) {
        return my_string.chars()
                .filter(ch -> 48 <= ch && ch < 58)
                .map(ch -> ch - 48)
                .sum();
    }
```
- 스트림 사용

---
