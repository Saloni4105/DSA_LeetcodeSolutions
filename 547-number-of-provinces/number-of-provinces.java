class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        boolean vis[] = new boolean[n];
        int count =0;
        

        for(int i=0; i<n; i++)
        {
            if(!vis[i])
            {
                bfs(isConnected, i, vis);
                count++;
            }
        }
        return count;
    }

    void bfs(int [][] isConnected, int curr, boolean vis[])
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        vis[curr] = true;

        while(!q.isEmpty())
        {
            int node = q.remove();
            for(int j=0; j<isConnected.length; j++)
            {
                if(isConnected[node][j] == 1 && !vis[j])
                {
                    q.add(j);
                    vis[j]= true;
                }
            }
        }
    }
}