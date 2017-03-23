/**
 * Created by zhangxinyin on 10/4/16.
 */
public class SortedToBST {
    private ListNode curr;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        int length = getListLength(head);
        curr = head;

        return sortedListToBSTHelper(length);
    }

    private int getListLength(ListNode head) {
        int listSize = 0;
        while (head != null) {
            listSize++;
            head = head.next;
        }
        return listSize;
    }

    private TreeNode sortedListToBSTHelper(int length) {
        if (length == 0) {
            return null;
        }

        TreeNode left = sortedListToBSTHelper(length / 2);
        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;
        TreeNode right = sortedListToBSTHelper(length - length / 2 - 1);

        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        SortedToBST sortedToBST = new SortedToBST();
        sortedToBST.sortedListToBST(head);
    }
}
