---
# [LeetCode - 141] Linked List Cycle

https://leetcode.com/problems/linked-list-cycle/

## 풀이1 (내가 푼 방식)

```
import java.util.HashSet;
import java.util.Set;

public class Solution1 {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> listNodes = new HashSet<>();
        ListNode current = head;

        while(current!= null) {
            if (listNodes.contains(current))
                return true;
            else {
                listNodes.add(current);
                current = current.next;
            }
        }
        return false;
    }
}
```

- HashSet 생성
- 노드를 순차적으로 순회하면서, 그 노드가 Set에 있는지 확인하고 없으면 추가한뒤 다음 노드로 넘어간다.
- 그 노드가 Set에 존재하면 true를 반환한다.
- 끝까지 탐색(null에 도착했을 때) 반복을 탈출하고 false를 반환한다.

---

## 풀이2 (해설) - twoPoint

```
public class Solution2 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next != null && runner.next.next!=null) {
            runner = runner.next.next;
            walker = walker.next;
            if (runner == walker) return true;
        }
        return false;
    }
}
```

- 빠르게 앞서가는 runner, 느리게 노드를 탐색하는 walker를 선언한다.
- runner는 2칸 앞선 node를 탐색하고, walker는 1칸 앞선 node를 탐색한다.
- runner가 null에 도달하면 false를 반환
- 순회하다가 runner와 walker가 같은 노드를 가리키면 true를 반환

---