package Backtracking;

public class SudokuSolver {
    static void solve(char[][] board,int row,int col){
        if(row==9){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }
        if(col>8){
            solve(board, row+1, 0);
            return;
        }

        if(board[row][col]=='.'){
            for(int i=1;i<10;i++){
                char value=(char)(i + '0');
                if(isValid(board,row,col,value)){
                    board[row][col]=value;
                    solve(board, row, col+1);
                    board[row][col]='.';
                }
            }

        }else{
            solve(board, row, col+1);
        }

    }
    static boolean isValid(char[][] board,int row,int col,char value){
        //row check
        for(int i=0;i<board.length;i++){
            if(board[i][col]==value){
                return false;
            }
        }
        //col check
         for(int i=0;i<board[0].length;i++){
            if(board[row][i]==value){
                return false;
            }
        }
        //3*3 grid check
           int startRow = (row / 3) * 3;
          int startCol = (col / 3) * 3;

    for (int i = startRow; i < startRow + 3; i++) {
        for (int j = startCol; j < startCol + 3; j++) {
            if (board[i][j] == value) {
                return false;
            }
        }
    }
        return true;
    }
    public static void main(String[] args) {
           char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
solve(board, 0, 0);
    }
    
}
