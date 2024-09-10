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
    public int gcd(int a, int b) {
    if (a == b) {
        return a;
    }
    if (a > b) {
        return gcd(a - b, b);
    } else {
        return gcd(a, b - a);
    }
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            int a = temp.val;
            int b = temp.next.val;
            int gcdValue = gcd(a, b);
            ListNode middle = new ListNode(gcdValue);
            middle.next = temp.next;
            temp.next = middle;
            temp = middle.next;
        }

        return head;
    }
}