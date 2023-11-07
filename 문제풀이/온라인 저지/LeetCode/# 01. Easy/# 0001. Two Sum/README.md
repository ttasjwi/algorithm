# 문제
- 플랫폼 : LeetCode
- 번호 : 0001
- 제목 : Two Sum
- 난이도 : Easy
- 덧셈을 하여 target을 만들 수 있는 배열의 두 숫자 인덱스를 반환하기
- 문제 : <a href="https://leetcode.com/problems/two-sum" target="_blank">링크</a>

---

# 필요 지식
- 브루트 포스
- 해시
- 정렬, 투포인터

---

# 풀이
## 풀이1: 해시
```kotlin
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        var pair: Int
        for (i in nums.indices) {
            pair = target - nums[i]
            if (map.containsKey(pair)) {
                return intArrayOf(map[pair]!!, i)
            } else {
                map[nums[i]] = i
            }
        }
        return intArrayOf()
    }
}
```
- 짝이 있는 지 맵에서 찾고, 있다면 반환
- 짝이 없으면 map에 삽입

## 풀이2 : 브루트 포스
```kotlin
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            for (j in i+1..nums.lastIndex) {
                if (nums[i] + nums[j] == target) return intArrayOf(i, j)
            }
        }
        return intArrayOf()
    }
    
}
```
- 배열을 2번 반복하면서, 모든 조합을 더해 일일이 확인하는 무차별 대입
- 시간 복잡도 : O(N^2)
- 지나치게 느리다.

## 풀이3 : 정렬, 투 포인터
```kotlin
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val items = nums.mapIndexed{idx, value -> Data(idx, value)}.sorted()
        var lt = 0
        var rt = items.lastIndex
        var sum: Int
        while (lt < rt) {
            sum = items[lt].value + items[rt].value
            if (sum == target) {
                return if (items[lt].idx < items[rt].idx) intArrayOf(items[lt].idx , items[rt].idx)
                else intArrayOf(items[rt].idx, items[lt].idx)
            } else if (sum > target) {
                rt --
            } else {
                lt ++
            }
        }
        return intArrayOf()
    }
}

class Data(val idx: Int, val value: Int) : Comparable<Data> {
    override fun compareTo(other: Data): Int {
        return value - other.value
    }
}
```
- 정렬후 투포인터 방식으로 문제를 해결하는 방식
- 정렬이 되어 있기 때문에 포인터를 조절하는 것만으로 리스트를 한번 순회해서 해결할 수 있다.
- 다만 정렬해야하는 비용이 있다.(O(NLogN))

---
