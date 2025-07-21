class Solution {

    static class Pair{

        int r,c,t;

        public Pair(int r, int c, int t){
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        
        Queue<Pair> q = new ArrayDeque<>();
        int fresh = 0, maxTime = 0;

        for(int r =0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){

                if(grid[r][c] == 2){
                    q.add(new Pair(r,c,0));
                }

                else if(grid[r][c]== 1){
                    fresh++;
                }
            }
        }

        // top, bottom, left, right

        int[] dc = {-1,1,0,0};
        int[] dr = {0,0,-1,1};

        // multi-source BFS.

        while(q.size() > 0){
            Pair pair = q.remove();

            for(int d =0; d<dr.length; d++){
                int r = pair.r + dr[d];
                int c = pair.c + dc[d];

                if(r >= 0 && r< grid.length && c >= 0 
                && c < grid[0].length && grid[r][c] == 1){
                    q.add(new Pair(r, c, pair.t +1));
                    maxTime = pair.t + 1;
                
                grid[r][c] = 2;  // visited mark
                fresh--;
                }
            }
        }

        if(fresh > 0){
            return -1;
        }else{
            return maxTime;
        }

    }
}