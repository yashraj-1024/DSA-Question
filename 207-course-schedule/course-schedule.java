class Solution {

    static public boolean dfs(int src, boolean[] vis, List<List<Integer>> adj, Set<Integer> topSort){

        if(vis[src] == true){

            if(topSort.contains(src)) return false;

            else return true;
        }

        vis[src] = true;   // preorder
        for(int nbr : adj.get(src)){
            boolean cycle = dfs(nbr,vis,adj,topSort);

            if(cycle == true) return true;
        }

        topSort.add(src);       // postorder

        return false;
    }
    public boolean canFinish(int n, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());

            for(int [] edge : prerequisites){

                adj.get(edge[0]).add(edge[1]);
            }

                // (Maintain order of insertion)
            Set<Integer> topSort = new LinkedHashSet<>();
        
        boolean[] vis = new boolean[n];
        for(int src = 0; src < n; src++){

            if(vis[src] == false){
                boolean cycle = dfs(src, vis, adj, topSort);

                if(cycle == true)
                    return false;  // connect finish(cycle)
            }
        }

        return true;  // case finish all course.
    }
}