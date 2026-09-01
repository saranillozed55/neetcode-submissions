class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        if (n == 1) {
            prev = prev.next;
        } else {
            ListNode target = prev;
            for (int i = 1; i < n - 1; i++) {
                target = target.next;
            }
            target.next = target.next.next;
        }

        curr = null;
        while(prev != null) {
            ListNode temp = prev.next;
            prev.next = curr;
            curr = prev;
            prev = temp;
        }
        return curr;
    }
}