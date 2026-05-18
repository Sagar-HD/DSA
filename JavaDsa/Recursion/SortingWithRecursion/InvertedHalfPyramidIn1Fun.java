package SortingWithRecursion;

public class InvertedHalfPyramidIn1Fun { 
    public static void printInOneFun(int n,int row,int col){
if(row==0){
    return;
}
if(col<row){
         System.out.print("*");
       printInOneFun(n, row, col+1);
         
}
else{
    System.out.println();
    printInOneFun(n, row-1, 0);
    
}
   }
    public static void main(String[] args) {
           printInOneFun(6, 6, 0);
    }
}
