class Solution {

    static boolean checkUsingBfs(int src, int graph[][], int color[]){

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src] = 0;

        while(q.isEmpty() == false){

            int curr = q.remove();
            int currCol = color[curr];

            for(int conn : graph[curr]){

                if(color[conn] == -1){

                    // if conn is not color.

                    color[conn] = 1 - currCol;
                    q.add(conn);
                }

                else{
                    // already colored.

                    if(currCol == color[conn]){
                        return false;
                    }
                }
            }
        }

        return true;
    }
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;

        int color[] = new int[n];

        for(int i=0; i<n; i++){
            color[i] =  -1;
        }

        for(int i=0; i<n; i++){

            if(color[i] == -1){
                boolean result = checkUsingBfs(i,graph,color);

            if(result == false){
                return false;
            }
        }
     }
        return true;
    }
}