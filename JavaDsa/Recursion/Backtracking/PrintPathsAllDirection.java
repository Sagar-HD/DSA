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
//most imprtant to understand this when asked to find one valid answer
//trying all possibilities but when found one returning
static boolean printOnePath(int n,int row,int col,String path, boolean[][] visited){
  
    if(row>=n || col>=n || row<0 || col<0 ||visited[row][col] ){
        return false;
    }
      if(row==n-1 && col==n-1){
        System.out.println(path);
        return true;
    }
       visited[row][col]=true;
     if(printOnePath(n, row-1, col, path+"U",visited)){
        return true;
     }
     
     if(printOnePath(n, row, col+1, path+"R",visited)){
        return true;
     }
     if(printOnePath(n, row+1, col+1, path+"Dg",visited)){
        //Diagonal
        return true;
     }
     
     if(printOnePath(n, row+1, col, path+"D",visited)){
        return true;
     }
     if(printOnePath(n, row, col-1, path+"L",visited)){
        return true;
     }
       visited[row][col]=false;
       return false;
}
    public static void main(String[] args) {
        int n=3;
        boolean[][] visited=new boolean[n][n];
        printAllPaths(3, 0, 0, "",visited);
        System.out.println("One valid Path");
        printOnePath(3, 0, 0, "",visited);



    }
}