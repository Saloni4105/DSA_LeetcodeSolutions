import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> result = new HashMap<>();
        
        // count frequencies
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
           result.put(num, result.getOrDefault(num, 0) + 1);
        }
        
        // find the number with frequency 1
        for (int i = 0; i < nums.length; i++) {
            if (result.get(nums[i]) == 1) {
                return nums[i];
            }
        }
        return -1; // just in case
    }
}
