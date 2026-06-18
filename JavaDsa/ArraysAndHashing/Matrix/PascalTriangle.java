package Matrix;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    static List<List<Integer>> getPascle(int n){
        List<List<Integer>> ans=new ArrayList<>();
        int i=0;
        while(i<=n){
            List<Integer> row=new ArrayList<>();
            row.add(1);
            if(i>0){
                 List<Integer> lastRow=ans.get(ans.size()-1);
                for(int j=1;j<i;j++){
                   
                    row.add(lastRow.get(j)+lastRow.get(j-1));
                }


                row.add(1);
            }
        
         ans.add(row);
          i++;

        }
        return ans;
    }

    public static void main(String[] args) {
       /*
       1
       11
       121
       1331
       14641
       
       
       */
      List<List<Integer>> ans=getPascle(5);
      for(List<Integer> list:ans){
        System.out.println(list);
      }
        
    }
}