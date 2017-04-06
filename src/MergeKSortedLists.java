import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * [2->4->null,
 * null,
 * -1->null]
 * @return [-1->2->4->null]
 */
public class MergeKSortedLists {

    public ListNode mergeByHeap(List<ListNode> lists) {
        if(lists == null || lists.size() == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(int i = 0; i < lists.size(); i++) {
            ListNode head = lists.get(i);
            while(head != null) {
                minHeap.add(head);
                head = head.next;
            }
        }
        ListNode mergedHead = new ListNode(0);
        ListNode dummy = mergedHead;
        while(!minHeap.isEmpty()) {
            mergedHead.next = minHeap.remove();
            mergedHead = mergedHead.next;
        }
        return dummy.next;
    }

    /**
     * Using Divided and Conquer to solve this
     * @param lists
     *          Lists of head of sorted lists
     * @return merged head of sorted lists
     */
    public ListNode dividAndConquer(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        return mergeKListsHelper(lists, 0 ,lists.size() - 1);
    }

    private ListNode mergeKListsHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }

        // Divided
        int mid = start + (end - start) / 2;

        // Conquer
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                pointer.next = left;
                left = left.next;
            } else {
                pointer.next = right;
                right = right.next;
            }
        }

        if (left != null) {
            pointer.next = left;
        } else {
            pointer.next = right;
        }

        return dummy.next;
    }
}
