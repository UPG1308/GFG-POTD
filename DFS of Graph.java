
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean vis[] = new boolean[V];
        return dfs(0, vis, ans , adj);
        
    }
    
    public ArrayList<Integer> dfs(Integer node, boolean vis[], ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj){
        ans.add(node);
        vis[node] = true;
        for(Integer it: adj.get(node)){
            if(!vis[it])
                // vis[it] = true;
                dfs(it, vis, ans, adj);
        }
        return ans;
    }
}
