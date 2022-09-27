public class Solution {
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
}