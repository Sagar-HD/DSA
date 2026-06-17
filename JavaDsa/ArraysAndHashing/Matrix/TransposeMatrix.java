package Matrix;

public class TransposeMatrix {
    static void print(int[][] mat){
        int m=mat.length;
        int n=mat[0].length;
          for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
           System.out.print(mat[i][j]+" ");
        }
        System.out.println();
    }

    
}
public static int[][] getTranspose(int[][] mat){
  int[][] ans=new int[mat[0].length][mat.length];
   int m=ans.length;
    int n=ans[0].length;
          for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
         ans[i][j]=mat[j][i];
        }
    }
  return ans;
}
public static void main(String[] args) {
    int m=3;
    int n=4;
    int[][] mat=new int[m][n];
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            mat[i][j]=i+j;
        }
    }
    print(mat);
    int[][] ans=getTranspose(mat);
    print(ans);
}



    
}
