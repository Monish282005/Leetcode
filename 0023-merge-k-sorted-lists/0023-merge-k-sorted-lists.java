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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> arr = new ArrayList<>();

        for (ListNode it : lists) {
            ListNode temp = it;
            while (temp != null) {
                arr.add(temp.val);
                temp = temp.next;
            }
        }

        Collections.sort(arr);

        ListNode head = new ListNode();
        ListNode temp = head;

        for (Integer i : arr) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return head.next;
    }
}