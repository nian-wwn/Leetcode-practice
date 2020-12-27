public class sortList1 {
    /**
     * @title 148. 排序链表
     * <p>
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     * <p>
     * 递归，自底往上，时间复杂度O(1)
     */


    public class sortList {
        public class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

        public ListNode sortList(ListNode head) {
            if (head == null) {
                return head;
            }
            int length = 0;
            //遍历链表长度
            ListNode node = head;
            while (node != null) {
                node = node.next;
                length++;
            }
            //i<<1 ----->  i = i*2
            ListNode dummyHead = new ListNode(0, head);
            for (int i = 1; i < length; i <<= 1) {
                ListNode prev = dummyHead, curr = dummyHead.next;
                while (curr != null) {
                    ListNode head1 = curr;
                    for (int j = 1; j < i && curr.next != null; j++) {
                        curr = curr.next;
                    }

                    ListNode head2 = curr.next;
                    curr.next = null;
                    curr = head2;
                    for (int j = 1; j < i && curr != null && curr.next != null; j++) {
                        curr = curr.next;
                    }

                    ListNode next = null;
                    if (curr != null) {
                        next = curr.next;
                        curr.next = null;
                    }

                    ListNode merged = merge(head1, head2);
                    prev.next = merged;
                    while (prev.next != null) {
                        prev = prev.next;
                    }
                    curr = next;
                }
            }
            return dummyHead;
        }

        public ListNode merge(ListNode list1, ListNode list2) {
            ListNode dummyHead = new ListNode(0);
            ListNode temp = dummyHead, temp1 = list1, temp2 = list2;

            while (temp1 != null && temp2 != null) {
                if (temp1.val <= temp2.val) {
                    temp.next = temp1;
                    temp1 = temp1.next;
                } else {
                    temp.next = temp2;
                    temp2 = temp2.next;
                }
                temp = temp.next;
            }
            if (temp1 != null) {
                temp.next = temp1;
            } else {
                temp.next = temp2;
            }
            return dummyHead.next;

        }
    }
}
