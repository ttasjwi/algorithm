---
# [LeetCode - 83] Remove Duplicates from Sorted List

https://leetcode.com/problems/remove-duplicates-from-sorted-list/

---

## 풀이
- `null`이 들어오면 null 반환
- `prev` : 이전 노드(초깃값 : head)
- `current` : 다음 노드 (초깃값 : prev.next)
- `current`가 null이 아닌 경우 다음을 반복한다.
  - `prev.val`과 `current.val`이 같은 경우
    - `prev.next`가 `current.next`를 가리키게 함.
    - `current`만 갱신하면 된다. `current`가 `current.next`를 가리키게 함.
  - `prev.val`과 `current.val`이 다른 경우
    - `prev`가 `current`를 가리키게 함
    - `current`가 `prev.next(다음 노드)`를 가리키게 한다.
- head를 반환한다.
```
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode prev = head;
        ListNode current = prev.next;

        while (current != null) {
            if (prev.val == current.val) {
                prev.next = current.next;
                current = current.next;
            } else {
                prev = current;
                current = prev.next;
            }
        }
        return head;
    }
```

---