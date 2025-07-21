class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character, Integer> fmap = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(fmap.containsKey(ch)){

                int currFre = fmap.get(ch);
                fmap.put(ch, currFre+1);
            }
            else{
                fmap.put(ch, 1);
            }
        }

        // getting all the key from maps.

        ArrayList<Character> keys = new ArrayList<>(fmap.keySet());

        PriorityQueue<Character> pq = new PriorityQueue<>((Character t, Character o ) -> {

            return fmap.get(o) - fmap.get(t);

            // o-t => bigger object -> higherPriority(maxHeap)
            // t-o => smaller object -> higherPriority(minHeap)
        });

        for(int i=0; i<keys.size(); i++){
            pq.add(keys.get(i));
        }

        StringBuilder sb = new StringBuilder();

        while(pq.size() > 0){
            char ch = pq.remove();
            int fre = fmap.get(ch);

            while(fre > 0){
                sb.append(ch);
                fre--;
            }
        }

        return sb.toString();
    }
}