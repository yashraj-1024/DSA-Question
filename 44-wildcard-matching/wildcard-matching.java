class Solution {
    public boolean isMatch(String s, String p) {
        
        int i=0, j=0, star =-1, match = -1;

        while(i<s.length()){

            if(j< p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){

                i++;
                j++;
            }

            else if(j < p.length() && p.charAt(j) == '*'){

                star = j++;
                match = i;
            }

            else if(star != -1){
                
                j = star+1;
                i = ++match;
            }

            else {
                return false;
            }
        }

        while(j < p.length() && p.charAt(j) == '*')
            j++;

        return i == s.length() && j == p.length();
    }
}