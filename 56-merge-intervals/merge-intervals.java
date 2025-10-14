class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a , b) -> Integer.compare(a[0], b[0])); // Sort based on start point

        // Handle edge case: if input is empty, return an empty array.
        if (intervals.length == 0) return new int[0][];

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for(int i=1; i<intervals.length; i++)
        {
            int curr_start = intervals[i][0];
            int curr_end = intervals[i][1];

            // if no overlap
            if(curr_start > res.get(res.size()-1)[1])
            {
                res.add(intervals[i]);
            }else{
                // there is no overlap
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], curr_end);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}