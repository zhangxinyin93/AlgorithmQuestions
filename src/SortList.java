/**
 * Give a List, sort it in O(nlogn) time complexity and constant space
 * Do this in quick sort and merge sort separately
 */
public class SortList {

    /**
     * 如果是array的in-place就是quick sort
     * merge sort需要额外空间保存中间结果
     * @param head
     *          the head of input un-sort list
     * @return the head node of sorted list
     */
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);

        ListNode right = mergeSort(middle.next);

        // 这样就相当于从middle的地方切下去了
        middle.next = null;
        ListNode left = mergeSort(head);

        return merge(left, right);
    }

    private ListNode findMiddle(ListNode head) {

        // 使用快慢指针，一定要起点的时候大家就指向了不一样的两个点，要不然会死循环
        ListNode slow = head;
        ListNode quick = head.next;

        while (quick != null || quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(0);
        ListNode head = dummyHead;

        while(left != null || right != null) {
            if (left.val < right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }

        if (left != null) {
            head.next = left;
        } else {
            head.next = right;
        }

        return dummyHead.next;
    }

    /**
     * In-place quick sort with the perfect choice of pivot would have O(logn) space complexity
     * The space is for recursion
     * @param head
     *          head of input linked list
     * @return the head of sorted list
     */
    public ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pivot = findMiddle(head);

        ListNode dummyLeft = new ListNode(0);
        ListNode dummyRight = new ListNode(0);
        ListNode dummyPivot = new ListNode(0);
        ListNode left = dummyLeft;
        ListNode right = dummyRight;
        ListNode pivotList = dummyPivot;

        while (head != null) {
            if (head.val < pivot.val) {
                left.next = head;
                left = left.next;
            } else if (head.val > pivot.val){
                right.next = head;
                right = right.next;
            } else {
                // 这个pivot list 的意义在于，如果是最坏情况，找到的pivot是极值那么所有的elements都会在同一边
                // 此时就没有分成O(n/2)，整个算法退化成O(n^2)，因此把所有值和pivot一样的node组成一个单独的list
                // 最后直接做concatenate就好
                pivotList.next = head;
                pivotList = pivotList.next;
            }

            head = head.next;
        }

        // Remember to set next list node to be null
        // 这样才可以实现断开的目的
        left.next = null;
        right.next = null;
        pivotList.next = null;

        return concatenate (quickSort(dummyLeft.next), dummyPivot.next, quickSort(dummyRight.next));
    }

    private ListNode concatenate(ListNode leftHead, ListNode pivot, ListNode rightHead) {
        ListNode dummyHead = new ListNode(0);
        ListNode pointer = dummyHead;

        while (leftHead != null) {
            pointer.next = leftHead;
            leftHead = leftHead.next;
            pointer = pointer.next;
        }

        while (pivot != null) {
            pointer.next = pivot;
            pivot = pivot.next;
            pointer = pointer.next;
        }

        pointer.next = rightHead;

        return dummyHead.next;
    }
}
