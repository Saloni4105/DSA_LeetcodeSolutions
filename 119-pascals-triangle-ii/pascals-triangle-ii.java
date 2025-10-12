class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>>res = new ArrayList<>();

        for(int i=0; i <= rowIndex; i++)
        {
            List<Integer> row = new ArrayList<>();
            for(int j= 0; j<=i; j++)
            {
               if(j == 0 || j == i)
               {
                row.add(1);
               }
               else
               {
                    row.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
               } 
            }
            res.add(row);
        }
        return res.get(rowIndex);
    }
}