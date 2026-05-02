#include<iostream>
#include<vector>
using namespace std;
bool issafe(vector<vector<char>>& board,int row,int col,int digit){
    for(int i=0;i<9;i++){
if(board[row][i]==digit){
    return false;
}
    }
      for(int i=0;i<9;i++){
if(board[i][col]==digit){
    return false;
}
    }
    int startrow=(row/3)*3;
    int startcol=(col/3)*3;
    for(int i=startrow;i<startrow+3;i++){
        for(int j=startcol;j<startcol+3;j++){
            if(board[i][j]==digit){
                return false;
            }
        }
    }
    return true;
}
bool solvesudoku(vector<vector<char>>& board,int row,int col) {
    if(row==9){
        return true;
    }
    int nextrow=row;
    int nextcol=col+1;
    if(col==8){
        nextrow=row+1;
        nextcol=0;
    }
    if(board[row][col]!='.'){
        if(solvesudoku(board,nextrow,nextcol)){
            return true;
        }
    }
 for(int i=1;i<=9;i++){
if(issafe(board,row,col,i+'0')){
    board[row][col]=i+'0';
    if(solvesudoku(board,nextrow,nextcol)){
        return true;
    }
    board[row][col]='.';
}

 }
return false;
    
}
int main(){
    vector<vector<char>> board;
  board = {
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
solvesudoku(board,0,0);
    for(int i=0;i<board.size();i++){
        for(int j=0;j<board[i].size();j++){
            cout<<board[i][j]<<" ";
        }
        cout<<endl;
    }   
    return 0;
}