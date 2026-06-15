
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

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if((size & 1) == 0){
            prev = slow;
            slow = slow.next;
        }
        
        if(size == 1)
            return null;
            
        prev.next = slow.next;
        slow.next = null;

        return head;

    }
}