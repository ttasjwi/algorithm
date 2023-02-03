# 문제
- 플랫폼 : 인프런 알고리즘 문제풀이 입문
- 번호 : 1.6
- 제목 : 중복문자제거
- 문자열의 중복문자는 한번만 나오게 한 문자열 출력(먼저 나온 단어만 살린다.)

---

# 필요 지식
- 문자열 처리
- 해시

---

# Python
```python
char_set = set()
answer = []
for ch in input():
    if ch not in char_set:
        answer.append(ch)
        char_set.add(ch)
print(''.join(answer))
```
- set을 별도로 만들고, 한번 등장한 단어를 여기에 삽입한다.
- 한번도 등장하지 않은 단어만 answer에 append 한다.
- answer를 join해서 출력

# Java
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
