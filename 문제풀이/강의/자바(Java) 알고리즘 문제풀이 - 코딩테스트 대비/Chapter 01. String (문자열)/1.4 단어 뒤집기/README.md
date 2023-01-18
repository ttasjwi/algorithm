# 1-4. 단어 뒤집기

- 분류 : 문자열(String)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 1-4 문제)

---

## 시간복잡도
- 단어의 갯수를 N, 단어의 최대 길이를 M이라 할 때 시간복잡도는 O(NM)

---

## 풀이1 : StringBuilder의 reverse 활용
```java
    public static String solution(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            StringBuilder subSb = new StringBuilder(word);
            subSb.reverse();
            sb.append(subSb).append('\n');
        }
        return sb.toString();
    }
}

```
- StringBuilder의 reverse는 빌더에 저장된 문자열을 뒤집음

## 풀이2 : 직접 뒤집기
```java
    public static String solution(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            for (int i=word.length()-1; i>=0; i--) {
                sb.append(word.charAt(i));
            }
            sb.append('\n');
        }
        return sb.toString();
    }
```
- 각 단어 문자를 역순으로 StringBuilder에 append 시킴

---
