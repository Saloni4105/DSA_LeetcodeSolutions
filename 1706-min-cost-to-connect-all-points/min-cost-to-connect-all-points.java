import java.util.*;

class Solution {
    
    int[] parent;
    int[] rank;
    
    // Find with path compression
    int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }
    
    // Union by rank
    void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        
        if (xParent == yParent) 
            return;
        
        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
    
    // Kruskal’s algorithm
    int kruskal(List<int[]> edges) {
        int sum = 0;
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            int parentU = find(u);
            int parentV = find(v);
            
            if (parentU != parentV) {
                union(u, v);
                sum += wt;
            }
        }
        
        return sum;
    }
    
    // Main function
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        parent = new int[V];
        rank = new int[V];
        
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        List<int[]> edges = new ArrayList<>();
        
        // Build all edges with their Manhattan distances
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                
                int d = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                edges.add(new int[]{i, j, d});
            }
        }
        
        // Sort edges by weight (distance)
        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        
        // Apply Kruskal’s algorithm
        return kruskal(edges);
    }
}
