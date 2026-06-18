package Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
//just observe pattern and code wt it needs
//going right means we completed one row of starting so rowMin++
//going down means we completed ne column of end so colMax--
//going left means we completed another row at end so rowMax--
//going up means we completed another column from starting so colMin++
//do this repeatedly until both col and row are completed
//add boundary check before goinf left and up bcs prevoius right and down may completed all row or column 

    static List<Integer> getSpiral(int[][] mat){
        List<Integer> ans=new ArrayList<>();
        int colMin=0;
        int rowMin=0;
        int rowMax=mat.length-1;
        int colMax=mat[0].length-1;
        while(rowMin<=rowMax && colMin<=colMax){
            System.out.println("going right");
            for(int i=colMin;i<=colMax;i++){
                System.out.print(mat[rowMin][i]);
                ans.add(mat[rowMin][i]);
            }
              rowMin++;
            System.out.println();
            System.out.println("going down");
             for(int i=rowMin;i<=rowMax;i++){
                System.out.print(mat[i][colMax]);
                ans.add(mat[i][colMax]);
            }
          colMax--;
              System.out.println();
            if(rowMin<=rowMax){
             System.out.println("going left");

             for(int i=colMax;i>=colMin;i--){
                 System.out.print(mat[rowMax][i]);
                ans.add(mat[rowMax][i]);
            }
           rowMax--;
        }
        if(colMin<=colMax){
             System.out.println();
             System.out.println("going up");
              for(int i=rowMax;i>=rowMin;i--){
                  System.out.print(mat[i][colMin]);
                ans.add(mat[i][colMin]);
            }
            colMin++;
        }
           
        }
        return ans;
        
    }
    public static void main(String[] args) {
        int[][] mat={

            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
    List<Integer> ans=getSpiral(mat);
    System.out.println(ans);
        
    }
    
}
