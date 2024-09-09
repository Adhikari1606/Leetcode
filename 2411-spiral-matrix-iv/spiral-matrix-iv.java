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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] arr=new int[m][n];
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        ListNode temp=head;

        while (left <= right && top <= bottom) {
    
            for (int j = left; j <= right; j++) {
                if(temp!=null){
                arr[top][j] = temp.val;
                temp=temp.next;
                }
                else{
                    arr[top][j]=-1;}
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                if(temp!=null){
                arr[i][right] = temp.val;
                temp=temp.next;
                }
                else{
                    arr[i][right]=-1;}
            }
            right--; 
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    if(temp!=null){
                    arr[bottom][j] = temp.val;
                    temp=temp.next;}
                    else{
                    arr[bottom][j]=-1;}
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    if(temp!=null){
                    arr[i][left] = temp.val;
                    temp=temp.next;}
                    else{
                    arr[i][left]=-1;}
                }
                left++;
            }
        }
        return arr;
    }
}