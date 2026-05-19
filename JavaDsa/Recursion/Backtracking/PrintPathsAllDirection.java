package Backtracking;

public class PrintPathsAllDirection {
static void printAllPaths(int n,int row,int col,String path, boolean[][] visited){
  
    if(row>=n || col>=n || row<0 || col<0 ||visited[row][col] ){
        return;
    }
      if(row==n-1 && col==n-1){
        System.out.println(path);
        return;
    }
       visited[row][col]=true;
       printAllPaths(n, row-1, col, path+"U",visited);
       printAllPaths(n, row, col+1, path+"R",visited);
       printAllPaths(n, row+1, col+1, path+"Dg",visited);//Diagonal
       printAllPaths(n, row+1, col, path+"D",visited);
       printAllPaths(n, row, col-1, path+"L",visited);
       visited[row][col]=false;
}
    public static void main(String[] args) {
        int n=3;
        boolean[][] visited=new boolean[n][n];
        printAllPaths(3, 0, 0, "",visited);



    }
}