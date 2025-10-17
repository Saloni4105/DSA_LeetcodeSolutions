class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //T.C : O(n^2)
        //S.C : O(1)
         // If less than 3 elements, no triplet possible
        if(nums.length < 3)
        {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // Sort array for two-pointer approach

        for(int i=0; i < nums.length; i++)
        {
             // Skip duplicate elements to avoid repeated triplets
            if( i != 0 && nums[i] == nums[i-1])
            {
                continue;
            }
            // Find two numbers whose sum = -nums[i]
            twoSum(nums, i+1, res, -nums[i]);
        }
        return res;
    }

    private void twoSum(int nums[], int k, List<List<Integer>> res, int target)
    {
        int i =k, j = nums.length - 1;

        while(i < j)
        {
            if(nums[i] + nums[j] > target)
            {
                j--;
            }
            else if(nums[i] + nums[j] < target)
            {
                i++;
            }else{
                res.add(Arrays.asList(-target, nums[i], nums[j]));

                // Skip duplicates for both pointers
                while(i < j && nums[i] == nums[i+1])
                {
                    i++;
                }
                while(i < j && nums[j] == nums[j-1])
                {
                    j--;
                }

                i++;
                j--;
            }
        }
    }
}