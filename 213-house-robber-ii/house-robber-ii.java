class Solution {
    public int rec(int i, int nums[], int n, int dp[]){

        if(i >= n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int take = nums[i] + rec(i+2 , nums, n, dp);
        int notTake = rec(i+1, nums, n, dp);

        int ans = Math.max(take, notTake);
        dp[i] = ans;

        return ans;
    }
    public int rob(int[] nums) {
        
        int n = nums.length;

        int dp1[] = new int[n];
        int dp2[] = new int[n];


        for(int i=0; i<n; i++){
            dp1[i] = -1;
            dp2[i] = -1;
        }

        return Math.max(nums[0] + rec(2, nums, n-1, dp1) ,  
                               rec(1,nums, n, dp2));   
        
    }
}