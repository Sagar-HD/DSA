package Backtracking;

public class NKnights {

static void placeNKnights(char[][] board,int noOfKnights,int row,int col){
if(noOfKnights==0){
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            System.out.print(board[i][j]+" ");

        }
        System.out.println();
    }
    System.out.println("-------------");
    return;
}

if(row==board.length){
    return;
}

if(col==board[0].length){
    placeNKnights(board, noOfKnights, row+1, 0);
    return;
}

if(isSafe(board,row,col)){
    board[row][col]='K';
    placeNKnights(board, noOfKnights-1, row, col+1);
     board[row][col]='.';
}
   placeNKnights(board, noOfKnights, row, col+1);

}

static boolean isSafe(char[][] board,int row,int col){
    if(isValid(board, row-2, col-1) ){
if(board[row-2][col-1]=='K'){
    return false;

}
    }
     if(isValid(board, row-2, col+1) ){
if(board[row-2][col+1]=='K'){
    return false;

}
    }
     if(isValid(board, row+2, col-1) ){
if(board[row+2][col-1]=='K'){
    return false;

}
    }
     if(isValid(board, row+2, col+1) ){
if(board[row+2][col+1]=='K'){
    return false;

}
    }
    return true;
}



static boolean isValid(char[][] board,int row,int col){
    if(row>=0 && col>=0 && row<board.length && col<board[0].length){
return true;
    }



        return false;
}
//         important**
//this version 2 enforces knights to placed in 1 per row so not valid
//so we must have condition based reccurive call when to move row and col
//we cant do because
//  There is no mechanism to:
//1 Place multiple knights in the same row
//2 Skip a row conditionally within the same decision branch



static void placeNKnightsVersion2(char[][] board,int noOfKnights,int row){
if(noOfKnights==0){
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            System.out.print(board[i][j]+" ");

        }
        System.out.println();
    }
    System.out.println("-------------");
    return;
}

if(row==board.length){
    return;
}
for(int col=0;col<board[0].length;col++){
    if(isSafe(board,row,col)){
    board[row][col]='K';
   placeNKnightsVersion2(board, noOfKnights-1, row+1);
     board[row][col]='.';
}



}




 

}


    public static void main(String[] args) {
        int n=4;
       char[][] board={
        {'.','.','.','.'},
        {'.','.','.','.'},
        {'.','.','.','.'},
        {'.','.','.','.'}
       };
       placeNKnights(board, n, 0, 0);
       System.out.println("one row one knight version ---");
       placeNKnightsVersion2(board, n, 0);
    }
    
}
