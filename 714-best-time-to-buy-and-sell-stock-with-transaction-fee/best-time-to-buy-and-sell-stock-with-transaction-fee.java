class Solution {

     // same code  122 .
    public int help(int prices[], int index, int buy, int fee, int dp[][]){

        if(index == prices.length){
            return 0;
        }

        if(dp[index][buy] != -1){
            return dp[index][buy];
        }
        int action = 0;
        if(buy == 1){
            
            int pick = help(prices, index+1, 0, fee, dp) - prices[index];
            int not_pick = help(prices, index+1, buy, fee, dp);

            action = Math.max(pick , not_pick);
        }
        else{

            int sell = prices[index] - fee + help(prices, index+1, 
                                                   1, fee, dp);
            int not_sell = help(prices, index+1, buy, fee, dp);

            action = Math.max(sell , not_sell);

        }

        return dp[index][buy] = action;
    }
    public int maxProfit(int[] prices, int fee) {
        
        int dp[][] = new int[prices.length][2];

        for(int [] a : dp){
            Arrays.fill(a, -1);
        }

        return help(prices, 0, 1, fee, dp); 
    }
}