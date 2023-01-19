# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120904
- 제목 : 숫자 찾기
- 난이도 : Level 0
- num을 이루는 숫자 중에 k가 있으면 num의 그 숫자가 있는 자리 수를 return하고 없으면 -1을 return 
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120904)

---

# 필요 알고리즘
- 없음

---

# Python
```python
def solution(num, k):
    num, k = str(num), str(k)
    return num.find(k) + 1 if k in num else -1
```
- num, k를 문자열로 변환한다.
- k가 num 에 있으면 index + 1을 반환하고(find 함수), 없으면 -1을 반환한다.

---

# Java
```java
public class Solution {
    public int solution(int num, int k) {
        String strNum = String.valueOf(num);

        for (int i=0; i< strNum.length(); i++) {
            if (strNum.charAt(i) == (k+48)) {
                return i+1;
            }
        }
        return -1;
    }
}
```
- 숫자를 문자열로 변환하여 순서대로 순회한다.
- 특정 자리 문자가 문자로 환산한 k와 같다면 그 자리의 순서를 반환하고 없으면 -1을 반환한다.

---
