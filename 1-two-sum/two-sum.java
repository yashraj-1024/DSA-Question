class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int []ans = new int[2];

        for(int i=0; i<nums.length; i++){

            int currEle = nums[i];
            int remainingSum = target - currEle;

            if(map.containsKey(remainingSum)){

              ans[0] =  map.get(remainingSum);
              ans[1] = i;

              return ans;
            }

            map.put(currEle, i);
        }

        return ans;
    }
}