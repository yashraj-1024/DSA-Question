class Solution {
    public void solveSudoku(char[][] board) {
        
        solve(board, 0,0);
    }

    public static boolean solve(char[][] board, int row, int col){

            if(row == board.length){
                return true;
            }

        int nextRow = row, nextCol = col+1;

        if(col+1 == board.length){
            nextRow = row+1;
            nextCol = 0;
        }

        if(board[row][col] != '.'){
            return solve(board, nextRow, nextCol);
        }

        for(char digit = '1'; digit <='9'; digit++){
            if(isSafe(board, row, col, digit)){
                board[row][col] = digit;

                if(solve(board, nextRow, nextCol)){
                    return true;
                }

                board[row][col] = '.';
            }
        }

        return false;
    }

    public static boolean isSafe(char[][]board, int row, int col, int digit){

        // row
        for(int i=0; i<board.length; i++){
            if(board[i][col] == digit){
                return false;
            }
        }

        // column

        for(int j=0; j<board.length; j++){
            if(board[row][j]  == digit){
                return false;
            }
        }

        // grid

        int sr = (row/3) * 3;
        int sc = (col/3) *3;

        // 3x3 grid

        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if(board[i][j] == digit){
                    return false;
                }
            }
        }

        return true;

    }
}