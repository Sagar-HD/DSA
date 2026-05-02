#include <iostream>
#include <vector>
#include <string>
using namespace std;


void solveMaze(vector<vector<int>> &maze, int n, int row , int col, vector<string> result) {
if(row<0||col<0||row>=n||col>=n||maze[row][col]==0){
    return;
}
if(row==n-1 && col==n-1){
    for(int i=0;i<result.size();i++){
        cout<<result[i];
    }
    result.clear();
    cout<<endl;
    return;
}
 maze[row][col]=0; // mark as visited
    // down
    result.push_back("D");
   
    solveMaze(maze,n,row+1,col,result);
   result.pop_back();
    
    // right
    result.push_back("R");
  
    solveMaze(maze,n,row,col+1,result);
    result.pop_back();
  
    // left
    result.push_back("L");  
    solveMaze(maze,n,row,col-1,result);
       result.pop_back();
    
    // up
    result.push_back("U");
 
    solveMaze(maze,n,row-1,col,result);
       result.pop_back();
        maze[row][col] = 1; // unmark after exploring all directions

}

int main() {
    int n = 4; // size of the maze
    vector<vector<int>> maze = {
    {1, 1, 0, 0},
    {1, 1, 1, 0},
    {0, 1, 1, 1},
    {0, 0, 1, 1}
    };
vector<string> result;
solveMaze(maze,n,0,0,result);

    return 0;
}
