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
    public ListNode mergeKList(List<ListNode> lists) {
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
        ListNode mergedHead = minHeap.remove();
        ListNode dummy = mergedHead;
        while(!minHeap.isEmpty()) {
            mergedHead.next = minHeap.remove();
            mergedHead = mergedHead.next;
        }
        return dummy;
    }
}
