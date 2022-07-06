# 1-5. 특정 문자 뒤집기

- 분류 : 문자열(String)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 1-5 문제)

---

## 시간복잡도
- 문자열의 길이를 N이라 할 때 시간복잡도는 O(N/2)일 듯?

---

## 풀이
```java
    public static String solution(String word) {
        char[] charArray = word.toCharArray();

        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            if (!Character.isAlphabetic(charArray[left])) {
                // left가 특수문자일 때는 뒤집지 못 함
                left  ++;
            } else if (!Character.isAlphabetic(charArray[right])) {
                // left가 알파벳이고 right가 특수문자이면 뒤집지 못 함
                right --;
            } else {
                // left가 알파벳이고 right가 알파벳이면 뒤집을 수 있음
                char tmp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = tmp;
                left ++;
                right --;
            }
        }
        return String.valueOf(charArray);
    }
```
- 문자열의 왼쪽, 오른쪽을 left, right로 두고 left가 right 앞일 동안 반복
- left가 특수문자이면 뒤집을 수 없으므로 left 증가
- left가 알파벳이고 right가 특수문자이면 뒤집을 수 없으므로 right 증가
- left가 알파벳이고 right가 알파벳이면 뒤집을 수 있다. 뒤집고 left 증가, right 감소

---
