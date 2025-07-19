class Solution {
    public static int licPath(int [][]mat, int [][]dp, int i, int j, int n, int m){
        if(i > n || j >m || i<0 || j<0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = 1;

        if(i+1< n && mat[i][j] < mat[i+1][j]){
            ans = Math.max(ans, 1+ licPath(mat, dp, i+1, j, n, m));
        }
        if(j+1< m && mat[i][j] < mat[i][j+1]){
            ans = Math.max(ans, 1+ licPath(mat, dp, i, j+1, n, m));
        }
        if(j-1 >= 0 && mat[i][j] < mat[i][j-1]){
            ans = Math.max(ans, 1+ licPath(mat, dp, i, j-1, n, m));
        }
        if(i-1 >= 0 && mat[i][j] < mat[i-1][j]){
            ans = Math.max(ans, 1+ licPath(mat, dp, i-1, j, n, m));
        }

        return dp[i][j] = ans;
    }
    public int longestIncreasingPath(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans = Math.max(ans,  licPath(matrix, dp, i,j,n,m));
            }
        }

        return ans;
    }
}