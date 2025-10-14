class Solution {
    // merge intervals -leetcode 56
    public int[][] merge(int [][] intervals)
    {
        int n= intervals.length;
        if (n == 0) return new int[0][];

        Arrays.sort(intervals, (a,b) ->Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for(int i=1; i<n; i++)
        {
             int[] last = res.get(res.size() - 1);
            if(intervals[i][0] < last[1]){
                last[1] = Math.max(last[1], intervals[i][1]);
            }else{
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {

        // Edge case: no rectangles
        if (rectangles.length == 0) return false; 

        List<int[]> hor = new ArrayList<>();
        List<int[]> ver = new ArrayList<>();

        for(int coord[] : rectangles)
        {
            int x1 = coord[0];
            int y1 = coord[1];
            int x2 = coord[2];
            int y2 = coord[3];

            hor.add(new int[]{x1, x2});
            ver.add(new int[]{y1, y2});
        }
        int[][] horArray = hor.toArray(new int[hor.size()][]);
        int[][] verArray = ver.toArray(new int[ver.size()][]);

        int[][] res1 = merge(horArray);
        if(res1.length >= 3)
        {
            return true;
        }

        int[][] res2 = merge(verArray);
        return res2.length >= 3;
    }
}