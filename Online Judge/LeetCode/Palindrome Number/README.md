---
# [LeetCode - 9] Palindrome Number

https://leetcode.com/problems/palindrome-number/

## 풀이
- x가 0보다 작으면 false를 반환
- `chars` : 숫자의 각 자릿수를 쪼개서 배열에 문자단위로 저장
- `middleIndex` : 자리의 갯수가 홀수일 때는 가운데 인덱스를 가리키고, 짝수일 때는 반으로 나눴을 때 절반 이후의 첫번째 인덱스를 가리킨다.
- `middleIndex` 회 만큼 다음을 반복한다.
  - 각자리에 대칭되는 자리의 문자가 서로 일치하는지 여부를 판단하여 일치하지 않으면 false를 반환한다.
  - 가운데까지 순회했을 때 다른 문자가 존재하지 않으면 true를 반환한다.

```
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        char[] chars = String.valueOf(x).toCharArray();

        int middleIndex = chars.length >> 1;

        for (int i=0; i<middleIndex; i++) {
            if (chars[i] != chars[chars.length-1-i]) return false;
        }
        return true;
    }
```

---