/**
 * RSA -> Rotated Sorted Array
 * [4,5,1,2,3] target=5, return 1
 * [4,5,1,2,3] target=0, return -1
 */
public class SearchInRSA {
    public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0) {
            return -1;
        }

        int mid;
        int start = 0;
        int end = A.length - 1;

        while(start + 1 < end) {
            mid = start + (end - start) / 2;

            if(target == A[mid]) {
                return mid;
            }

            if(A[start] < A[mid]) {
                // When start < mid, 左边一定是升序
                if(target >= A[start] && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else { // 此时右边一定是升序
                if(target >= A[mid] && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if(A[start] == target) {
            return start;
        }
        if(A[end] == target) {
            return end;
        }
        return -1;
    }
}
