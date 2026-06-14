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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode next = null;

        while (secondHalf != null) {
            next = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = next;
        }

        int maxTwin = Integer.MIN_VALUE;
        secondHalf = prev;
        while(head != null){
            maxTwin = Math.max(head.val + secondHalf.val, maxTwin);
            head = head.next;
            secondHalf = secondHalf.next;    
        }

        return maxTwin;
    }
}