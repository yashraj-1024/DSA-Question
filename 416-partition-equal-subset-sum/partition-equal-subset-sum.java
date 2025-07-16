class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i : nums){
            sum += i;
        }

        if(sum % 2 != 0){
            return false;
        }
        sum /= 2;

        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
            
            if(i == 0 || j ==0){
                dp[i][j] = false;
            }
            if(nums[i-1] > j){
                dp[i][j] = dp[i-1][j];
            }
            else if(nums[i-1] == j){
                dp[i][j] = true;
            }
            else{
                dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
            }
                
            }
        }

        return dp[n][sum];
    }
}