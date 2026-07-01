class Solution {
    public boolean isValidSudoku(char[][] board) {
    HashSet<Character> set=new HashSet<>();
    HashSet<Character> set2=new HashSet<>();
    for(int row=0;row<board.length;row++){
           for(int col=0;col<board.length;col++){
            if(board[row][col]!='.'&&set.contains(board[row][col])){
                return false;
            }
            else{
                set.add(board[row][col]);
            }
             if(board[col][row]!='.'&&set2.contains(board[col][row])){
                return false;
            }
            else{
                set2.add(board[col][row]);
            }
         

    }
   set.clear();
   set2.clear();
        
    }
    
for (int boxRow = 0; boxRow < 9; boxRow += 3) {
    for (int boxCol = 0; boxCol < 9; boxCol += 3) {

        HashSet<Character> box = new HashSet<>();

        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {

                if (board[i][j] == '.') continue;

                if (box.contains(board[i][j])) {
                    return false;
                }

                box.add(board[i][j]);
            }
        }
    }
}

        return true;
        
    }
}