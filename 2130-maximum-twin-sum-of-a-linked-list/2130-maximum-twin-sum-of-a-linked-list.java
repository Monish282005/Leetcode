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
        List<Integer> list = new ArrayList<>();

        ListNode node = head;

        while(node != null){
            list.add(node.val);
            node = node.next;
        }

        int maxTwin = Integer.MIN_VALUE;

        for(int i = 0; i < list.size()/2; i++){
            maxTwin = Math.max(maxTwin, list.get(i) + list.get(list.size() - i - 1));
        }

        return maxTwin;
    }
}