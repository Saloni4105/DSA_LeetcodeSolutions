import java.util.*;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfs(graph, 0, graph.length-1, path, result);
        return result;
    }

    private void dfs(int[][] graph, int node, int target, List<Integer> path, List<List<Integer>> result) {
        if(node == target)
        {
            result.add(new ArrayList<>(path)); //add to list
            return;
        }

        for(int neigh : graph[node])
        {
            path.add(neigh);
            dfs(graph, neigh, target, path, result);
            path.remove(path.size()-1);
        }
    }
}
