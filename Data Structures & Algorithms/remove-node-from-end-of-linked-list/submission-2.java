/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headPointer = head;
        ListNode nPointer = head;
        
        // 1 2 
        for(int i = 0; i < n; i++) {
            nPointer = nPointer.next;
        }
        // hPo = 1;
        // nPo: 1, 2;
        ListNode prev = null;
        
        while(nPointer != null) {
            prev = headPointer;
            headPointer = headPointer.next;
            nPointer = nPointer.next;
        }
        if (prev != null) {
            prev.next = headPointer.next;
        } else {
            return head.next;
        }
        return head;
    }
}
