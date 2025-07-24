class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> allboard = new ArrayList<>();

        char[][] board = new char[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }

        queens(board, allboard, 0);
        return allboard;
    }

public void queens(char board[][], List<List<String>> allboard, int row){
    if(row == board.length){
        allboard.add(display(board));
        return;
    }

    for(int j=0; j<board.length; j++){

        if(isSafe(board,row, j)){
            board[row][j] = 'Q';
            queens(board, allboard, row+1);
            board[row][j] = '.';
        }
      }
  }

  public static boolean isSafe(char board[][], int row, int col){

    for(int i=0; i<row; i++){
        if(board[i][col] == 'Q'){
            return false;
        }
    }

    for(int i=row-1 , j= col-1; i>=0 && j>=0; i--,j--){
        if(board[i][j] == 'Q'){
            return false;
        }
    }

    for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){

        if(board[i][j] == 'Q'){
            return false;
        }
    }

    return true;
  }

  static List<String> display(char[][]board){
    List<String> result = new ArrayList<>();
    for(char []row : board){
        result.add(new String(row));
    }

    return result;
 }

}