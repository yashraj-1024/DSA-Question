class Solution {
    // 122 same code.
    public int rec(int i, int prices[], int buy, int dp[][]){
        
        if( i >= prices.length){
            return 0;
        }
        if(dp[i][buy] != -1){
            return dp[i][buy];
        }
        int ans =0;
        
        if(buy == 0){
            int notBuy = rec(i+1, prices, 0, dp);
            int take = -prices[i] + rec(i+1, prices, 1, dp);
            
            ans = Math.max(notBuy, take);
        }
        else{
            
            int notSell = rec(i+1, prices, 1, dp);
            int sell = prices[i] + rec(i+2, prices, 0, dp);
            
            ans = Math.max(notSell, sell);
        }
        
        dp[i][buy] = ans;
        return ans;
    }
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int i =0, buy =0;
        
        int dp[][] = new int[n][2];
        for(int k=0; k<n; k++){
            for(int j=0; j<2; j++){
                
                dp[k][j] = -1;
            } 
        }
        
        return rec(i, prices, buy, dp);
    }
}