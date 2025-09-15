class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
       
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();

        // find min differnece
        for(int i=0; i<arr.length-1; i++)
        {
            int diff = arr[i+1] - arr[i];
            minDiff = Math.min(minDiff, diff);
        }
        

        // Collect all pairs with that diff
        for(int i=0; i<arr.length-1; i++)
        {
            if(arr[i+1] - arr[i] == minDiff)
            {
                result.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return result;
    }
    
}