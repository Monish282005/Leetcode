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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        List<Integer> arr = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        left--;
        right--;
        
        while (left < right) {
            int x = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, x);
            left++;
            right--;
        }

        temp = new ListNode();
        ListNode dummy = temp;
        for (Integer i : arr) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        return dummy.next;
    }
}