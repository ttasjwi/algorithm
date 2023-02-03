# 1-7. 회문 문자열

- 분류 : 문자열(String)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 1-7 문제)

---

## 시간복잡도
- 문자열의 길이를 N이라 할 때 문자열을 반으로 잘라서 비교하므로 시간복잡도는 O(N/2)일 듯

---

## 풀이1. 양끝을 순서대로 비교
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

## 풀이2. 뒤집은 문자를 equalsIgnoreCase 활용 비교
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