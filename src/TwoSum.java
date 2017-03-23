import java.util.HashMap;

/**
 * Given [2,7,11,15] target 9
 * Exactly one solution
 * return index + 1, and index 1 < index 2
 */
public class TwoSum {
    // Version1 Stupid Algorithm
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        if(numbers.length == 0) {
            return numbers;
        }
        HashMap<Integer,Integer> allNumbers = new HashMap<Integer,Integer>();
        int[] answer = new int[2];
        for(int i = 0; i < numbers.length; i++) {
            allNumbers.put(numbers[i],i);
        }
        for(int i = 0; i < numbers.length; i++) {
            int subTarget = target - numbers[i];
            if(allNumbers.containsKey(subTarget)) {
                int subTargetIndex = allNumbers.get(subTarget);
                if(subTargetIndex == i) {
                    continue;
                }
                answer[0] = Math.min(i,subTargetIndex) + 1;
                answer[1] = Math.max(i,subTargetIndex) + 1;
                break;
            }
        }
        return answer;
    }

    // Version 2 This is Genius
    public int[] twoSumVersion2 (int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                int[] result = {map.get(numbers[i]) + 1, i + 1};
                return result;
            }
            map.put(target - numbers[i], i);
        }

        int[] result = {};
        return result;
    }
}
