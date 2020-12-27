public class insertionSortList {
    /**
     * @title 147. 对链表进行插入排序
     * <p>
     * 插入排序算法：
     * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
     * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
     * 重复直到所有输入数据插入完为止。
     *
     * 时间复杂度 O（n²）
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertion_SortList(ListNode head) {
        if (head == null) {
            return head;
        }
        //创建头节点，
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode lastSorted = head, curr = head.next;

        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            }else {
                ListNode prev = dummyHead;
                //从头节点开始遍历，找到插入点prev
                while (prev.next.val<=curr.val){
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }
}
