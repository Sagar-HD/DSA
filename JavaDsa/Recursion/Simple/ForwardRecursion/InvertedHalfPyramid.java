package Simple.ForwardRecursion;
public class InvertedHalfPyramid {

   static void print(int n){
    if(n==0){
        return;
    }
  printStarsInRow(n, 1);
  System.out.println();
  print(n-1);

   }
   static void printStarsInRow(int row,int col){
    if(col>row){
        return;
    }
    System.out.print("*");
    printStarsInRow(row, col+1);
   }
  

    public static void main(String[] args) {
         print(6);
     
    }
}