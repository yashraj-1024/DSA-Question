class Solution {
    public int help(int []prices,int index, int buy, int dp[][]){

        if(index == prices.length){
            return 0;
        }
        if(dp[index][buy] != -1){
            return dp[index][buy];
        }
        int action =  0;
        if(buy == 1){
            int pick = help(prices, index+1, 0, dp) - prices[index];
            int notTake = help(prices, index+1, buy, dp);

            action = Math.max(pick, notTake);

        }
        else{

            int sell = prices[index] + help(prices, index+1, 1, dp);
            int notTake = help(prices, index+1, buy, dp);

            action = Math.max(sell, notTake);

        }

        return dp[index][buy] = action;
    }
    public int maxProfit(int[] prices) {
        
        int dp[][] = new int[prices.length][2];

        for(int[] a : dp){
            Arrays.fill(a, -1);
        }
        return help(prices, 0,1,dp);
    }
}