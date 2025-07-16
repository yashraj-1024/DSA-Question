class Solution {
    // Longest common sequence (LCS)
    public int f(int idx1, int idx2, int dp[][], int nums1[], int nums2[]){

        if(idx1 >= nums1.length || idx2 >= nums2.length){
            return 0;
        }

        if(dp[idx1][idx2] != -1){
            return dp[idx1][idx2];
        }

        int count =0;

        if(nums1[idx1] == nums2[idx2]){
            count = 1 + f(idx1+1, idx2+1, dp, nums1,nums2);
        }
        else{

            count = Math.max(f(idx1+1, idx2, dp, nums1, nums2),
             f(idx1, idx2+1, dp, nums1 , nums2));
        }

        return dp[idx1][idx2] = count;
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        int dp[][] = new int[nums1.length][nums2.length];

        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }

        return f(0,0,dp,nums1, nums2);
    }
}