package Backtracking;

public class PrintPathsToEndByRightOrDown {
    //in this if it reaches wall down or right iam adding remining path
    static void printPaths(int n,int row,int col,String path){

        if(row==n-1 || col ==n-1){
                //this base condition because
            // when it reaches right corner or bottom corner it has only 1 valid path it must go in one direction only and that leads to answer
            //the other way will be out of bounds
           //we could have made base condition as row==n-1 && col==n-1 but simply increases recursive call
        if(row==n-1){
            int count=(n-1)-col;
            while(count>0){
                path=path+"R";
                count--;
            }
      
          
        }
        else{
            int count=(n-1)-row;
            while(count>0){
                path=path+"D";
                count--;
            }
            
           

        }
        System.out.println(path);
        return;
        }

        printPaths(n, row, col+1,path+"R");
        printPaths(n, row+1, col,path+"D");
     
    }
    

    //in this if it reaches down or right walls iam just stopping that side recursion from going forward


        static void printPaths2(int n,int row,int col,String path){
        
        
        if(row==n-1 && col ==n-1){
        System.out.println(path);
        return;
        }
        if(row>=n||col>=n){
            return;
        }
        /*
         we can do like this also // iam just not making the call itself instead of making call and stoping by base condition
         
        if(col<n){
             printPaths2(n, row, col+1,path+"R");
        }
        if(row<n){
          printPaths2(n, row+1, col,path+"D");
        }


        */
        printPaths2(n, row, col+1,path+"R");
        printPaths2(n, row+1, col,path+"D");
     
    }
    public static void main(String[] args) {
         int n=3;
       printPaths(n, 0, 0,"");
       System.out.println("////////");
       printPaths2(n, 0, 0, "");
    }
}
