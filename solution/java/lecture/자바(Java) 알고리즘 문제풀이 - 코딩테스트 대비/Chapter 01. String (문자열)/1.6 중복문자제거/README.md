# 1-6. 중복문자제거

- 분류 : 문자열(String)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 1-6 문제)

---

## 시간복잡도
- 모든 문자를 순서대로 확인해야하므로 문자의 길이가 N이면 O(N)

---

## 풀이1 : LinkedHashSet 활용
```java
    private static String solution(String word) {
        LinkedHashSet<Character> chars = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : word.toCharArray()) { // charSet에 순서대로 전부 더 한다. 
            chars.add(ch);
        }
        for (Character ch : chars) { // charSet을 읽고 순서대로 sb에 append
            sb.append(ch);
        }
        return sb.toString();
    }
```
- java의 `LinkedHashSet`은 순서가 있는 Set이다.
  - 나중에 추가하는 중복 요소는 추가되지 않는다.
- word의 단어들을 순서대로 set에 삽입한다.
- set을 순서대로 읽어서 중복 문자가 제거된 문자열을 반환한다.

---

## 풀이2 : indexOf 활용
```java
    private static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (word.indexOf(ch) == i) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
```
- `indexOf(char ch)` 메서드는 지정 문자가 위치한 인덱스를 앞에서부터 찾아서 반환한다.
- 현재 인덱스와 indexOf의 반환 인덱스값이 서로 다르면, 나중에 나온 문자라는 뜻이다.
- 서로 같은 경우에만 sb에 추가한다.

---