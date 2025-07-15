class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfs(graph, 0, path, res);
        return res;

    }


    public void dfs(int graph[][], int src, List<Integer> path, List<List<Integer>> res ){

        if(src == graph.length-1){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=0; i<graph[src].length; i++){

            int neigh = graph[src][i];
            path.add(neigh);

            dfs(graph, neigh, path, res);

            path.remove(path.size()-1);
        }

    }
}