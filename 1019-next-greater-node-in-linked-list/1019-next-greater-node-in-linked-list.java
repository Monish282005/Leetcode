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
class Pair {
    int val;
    int idx;

    public Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        int[] res = new int[arr.size()];
        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < arr.size(); i++) {
            while (!st.isEmpty() && arr.get(i) > st.peek().val) {
                res[st.pop().idx] = arr.get(i);
            }
            st.push(new Pair(arr.get(i),i));
        }

        return res;
    }
}