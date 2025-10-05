class Solution {
    public boolean isBipartite(int[][] graph) {
        int V= graph.length;
       int color[] = new int[V];

        // initialize color array
        for(int i=0; i<V; i++)
        {
            color[i] = -1;
        }

         // check all components
        for(int i=0; i<V; i++)
        {
            if(color[i] == -1)
            {
                if(!dfs(graph, i, color, 1))
                {
                    return false;
                }
            }
        }
        return true;
    }

    // DFS
    public boolean dfs(int[][] graph, int curr, int color[], int currColor)
    {
        color[curr] = currColor;

        for(int v : graph[curr])
        {   // if neighbor has same color → not bipartite
            if(color[v] == color[curr])
            {
                return false;
            }
            // if uncolored, assign opposite color
            if(color[v] == -1)
            {
               int colorOfV = 1- currColor; 
               if(!dfs(graph, v, color, colorOfV))
               {
                return false;
               }
            }
        }
        return true;
    }
}