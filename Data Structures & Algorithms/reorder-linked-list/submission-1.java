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
    public void reorderList(ListNode head) {
        ListNode mid = findMiddle(head);
        ListNode reversedSecond = reverse(mid);
        zip(head, reversedSecond);
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null; // cut here
        return mid;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public ListNode zip(ListNode list1, ListNode list2){
        ListNode root = list1;
        ListNode root2 = list2;
        while(root != null && list2 != null) {
            ListNode tmp = root.next;
            root.next = list2;
            list2 = list2.next;
            root.next.next = tmp;
            root = root.next.next;
        }

        if(list2 != null) {
            root = list2;
        }

        return root;
    }
}
