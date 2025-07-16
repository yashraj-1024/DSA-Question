class Solution {
    public static void helper(int open, int close, String str, int n, List<String> ans){

        if(open == n && close == n)
        {
            ans.add(str);
            return;
        }

        if(open < n){
            helper(open+1, close, str + "(", n , ans);
        }
        if(close < open){
            helper(open, close+1, str + ")", n, ans);
        }
    }
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();
        
        helper(0,0, "", n, ans);
        return ans;
    }
}