# 문제
- 플랫폼 : 인프런 강의
- 번호 : 1.1
- 제목 : 문자 찾기
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 1-1 문제)

---

# 필요 지식
- 문자열 처리

---

# 풀이
## Java
```java
    private static int solution(String str, char ch) {
        str = str.toUpperCase();
        ch = Character.toUpperCase(ch);

        int count = 0;

        for (char c : str.toCharArray()) {
            if (c == ch) {
                count ++;
            }
        }
        return count;
    }
```
- 문자열과 문자의 대소문자가 맞으리란 보장이 없으므로 대소문자 통일
  - 문자열 : toUpperCase, toLowerCase
  - 문자 : Character.toUpperCase(ch), Character.toLowerCase(ch)
- 문자의 비교는 `==` 사용

### 삽질과정 : 아스키 코드로 비교
```java
    private static boolean isSameAlphabet(char ch1, char ch2) {
        if (ch1 == ch2) {
            return true;
        } else if (ch1 > ch2 && (ch1-ch2 == 32)) {
            return true;
        } else if (ch1 < ch2 && (ch2-ch1 == 32)) {
            return true;
        } else {
            return false;
        }
    }
```
- 문자열의 아스키 코드로 비교하기

## Python
```python
word = input().lower()
ch = input().lower()
answer = word.count(ch)
print(answer)
```
- lower로 소문자화
- 문자열의 count 함수로 등장횟수 세기

---
