class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = numCourses;
        for(int i=0; i<V; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int edge[] : prerequisites)
        {
            adj.get(edge[1]).add(edge[0]);
        }

        int inDegree[] = new int[V];
        int count = 0;

        // Calculate inDegree
        for(int i=0; i<V; i++)
        {
            for(int v : adj.get(i))
            {
                inDegree[v]++;
            }
        }
        return topoLogicalSort(adj, V, inDegree);
    }

    public int[] topoLogicalSort(ArrayList<ArrayList<Integer>> adj, int V, int inDegree[])
    {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int count = 0;

        // fill queue
        for(int i=0; i<V; i++)
        {
            if(inDegree[i] == 0)
            {
                q.add(i);
            }
        }

        // bfs
        while(!q.isEmpty())
        {
            int curr = q.remove();
            res.add(curr);

            for(int neigh : adj.get(curr))
            {
                inDegree[neigh]--;
                if(inDegree[neigh] == 0)
                {
                    q.add(neigh);
                }
            }
        }

        // Check for cycle
        if(res.size() == V)
        {
            // convert to int[]
            int[] order = new int[V];
            for(int i =0; i<V; i++)
            {
                order[i] = res.get(i);
            }
            return order;
        }
        // cycle detected - return empty array
        return new int[0];
    }
}