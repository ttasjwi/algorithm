# 문제
- 플랫폼 : 인프런 강의
- 번호 : 1.2
- 제목 : 대소문자 변환
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 1.2 문제)

---

# 필요 지식
- 문자열 처리

---

# 풀이

## Python
```python
print(input().swapcase())
```
```python
answer = []
for ch in input():
    code = ord(ch)
    if code >= 97:
        code -= 32
    else:
        code += 32
    answer.append(chr(code))
print(''.join(answer))
```
- 방법 1 : `swapcase()`로 대소문자 변환
- 방법 2 : ord로 아스키 코드 값을 가져와서, 소문자 범위이면 32를 빼고, 아니면 32를 빼서 변환

## Java
```java
    private static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                sb.append(Character.toLowerCase(ch));
            } else {
                sb.append(Character.toUpperCase(ch));
            }
        }
        return sb.toString();
    }
}
```
- 방법 1 : isLowerCase, isUpperCase 확인 후 분기처리(대 -> 소, 소 -> 대)
- 방법 2 : 아스키코드 값 활용
  - 대문자 : 65~90
  - 소문자 : 97~122

---
