/**
 * Given an array and a value, remove all occurrences of that value in place and return the new length.
 * The order of elements can be changed, and the elements after the new length don't matter.
 * e.g.Given an array [0,4,4,0,0,2,4,4], value=4
 * return 4 and front four elements of the array is [0,0,0,2]
 */
public class RemoveElement {

    /**
     * Typical approach is using two pointers
     * And our purpose is to move lower element who equals target to higher place
     * no matter what is on higher position.
     * In the end, we only need to return the number of valid elements so we don't
     * actually need to do swap between lower and higher.
     */
    public int remove(int[] array, int element) {
        if (array.length == 0) {
            return 0;
        }

        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            if (array[low] == element) {
                array[low] = array[high];
                high--;
            } else {
                low++;
            }
        }

        return array[high] == element? high : high + 1;
    }
}
