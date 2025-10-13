class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do
        {
            slow = nums[slow]; //move 1 step
            fast = nums[nums[fast]]; //move 2 step
        }while(slow != fast);

    //    Reset one pointer to start
        slow = nums[0];
        while(slow != fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        // Return the duplicate number (entry point of cycle)
        return slow;
    }
}