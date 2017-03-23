import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array numbers of n integer
 * e.g [-1,0,1,2,-1,-4】 return [[-1,0,1],[-1,-1,2]] must in non-descending order
 * @return : Find all unique triplets in the array which gives the sum of zero..
 */
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        if(numbers == null || numbers.length < 3) {
            return answer;
        }

        // 1. Sort->O(nlogn); We can use two pointers after sort
        Arrays.sort(numbers);

        // 2. TwoSum = -a
        // Time complexity->O(n^2), Space Complexity->O(1);
        for(int i = 0; i < numbers.length-2; i++) {
            // Skip duplicate
            if(i != 0 && numbers[i] == numbers[i-1]) {
                continue;
            }
            // The TwoSum target
            int target = 0 - numbers[i];
            // Find TwoSum, and construct two pointers
            int leftIndex = i+1;
            int rightIndex = numbers.length - 1;
            while(leftIndex < rightIndex) {
                // If we find the exactly two sum
                int currSum = numbers[leftIndex] + numbers[rightIndex];
                if(currSum == target) {
                    ArrayList<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(numbers[i]);
                    triplet.add(numbers[leftIndex]);
                    triplet.add(numbers[rightIndex]);
                    answer.add(triplet);

                    while(leftIndex < rightIndex && numbers[leftIndex] == numbers[leftIndex+1]) {
                        leftIndex++;
                    }
                    while(leftIndex < rightIndex && numbers[rightIndex] == numbers[rightIndex-1]) {
                        rightIndex--;
                    }
                    leftIndex++;
                    rightIndex--;
                }
                else if(currSum > target) {
                    rightIndex--;
                } else {
                    leftIndex++;
                }
            }
        }
        return answer;
    }
}
