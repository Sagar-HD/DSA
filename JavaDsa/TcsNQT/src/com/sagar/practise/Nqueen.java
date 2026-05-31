package com.sagar.practise;

import java.util.Scanner;

public class Nqueen {
    static boolean isPossible(char[][] board,int row,int col){
        for(int j=0;j<board.length;j++){
            if(board[row][j]=='Q'){
                return false;
            }
        }
        for(int j=0;j<board.length;j++){
            if(board[j][col]=='Q'){
                return false;
            }
        }

        return true;
    }
    static void solve(char[][] board,int row,int col){
        if(row>=board.length){
            return;
        }
        for(int j=0;j<board[0].length;j++) {
            if (isPossible(board, row, j)) {
                board[row][col] = 'Q';
                solve(board, row + 1, j);
                board[row][col]='.';

            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a number" );
        int n=sc.nextInt();
        char[][] arr=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]='.';
            }
        }
        solve(arr,0,0);

    }
}
