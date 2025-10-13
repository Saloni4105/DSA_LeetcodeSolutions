class Solution {
    public void nextPermutation(int[] nums) {
        //  O(n), O(1)
        int n = nums.length;
        int i= n-1;

        // Step 1: Find the first index 'i' from the end where nums[i] > nums[i-1]
        for(; i > 0; i--)
        {
            if(nums[i] > nums[i-1])
            {
                break;
            }
        }

         // Step 2: If such an index exists
        if(i != 0)
        {
            int indx = i;
            // Step 3: Find the smallest number greater than nums[i-1] from the right
            for(int j=n-1; j >= i; j--)
            {
                if(nums[j] > nums[i-1])
                {
                    indx = j;
                    break;
                }
            }
            // Step 4: Swap nums[i-1] and nums[index]
            int temp = nums[i-1];
            nums[i-1] = nums[indx];
            nums[indx] = temp;
        }
        // Step 5: Reverse the part after position (i-1)
        reverse(nums, i, n-1);
    }

    // Helper method to reverse the array between two indices
    private void reverse(int nums[], int start, int end)
    {
        while(start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}