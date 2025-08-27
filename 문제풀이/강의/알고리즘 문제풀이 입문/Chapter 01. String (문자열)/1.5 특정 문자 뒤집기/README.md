# 문제
- 플랫폼 : 인프런 알고리즘 문제풀이 입문
- 번호 : 1.5
- 제목 : 특정 문자 뒤집기
- 문자열이 주어질 때 다음 지시에 따라 문자를 뒤집어라.
  - 왼쪽, 오른쪽 끝에 커서를 두고 가운데로 전진시킨다.
  - 둘 모두 특수 문자면 커서를 다음으로 이동시킨다.
  - 둘 중 하나가 특수문자면 특수문자인 쪽의 커서를 다음 쪽으로 이동시킨다.
  - 둘 다 영문자면 둘을 서로 자리 바꾸고 커서를 이동시킨다.

---

# 필요 지식
- 문자열 처리

---

## Python
```python
word = list(input())
lt = 0
rt = len(word) - 1

while lt < rt:
    if not word[lt].isalpha():
        lt += 1
    elif not word[rt].isalpha():
        rt -= 1
    else:
        word[lt], word[rt] = word[rt], word[lt]
        lt += 1
        rt -= 1
print(''.join(word), end='')
```
- lt, rt 포인터를 두고 좌우로 이동하면서 판단
- 파이썬은 튜플을 이용한 변수 스와핑이 가능하다.
- 문자열은 변경 불가능하므로 배열로 처리해야한다.


## Java
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
- 파이썬과 달리 변수 스와핑을 위해 별도의 변수가 하나 필요하다.
- 마찬가지로 문자열은 변경 불가능하므로 배열로 처리해야한다.

---
