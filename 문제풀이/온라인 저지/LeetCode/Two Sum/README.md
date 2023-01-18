
---

# [LeetCode - 1] Two-Sum

https://leetcode.com/problems/two-sum

## 풀이
- 이중 for문을 사용
- 배열의 0번 요소부터 그 다음의 요소들을 순차적으로 탐색
- j는 무조건 i 이후에 오는 숫자가 오도록 함으로서, 같은 값을 두번 탐색하는 일을 없도록 함.

```
public class Solution {

    public int[] twoSum(int[] nums, int target) {

        int[] answer = new int[2];

        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (target == nums[i]+nums[j]) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }
}
```

---