# 문제
- 번호 : 120894
- 제목 : 영어가 싫어요
- 난이도 : Level 0
- numbers를 정수로 바꿔 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120894)

---

# 필요 알고리즘
- 문자열 처리

---

# Python
```python
def solution(numbers: str):
    for num, english in enumerate(['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']):
        numbers = numbers.replace(english, str(num))

    return int(numbers)
```
- enumerate를 이용하여 배열의 요소의 인덱스와 값을 순서대로 접근할 수 있다.
- 순서대로 replace 함수를 통해 변경하고, 다시 숫자로 파싱하여 반환한다.

---

# Java
```java
class Solution {
    public long solution(String numbers) {
        String[] words = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < words.length; i++) {
            numbers = numbers.replaceAll(words[i], String.valueOf(i));
        }
        return Long.valueOf(numbers);
    }
}
```
- java에서도 비슷한 방식으로 가능하다.

---
