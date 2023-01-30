# 문제
- 플랫폼 : LeetCode
- 번호 : 0021
- 제목 : Merge Two Sorted Lists
- 난이도 : Easy
- 정렬되어 있는 두 연결 리스트를 정렬 상태로 합쳐라.
- 문제 : <a href="https://leetcode.com/problems/merge-two-sorted-lists" target="_blank">링크</a>

---

# 필요 지식
- 연결 리스트

---

# 풀이

## 풀이1
```python

class Solution:
    def mergeTwoLists(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        head = ListNode()
        cursor = head

        while l1 and l2:
            if l1.val <= l2.val:
                cursor.next = l1
                l1 = l1.next
            else:
                cursor.next = l2
                l2 = l2.next
            cursor = cursor.next

        if l1:
            cursor.next = l1
        if l2:
            cursor.next = l2

        return head.next
```
- l1과 l2 중 어느 하나가 None을 가리킬때까지 다음을 반복한다.
  - l1과 l2의 현재값을 비교하고 작은 쪽을 cursor의 next에 연결한다. 연결후 해당 리스트는 next를 통해 다음 요소로 바꾼다.
  - 커서를 다음으로 이동한다.
- l1, l2 중 남아있는 것은 커서의 뒤에 연결한다.
- 마지막으로 head의 next를 호출해 우리가 연결한 리스트들만 반환한다.

## 풀이2 : 재귀
```python
class Solution:
    def mergeTwoLists(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        if (not l1) or (l2 and l1.val > l2.val):
            l1, l2 = l2, l1
        if l1:
            l1.next = self.mergeTwoLists(l1.next, l2)
        return l1
```
- l1이 None이거나, l1, l2 모두 존재하는데 l1의 요소가 l2보다 클 경우 l1, l2를 스왑하여, 작은 쪽을 l1에 둔다.
  - (재귀) l1이 None이 아니면, le의 다음 요소에 l1의 다음 요소, l2의 병합 결과물을 연결한다.
- 병합 결과물인 l1을 반환한다.

---
