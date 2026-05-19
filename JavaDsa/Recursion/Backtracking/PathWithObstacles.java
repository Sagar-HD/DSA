package Backtracking;

public class PathWithObstacles {
    static void printAllPaths(int[][] maze,int row,int col,String path, boolean[][] visited){
  
    if(row>=maze.length || col>=maze[0].length || row<0 || col<0 ||visited[row][col] ){
        return;
    }
      if(row==maze.length-1 && col==maze[0].length-1){
        System.out.println(path);
        return;
    }
    if(maze[row][col]==1){
return;
    }
       visited[row][col]=true;
       printAllPaths(maze, row-1, col, path+"U",visited);
       printAllPaths(maze, row, col+1, path+"R",visited);
       printAllPaths(maze, row+1, col, path+"D",visited);
       printAllPaths(maze, row, col-1, path+"L",visited);
       visited[row][col]=false;
}
    public static void main(String[] args) {
         int[][] maze={
            {0,0,0},
            {0,1,0},
            {0,0,0}

         };
        boolean[][] visited=new boolean[maze.length][maze[0].length];
        printAllPaths(maze, 0, 0, "",visited);
    }
}
