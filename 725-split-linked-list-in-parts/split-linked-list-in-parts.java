class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        
        int partSize = len / k;
        int remainder = len % k;

        ListNode[] result = new ListNode[k];
        ListNode current = head;

        for (int i = 0; i < k; i++) {
            ListNode partHead = current;
            int currentPartSize = partSize + (remainder > 0 ? 1 : 0);
            remainder--;

            for (int j = 0; j < currentPartSize - 1 && current != null; j++) {
                current = current.next;
            }

            if (current != null) {
                ListNode nextPart = current.next;
                current.next = null;
                current = nextPart;
            }

            result[i] = partHead;
        }

        return result;
    }
}
