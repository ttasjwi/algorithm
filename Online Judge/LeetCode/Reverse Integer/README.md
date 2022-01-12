---
# [LeetCode - 7] Reverse Integer

https://leetcode.com/problems/reverse-integer/

## 풀이
- x가 0보다 작으면 isNegative를 true로 함
- 절댓값 변수 absX 생성
- absX가 0보다 클 때 다음 행위를 반복함
  - answer에 10 곱함
  - answer에 absX를 10으로 나눈 나머지를 더함
  - absX를 10으로 나눔(소숫점 이하는 버림)
- answer값이 Integer 범위 넘어서면 0을 반환함
- isNegative가 true이면 음수로 반환

```
    public int reverse(int x) {
        boolean isNegative = x<0;

        int absX = (isNegative)? -x : x;
        long answer = 0;

        while(absX > 0) {
            answer *= 10;
            answer += absX%10;
            absX /= 10;
        }
        if (answer > Integer.MAX_VALUE) {
            answer = 0;
        }
        return (isNegative)? -(int)answer : (int)answer;
    }
```

---