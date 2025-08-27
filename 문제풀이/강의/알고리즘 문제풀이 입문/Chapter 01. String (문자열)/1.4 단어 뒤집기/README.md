# 문제
- 플랫폼 : 인프런 알고리즘 문제풀이 입문
- 번호 : 1.4
- 제목 : 단어 뒤집기

---

# 필요 지식
- 문자열 처리

---

# 풀이
## Python
```python
n = int(input())
answer = [input()[::-1] for i in range(n)]
print('\n'.join(answer), end='')
```
- `문자열[::-1]` 을 통해 뒤집은 문자열 얻기
- 출력

## Java
### 풀이1 : StringBuilder의 reverse 활용
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

### 풀이2 : 직접 뒤집기
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
