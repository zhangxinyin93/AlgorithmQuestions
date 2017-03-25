import java.util.ArrayList;

/**
 * Given [1,2,3] which represents 123, return [1,2,4].
 * Given [9,9,9] which represents 999, return [1,0,0,0].
 * Given non-negative number represented as an array of digits
 */
public class PlusOne {

    public int[] plusOne (int[] digits) {
        ArrayList<Integer> array = new ArrayList<>();

        int sum = digits[digits.length - 1] + 1;
        int digit = sum % 10;
        int carry = sum / 10;
        array.add(digit);

        for (int i = digits.length - 2; i >= 0; i--) {
            sum = digits[i] + carry;
            digit = sum % 10;
            carry = sum / 10;
            array.add(digit);
        }

        if (carry != 0) {
            array.add(carry);
        }

        int[] plus = new int[array.size()];

        // TODO: if there is a better way to represent index when do reverse way rather than absolute value
        for (int i = array.size() - 1; i >= 0; i--) {
            plus[Math.abs(i - array.size() + 1)] = array.get(i);
        }

        return plus;
    }
}
