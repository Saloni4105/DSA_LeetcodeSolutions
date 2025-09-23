class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]); // undirected
        }

        boolean visited[] = new boolean[n];

        // start dfs from source
        return hasPath(graph,source, destination, visited);
    }

    public boolean hasPath(List<List<Integer>> graph, int source, int destination, boolean visited[])
    {
        if(source == destination)
        {
            return true;
        }
        visited[source] = true;

        // Explore all neighbours
         for (int neighbor : graph.get(source)) {
            if (!visited[neighbor]) {
                if (hasPath(graph, neighbor, destination, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}