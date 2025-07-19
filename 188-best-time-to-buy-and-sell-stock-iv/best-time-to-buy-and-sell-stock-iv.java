class Solution {
    // 123 same code.

    public int rec(int i, int buy,int prices[], int n, int dp[][][], int txn, int k){

        if(txn == k || i == n){
            return 0;
        }
        if(dp[i][buy][txn] != -1){
            return dp[i][buy][txn];
        }

        int ans =0;
        if(buy == 0){
            int skip = rec(i+1, 0, prices, n, dp,txn, k);
            int take = -prices[i] + rec(i+1, 1, prices, n, dp, txn, k);

            ans = Math.max(skip, take);
        }
        else{
            int skip = rec(i+1, 1, prices, n, dp,txn, k);
            int sell = prices[i] + rec(i+1,0, prices,n, dp, txn+1, k);

            ans = Math.max(skip, sell);

        }

        dp[i][buy][txn] = ans;
        return ans;
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int txn =0;

        int dp[][][] = new int[n][2][k];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                for(int z =0 ; z<k; z++){
                    dp[i][j][z] =-1;
                }
            }
        }

        return rec(0,0,prices, n, dp, txn, k);
    }
}