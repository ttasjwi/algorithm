# 문제
- 플랫폼 : 인프런 알고리즘 문제풀이 입문
- 번호 : 1.7
- 제목 : 회문 문자열
- 문자열이 뒤집은 문자열과 서로 같은지 여부 판단(단, 대소문자 구분 안 함)

---

# 필요 지식
- 문자열 처리

---

# 풀이
## Python
```python
s = input().lower()
answer = 'YES' if s == s[::-1] else 'NO'
print(answer, end='')
```
- 문자열 슬라이싱 활용하여 뒤집은 문자열 비교

## Java
### 풀이1. 양끝을 순서대로 비교
```java
    private static String solution(String word) {
        word = word.toLowerCase();

        int left = 0;
        int right = word.length()-1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return "NO";
            }
            left ++;
            right--;
        }
        return "YES";
    }
```
- 문자를 소문자로 통일
- 왼쪽, 오른쪽 끝 단어를 잡아다 반복적으로 돌려서 비교

### 풀이2. 뒤집은 문자를 equalsIgnoreCase 활용 비교
```java
    private static String solution(String word) {
        String reverse = new StringBuffer(word).reverse().toString();
        return (word.equalsIgnoreCase(reverse))
                ? "YES"
                : "NO";
    }
```
- `StringBuilder.reverse` : 문자열을 역으로 뒤집음
- `equalsIgnoreCase` : 대소문자를 무시하고 문자열의 동등성을 비교

---
