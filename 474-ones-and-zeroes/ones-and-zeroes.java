class Solution {
    static int count(String strs){
        int count = 0;
        for(int i=0; i<strs.length(); i++){
            if(strs.charAt(i) == '0'){
                count++;
            }
        }

        return count;
    }

    public static int rec(int i,int m, int n, String strs[], int dp[][][]){

        if(i == strs.length){
            return 0;
        }

        if(m ==0 && n==0){
            return 0;

        }

        if(dp[i][m][n] != -1){
            return dp[i][m][n];
        }

        int ans =0, take =0, notTake =0;

        int c0 = count(strs[i]);
        int c1 = strs[i].length() - c0;

        if(c0 >m || c1 > n){
             notTake = rec(i+1, m, n,strs, dp);
        }
        else{
             take = 1 + rec(i+1, m-c0, n-c1, strs, dp) ;
             notTake = rec(i+1, m, n, strs, dp);
        }

        ans = Math.max(take, notTake);

        dp[i][m][n] = ans;
        return ans;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        
        int size = strs.length;

        int dp[][][] = new int[size][m+1][n+1];

        for(int i=0; i<size; i++){
            for(int j=0; j<m+1; j++){
                for(int k=0; k<n+1; k++){

                    dp[i][j][k] = -1;
                }
            }
        }

        return rec(0,m,n,strs,dp); 
    }
}