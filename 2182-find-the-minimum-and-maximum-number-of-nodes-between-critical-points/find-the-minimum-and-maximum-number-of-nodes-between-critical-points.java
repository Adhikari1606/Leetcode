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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1}; 
        }
        
        int min = Integer.MAX_VALUE;
        int max = 0;
        ListNode first = head;
        ListNode second = first.next;
        ListNode third = second.next;
        int ctr = 0;
        int prevCritical = -1;
        int firstCritical = -1;

        while (third != null) {
            ctr++;
            if ((second.val > first.val && second.val > third.val) || 
                (second.val < first.val && second.val < third.val)) {
                if (firstCritical == -1) {
                    firstCritical = ctr;
                } else {
                    min = Math.min(min, ctr - prevCritical);
                }
                prevCritical = ctr;
                max = ctr - firstCritical;
            }
            first = first.next;
            second = second.next;
            third = third.next;
        }

        if (min == Integer.MAX_VALUE) {
            return new int[]{-1, -1}; 
        }

        return new int[]{min, max};
    }
}
