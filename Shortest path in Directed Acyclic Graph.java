


//User function Template for Java
class Pair{
    int first, second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {

    private void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int vis[], Stack<Integer> st){
        vis[node] = 1;
        for(int i = 0; i < adj.get(node).size(); i++){
            int v = adj.get(node).get(i).first;
            if(vis[v] == 0){
                topoSort(v, adj, vis, st);
            }
        }
        st.add(node);
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i = 0; i < N; i++){
		    ArrayList<Pair> temp = new ArrayList<>();
		    adj.add(temp);
		}
		
		for(int i = 0; i < M; i++){
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int wt = edges[i][2];
		    adj.get(u).add(new Pair(v, wt));
		}
		int vis[] = new int[N];
		Stack<Integer> st = new Stack<>();
		for(int i = 0; i < N; i++){
		    if(vis[i] == 0){
		        topoSort(i, adj, vis, st);
		    }
		}
		
		int dist[] = new int[N];
		for(int i = 0; i < N; i++){
		    dist[i] = (int) (1e9);
		}
// 		Arrays.fill(dist, 1000000);
		dist[0] = 0;
		while(!st.isEmpty()){
		    int node = st.peek();
		    st.pop();
		    
		    for(int i = 0; i < adj.get(node).size(); i++){
		        int v = adj.get(node).get(i).first;
		        int wt = adj.get(node).get(i).second;
		        
		        if(dist[node] + wt < dist[v]){
		            dist[v] = wt + dist[node];
		        }
		    }
		}
		for(int i = 0; i < N; i++){
		    if(dist[i] >= 1000000) dist[i] = -1;
		}
		return dist;
	}
}
