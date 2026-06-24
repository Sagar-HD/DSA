package graphs.problems.Undirected.generalTraversalProblems;

public class FloodFill {

//this is dfs u can use bfs also
    static void fill(int[][] image,int row,int col,boolean[][] visited,int fillValue,int sourceValue){
        visited[row][col]=true;
        image[row][col]=fillValue;
        
        //for top
        int neighbourRow=row-1;
        int neighbourCol=col;
        if(isValid(neighbourRow, neighbourCol, image,visited,sourceValue) ){
            fill(image, neighbourRow, neighbourCol, visited, fillValue, sourceValue);
        }
        //for right
        neighbourRow=row;
        neighbourCol=col+1;
          if(isValid(neighbourRow, neighbourCol, image,visited,sourceValue) ){
            fill(image, neighbourRow, neighbourCol, visited, fillValue, sourceValue);
        }
         //for left
        neighbourRow=row;
        neighbourCol=col-1;
          if(isValid(neighbourRow, neighbourCol, image,visited,sourceValue) ){
            fill(image, neighbourRow, neighbourCol, visited, fillValue, sourceValue);
        }
         //for down
        neighbourRow=row+1;
        neighbourCol=col;
          if(isValid(neighbourRow, neighbourCol, image,visited,sourceValue) ){
            fill(image, neighbourRow, neighbourCol, visited, fillValue, sourceValue);
        }
        
        
        


    }
    static boolean isValid(int row,int col,int[][] image,boolean[][] visited,int sourceValue){
        return (row>=0&&row<image.length)&&(col>=0 && col<image[0].length)&&(!visited[row][col]) && image[row][col]==sourceValue;

    }
    public static void main(String[] args) {
        int[][] image={
            {2,3,2,2},
            {2,2,2,3},
            {3,2,3,3},
            {0,1,2,2}
        };
        boolean[][] visited=new boolean[image.length][image[0].length];
         int fillValue=8;
         fill(image, 0, 0, visited, fillValue,image[0][0]);
         for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
         }



    }
    
}
