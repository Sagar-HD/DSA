package Backtracking;

public class NoOfPathsByRightOrDown {
    static int noOfPaths(int n,int row,int col){
        if(row==n-1 || col ==n-1){
        
            //this base condition because
            // when it reaches right corner or bottom corner it has only 1 valid path it must go in one direction only and that leads to answer
            //the other way will be out of bounds
           //we could have made base condition as row==n-1 && col==n-1 but simply increases recursive call
    return 1;
        }
        int right=noOfPaths(n, row, col+1);
        int down=noOfPaths(n, row+1, col);
        return right+down;
    }
    public static void main(String[] args) {
        int n=3;
        System.out.println(noOfPaths(n, 0, 0));

    }
    
}
