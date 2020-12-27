/**
 * @title 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */

public class addTwoNumbers {
    public ListNode addTwoNumber(ListNode list1, ListNode list2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (list1 != null || list2 != null) {
            //依次遍历两个链表
            int n1 = list1 != null ? list1.val : 0;
            int n2 = list2 != null ? list2.val : 0;
            //按位相加以及进位
            int sum = n1 + n2 + carry;

            //将结果存入新建的链表中
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            //进位
            carry = sum / 10;

            if (list1 != null) {
                list1 = list1.next;
            }
            if (list2 != null) {
                list2 = list2.next;
            }

        }
        //判断最后一位是否进位
        if (carry>0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

}
