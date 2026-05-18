
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        ListNode temp = head;
        ListNode res = new ListNode(0);
        ListNode ans = res;

        int len = 0;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        if (k == 0 || len == 0)
            return head;

        temp = head;
        k %= len;
        int n = len - k;

        while (temp != null) {
            if (n <= 0) {
                res.next = temp;
                res = res.next;
            }
            n--;
            temp = temp.next;
        }

        n = 0;
        temp = head;

        while (n < len - k) {
            res.next = temp;
            res = res.next;
            temp = temp.next;
            n++;
        }

        res.next = null;

        return ans.next;
    }
}