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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp = list1, prev = null;
        int len = 0;
        while (temp != null) {
            if (len < a)
                prev = temp;
            if (len == b) {
                break;
            }
            len++;
            temp = temp.next;
        }

        prev.next = list2;
        ListNode temp2 = list2;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        temp2.next = temp.next;
        return list1;
    }
}