class Solution {

    static class Pair implements Comparable<Pair>
    {
        int v; 
        int cost;

        public Pair(int v, int cost)
        {
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Pair p2)
        {
            return this.cost - p2.cost;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int V = points.length;
        for(int i=0; i<V; i++)
        {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
    for (int j = i + 1; j < V; j++) {
        int wt = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
        adj.get(i).add(new Pair(j, wt));
        adj.get(j).add(new Pair(i, wt));
    }
}
        return PrimsAlgo(adj, V);
    }

    public int PrimsAlgo(ArrayList<ArrayList<Pair>> adj, int V)
    {
        boolean vis[] = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int finalCost = 0;

        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();
            if(vis[curr.v]) continue;

            vis[curr.v] = true;
            finalCost += curr.cost;
             
             for(Pair neighbor : adj.get(curr.v))
             {
                if(!vis[neighbor.v])
                {
                    pq.add(new Pair(neighbor.v, neighbor.cost));
                }
             }
        }
        return finalCost;
    }
}