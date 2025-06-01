class Solution{

    int longest;
    String longestPalindrome;

    public String longestPalindrome(String s){

        longest = 0;
        longestPalindrome = "";

        for(int i=0; i<s.length(); ++i){

            isPalindromeMid(s, i);
        }

        return longestPalindrome;
    }


    private int isPalindromeMid(String s, int mid){

        return Math.max(getLongestPalindrome(s, mid-1, mid+1), getLongestPalindrome(s, mid,
         mid+1));
    }


    private int getLongestPalindrome(String s, int l, int r){

        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){

            --l;
            ++r;
        }

        int curr = (r-l) -1;

        if(curr > longest){
            longest = curr;
            longestPalindrome = s.substring(l+1, r);
        }

        return curr;
    }
}

    