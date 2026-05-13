#include<iostream>
#include<vector>
using namespace std;
void solve(vector<vector<int>>  &board,vector<char> &path,int n,int row,int col){
    if(board[row][col]==0){
        return;
    }
if(row==n-1 && col==n-1){
    for(int i=0;i<path.size();i++){
        cout<<path[i];
    }
    cout<<endl;
    
    return;
}

if(board[row][col]>=1){
    for(int i=1;i<=board[row][col];i++){
        if(col+i<n){
            int count=i;
            while(count>0){
        path.push_back('R');
        count--;
            }
        solve(board,path,n,row,col+i);
         int count1=i;
            while(count1>0){
        path.pop_back();
        count1--;
            }
        }
        if(row+i<n){
               int count=i;
            while(count>0){
        path.push_back('D');
        count--;
            }
        solve(board,path,n,row+i,col);
        int count1=i;
            while(count1>0){
        path.pop_back();
        count1--;
            }
        }
    }
}


}
int main(){
    vector<vector<int>> board={ 
  {1, 2, 0},
  {1, 1, 0},
  {1, 1, 1}
};
vector<char> path;
int size=board.size();
solve(board,path,size,0,0);
    return 0;
}