package matrixSearch;

public class SearchInRowAndColSorted {
    static void search( int[][] matrix,int elem){
        int row=0;
        int col=matrix[0].length-1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==elem){
                System.out.println("row :"+row+" col:"+col);
                return;
            }
            else if(matrix[row][col]<elem){
                row++;
            }
            else{
                col--;
            }
        }
        System.out.println("not found");

    }
    public static void main(String[] args) {
        int[][] matrix={
       {1,34,45,76,84},
       {22,40,50,62,89},
       {32,42,53,54,90},
       {78,80,90,93,95}
        };
        int elem=53;
        search(matrix, elem);
        
    }
    
}
