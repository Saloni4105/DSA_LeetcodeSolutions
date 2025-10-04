class Solution {

    public boolean topologicalSortCheck(ArrayList<ArrayList<Integer>> adj, int n, int indegree[])
    {
        Queue<Integer> q = new LinkedList<>();
        int count =0;

        //fill the queue:- push nodes with indegree 0
        for(int i=0; i<n; i++)
        {
            if(indegree[i] == 0)
            {
                count++;
                q.add(i);
            }
        }

        // bfs
        while(!q.isEmpty())
        {
            int u = q.remove();

            for(int v : adj.get(u))
            {
                indegree[v]--;
                if(indegree[v] == 0)
                {
                    count++;
                    q.add(v);
                }
            }
        }
        // visited all course return true
        return count == n;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = numCourses;
        int inDegree[] = new int[V];

        // build graph
        for(int i=0; i<V; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int v[] : prerequisites)
        {
            adj.get(v[1]).add(v[0]);
        }

        // Calculate inDegree
        for(int i=0; i<V; i++)
        {
            for(int v : adj.get(i))
            {
                inDegree[v]++;
            }
        }

        return topologicalSortCheck(adj, V, inDegree);
    }
}