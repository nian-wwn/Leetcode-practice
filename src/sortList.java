/**
 * @title 148. 排序链表
 * <p>
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 递归，自顶向下，时间复杂度O(n log n)
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
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }

        if (head.next == tail) {
            head.next = null;
            return head;
        }
        //循环找到中点，快指针移动两步，慢指针移动一步，快到末尾时，慢正好为中点
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        //递归
        ListNode mid = slow;
        ListNode list1 = sortList(mid, tail);
        ListNode list2 = sortList(head, mid);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }
    //合并
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
        if (temp1!=null){
            temp.next = temp1;
        }else {
            temp.next = temp2;
        }
        return dummyHead.next;
    }


}
