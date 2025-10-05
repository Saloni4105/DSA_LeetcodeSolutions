class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int color[] = new int[V];

        for(int i=0; i<V; i++)
        {
            color[i] = -1;
        }
        for(int i=0; i<V; i++)
        {
            if(color[i] == -1)
            {
                if(!bfs(graph, i, color, 1))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bfs(int[][] graph, int curr, int color[], int currColor)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        color[curr] = currColor;

        while(!q.isEmpty())
        {
            int u = q.remove();

            for(int v : graph[u])
            {
                if(color[v] == color[u])
                {
                    return false;
                }
                if(color[v] == -1)
                {
                    color[v] = 1- color[u];
                    q.add(v);
                }
            }
        }
        return true;
    }
}