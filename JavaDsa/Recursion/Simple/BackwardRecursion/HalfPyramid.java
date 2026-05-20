
 //still not understood , difficult in unwinding...
 package Simple.BackwardRecursion;
public class HalfPyramid {
    
   static void print(int n){
    if(n==0){
        return;
    }
     print(n-1);
  printStarsInRow(n, 1);
 
 
 System.out.println();
   }
   static void printStarsInRow(int row,int col){
    if(col>row){
        return;
    }
   
    printStarsInRow(row, col+1);
     System.out.print("*");
   }
   public static void main(String[] args) {
    print(6);
   }

}
