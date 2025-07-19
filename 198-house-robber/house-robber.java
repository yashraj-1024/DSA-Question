class Solution {
    public int rec(int i, int nums[], int n, int dp[]){

        if(i >= n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int ans =0;
        int take = nums[i] + rec(i+2, nums, n, dp);
        int notTake = rec(i+1, nums, n, dp);

        ans = Math.max(take, notTake);
        dp[i] = ans;

        return ans;
    }
    public int rob(int[] nums) {
        
        int n = nums.length;
        int dp[] = new int[n];

        for(int i=0; i<n; i++){
            dp[i] = -1;
        }

        return rec(0, nums, n, dp);
    }
}