#include<iostream>
#include<vector>
using namespace std;
bool isSafe(int row,int col, vector<vector<string>> &board,int n){
     // check column
    for(int i = 0; i < row; i++) {
        if(board[i][col] == "Q") return false;
    }

    // check upper-left diagonal
    for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
        if(board[i][j] == "Q") return false;
    }

    // check upper-right diagonal
    for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
        if(board[i][j] == "Q") return false;
    }

    return true; // safe to place queen
}
void nqueen( vector<vector<string>> &board,int row,int n){
if (row==n){
for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
        cout<<board[i][j];
    }
    cout<<endl;
}
return;
}
for(int col=0;col<n;col++){
    if(isSafe(row,col,board,n)){
board[row][col]="Q";
nqueen(board,row+1,n);
board[row][col]=".";
    }
}
}
int main(){
    vector<vector<string>> board(4,vector<string>(4,"."));
    nqueen(board,0,4);
    return  0;
}