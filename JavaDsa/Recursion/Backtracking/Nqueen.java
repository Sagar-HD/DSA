package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Nqueen {
static boolean isValid(char[][] board,int row,int col){
   
  
    // check column (above)
    for (int i = 0; i < row; i++) {
        if (board[i][col] == 'Q') {
            return false;
        }
    }

    // upper-left diagonal
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
        if (board[i][j] == 'Q') {
            return false;
        }
    }

    // upper-right diagonal
    for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
        if (board[i][j] == 'Q') {
            return false;
        }
    }

    return true;
}


    static void placeNQueen(char[][] board,int n,int row){
        if(row==n){
               for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }  
        System.out.println();
        return;
            
        }
        
        
     for(int k=0;k<board[0].length;k++){
if(isValid(board, row,k)){
        board[row][k]='Q';
        placeNQueen(board, n, row+1);
        board[row][k]='.';
}

     }


    }
       static int countNQueen(char[][] board,int n,int row){
        if(row==n){
        return 1;
        }
        
        int count=0;
     for(int k=0;k<board[0].length;k++){
if(isValid(board, row,k)){
        board[row][k]='Q';
        count=count+countNQueen(board, n, row+1);
        board[row][k]='.';
}

     }
return count;

    }
     static List<char[][]> returnNQueen(char[][] board,int n,int row){
       ArrayList<char[][]> ans=new ArrayList<>();
        if(row==n){
            ArrayList<char[][]> myAns=new ArrayList<>();
          char[][] copy=new char[n][n];
          for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                copy[i][j]=board[i][j];
            }
          }
           myAns.add(copy);
          return myAns;

        }
        
       
     for(int k=0;k<board[0].length;k++){
if(isValid(board, row,k)){
        board[row][k]='Q';
        ans.addAll(returnNQueen(board, n, row+1));
        board[row][k]='.';
}

     }
return ans;

    }
    public static void main(String[] args) {
        int n=4;
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        placeNQueen(board, n, 0);
     
        System.out.println("no of valid boards is :");
        System.out.println(countNQueen(board, n, 0));
           List<char[][]> ans=returnNQueen(board, n, 0);
           for(char[][] validBoard : ans){

         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(validBoard[i][j]+" ");
            }
            System.out.println("");
        }

 System.out.println("-------------");

           }
    }
    
}
