# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120902
- 제목 : 문자열 계산하기
- 난이도 : Level 0
- 문자열 my_string이 매개변수로 주어질 때, 수식을 계산한 값을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120902)

---

# 필요 알고리즘
- 문자열 처리
- Python : 리스트 컴프리헨션

---

# Python
## Python 풀이1
```python
def solution(my_string: str):
    my_string = my_string.replace(' ', '')
    answer = 0
    is_plus = True

    value = 0
    for ch in my_string:
        if ch.isnumeric():
            value = value * 10 + int(ch)
        else:
            answer += value if is_plus else -value
            value = 0
            if ch == '+':
                is_plus = True
            else:
                is_plus = False

    answer += value if is_plus else -value
    return answer

```
- 문자열의 공백 제거
- 문자열을 한 자 한 자 분석하면서, 값을 더해 나감.

## Python 풀이2
```python
def solution(my_string: str):
    return sum(int(i) for i in my_string.replace(' - ', ' + -').split(' + '))

```
- ` - `을 ` + -`로 변환한 뒤, ' + '로 분리하면 모두 숫자형태의 문자만 남는다.
- 이들을 모두 숫자로 파싱한 뒤, 더하면 된다.
- 가장 파이썬다운 풀이

## Python 풀이3
```python
solution = eval
```
- solution 함수를 eval로 바꾼다.
  - eval은 문자열을 파이썬의 코드로 보고, 그대로 평가한다.
- 아니 내가 한 수고는 뭔데...

---

# Java
## Java 풀이1
```java
class Solution1 {
    public int solution(String my_string) {
        int sum = 0;
        String[] numbers = my_string.replaceAll("\\s\\-\\s", " + -").split("\\s\\+\\s");

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
```
- 파이썬 풀이2과 같다. 근데 주의할 점은 replaceAll을 사용 시, 정규표현식으로 대상을 지정해야한다.

## Java 풀이2
```java
class Solution2 {
    public int solution(String my_string) {
        my_string = my_string.replaceAll(" ", "");
        int answer = 0;
        boolean isPlus = true;
        int value = 0;
        for (char ch : my_string.toCharArray()) {
            if (48 <= ch && ch < 58) {
                value = value * 10 + (ch - 48);
            } else {
                answer += (isPlus) ? value : -value;
                value = 0;
                isPlus = (ch == '+');
            }
        }
        answer += (isPlus) ? value : -value;
        return answer;

    }
}
```
- 파이썬 풀이1과 같다.

---

# JavaScript
```javascript
const solution = eval
```
- JavaScript에서도 eval 함수가 존재한다.
- solution을 eval로 지정한다.

---
