class Solution {
    public int maxArea(int[] height) {
        
        ArrayList<Integer> heightList = new ArrayList<>();
        for(int h : height){
            heightList.add(h);
        }

        return storeWater(heightList);
    }

    public static int storeWater(ArrayList<Integer> height){

        int maxwater = 0;
        int lp =0;
        int rp = height.size() -1;

        while(lp < rp){

            int ht = Math.min(height.get(lp),height.get(rp));
            int width = rp -lp;

            int currWater = ht*width;
            maxwater = Math.max(maxwater,currWater);

            if(height.get(lp) < height.get(rp)){
                lp++;
            }
            else{
                rp--;
            }
        }
        return maxwater;
    }
}