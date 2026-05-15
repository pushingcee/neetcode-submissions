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
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head.next;

        while(fastPointer != null) {
            if(fastPointer == slowPointer) {
                return true;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
            if(fastPointer == null) {
                return false;
            }
            fastPointer = fastPointer.next;
        }

        return false;
    }
}
