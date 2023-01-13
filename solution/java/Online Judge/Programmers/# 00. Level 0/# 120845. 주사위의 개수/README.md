# 문제
- 번호 : 120845
- 제목 : 주사위의 개수
- 난이도 : Level 0
- 상자에 들어갈 수 있는 주사위의 최대 개수를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120845)

---

# 필요 알고리즘
- 단순 산수

---

# 풀이
```java
public class Solution {

    public int solution(int[] box, int n) {
        return (box[0]/n) * (box[1]/n) * (box[2]/n);
    }
}
```

---
