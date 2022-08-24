# \[BOJ 10171\] 고양이

- 난이도 : Bronze 5
- 이스케이프 시퀀스
- 문제 : https://www.acmicpc.net/problem/10171

---

## 이스케이프 시퀀스(Escape-Sequence)
- 백슬래시( \ ) 뒤에 한 문자나 숫자 조합이 오는 문자 조합을 "이스케이프 시퀀스"라고 한다.
- 줄 바꿈 문자, 작은따옴표, 또는 문자 상수의 다른 특정 문자를 나타내려면 이스케이프 시퀀스를 사용해야 한다.
- https://docs.microsoft.com/ko-kr/cpp/c-language/escape-sequences?view=msvc-160
- 예시
  - `\n` : 개행(줄바꿈)
  - `\\` : 백슬래시
  - `\'` : 홑따옴표
  - `\"` : 쌍따옴표
  - `\t` : 탭문자

---

## 풀이
```java
public class Main {

    public static void main(String[] args) {
        System.out.print("\\    /\\\n )  ( ')\n(  /  )\n \\(__)|");
    }

}
```
- `\`을 출력하려면 `\\`을 문자열에 넣어야한다.

---
