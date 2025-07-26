class Solution {
    public static void rec(int i, String digits, String mp[], String res, List<String> ans){
        if( i == digits.length()){
            ans.add(res);
            return;
        }

        char ch = digits.charAt(i);
        int nums = ch - '0';

        String st = mp[nums];
        for(int j=0; j<st.length(); j++){

            rec(i+1, digits,mp, res + st.charAt(j), ans);
        }
    }

    public List<String> letterCombinations(String digits) {
        
        List<String> ans = new ArrayList<>();

        if(digits.length() == 0){
            return ans;
        }

        String mp[] = { "", "", "abc", "def","ghi","jkl","mno","pqrs", "tuv", "wxyz"};

        rec(0, digits, mp, "", ans);

        return ans;

    }
}