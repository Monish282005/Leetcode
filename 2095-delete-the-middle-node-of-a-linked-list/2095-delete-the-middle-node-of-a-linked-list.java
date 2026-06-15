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
    public ListNode deleteMiddle(ListNode head) {
        int size = 0;
        ListNode temp = head;

        while(temp != null){
            size++;
            temp = temp.next;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        ListNode prev = null;
        ListNode next = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            next = slow.next;
        }

        if((size & 1) == 0){
            prev = slow;
            slow = slow.next;
            next = slow.next;
        }
        
        if(size == 1)
            return null;
            
        slow.next = null;
        prev.next = next;

        return head;

    }
}