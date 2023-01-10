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