/**
 * Created by zhangxinyin on 10/3/16.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return head;
        }
        ListNode rightList = new ListNode(Integer.MAX_VALUE);
        ListNode leftList = new ListNode(Integer.MIN_VALUE);
        ListNode dummyLeft = leftList;
        ListNode dummyRight = rightList;
        while(head != null) {
            if(head.val < x) {
                leftList.next = head;
                leftList = leftList.next;
            } else {
                rightList.next = head;
                rightList = rightList.next;
            }
            head = head.next;
        }
        leftList.next = dummyRight.next;
        rightList.next = null;
        return dummyLeft.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        PartitionList partitionList = new PartitionList();
        ListNode x = partitionList.partition(head,2);
        while(x != null) {
            System.out.println(x.val);
            x = x.next;
        }
    }
}
