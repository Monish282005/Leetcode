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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while(temp1 != null){
            list1.add(temp1.val);
            temp1 = temp1.next;
        }

        while(temp2 != null){
            list2.add(temp2.val);
            temp2 = temp2.next;
        }

        int i = list1.size()- 1, j = list2.size() - 1;
        List<Integer> res = new ArrayList<>();
        int rem = 0;
        while(i >= 0 && j >= 0){
            int sum = list1.get(i) + list2.get(j) + rem;
            res.add(0, sum % 10);
            rem = sum / 10;
            i--;j--;
        }

        while(i >= 0){
            int sum = list1.get(i) + rem;
            res.add(0, sum % 10);
            rem = sum /10;
            i--;
        }

        while(j >= 0){
            int sum = list2.get(j) + rem;
            res.add(0, sum % 10);
            rem = sum / 10;
            j--;
        }

        if(rem != 0){
            res.add(0, rem);
        }
        ListNode ans = new ListNode(0);
         temp1 = ans;

        for(int it: res){
            ans.next = new ListNode(it);
            ans = ans.next;
        }
        
        return temp1.next;
    }
}