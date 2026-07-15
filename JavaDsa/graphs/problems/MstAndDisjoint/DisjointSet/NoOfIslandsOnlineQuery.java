package DisjointSet;

import java.util.ArrayList;

/**
 * NoOfIslandsOnlineQuery
 */
public class NoOfIslandsOnlineQuery {
    static ArrayList<Integer> getIslandsInQuery(int rowsCount,int colsCount,int[][] onlineQueries){
      ArrayList<Integer> islandsOfQueries=new ArrayList<>();
      DisjointSet dsj=new DisjointSet(rowsCount*colsCount);
      boolean[][] visited=new boolean[rowsCount][colsCount];
      int isLandsCount=0;
      int[] delRow={0,0,1,-1};
        int[] delCol={-1,1,0,0};
      for(int i=0;i<onlineQueries.length;i++){
        int row=onlineQueries[i][0];
        int col=onlineQueries[i][1];

        if(!visited[row][col]){

            visited[row][col]=true;
            isLandsCount++;

            for(int j=0;j<delRow.length;j++){

                int adjRow=row+delRow[j];
                int adjCol=col+delCol[j];
                if(isValid(adjRow, adjCol, rowsCount, colsCount) && visited[adjRow][adjCol]){
                    int curNode=getNodeNumber(row, col, colsCount);
                    int adjNode=getNodeNumber(adjRow, adjCol, colsCount);
                    if(!dsj.isConnected(curNode, adjNode)){

                        dsj.unionBySize(curNode, adjNode);
                        isLandsCount--;


                    }



                }
              

            }

 



        }
         islandsOfQueries.add(isLandsCount);



      }
      return islandsOfQueries;
    }

    static boolean isValid(int row,int col,int rowsCount,int colsCount){
        return (row>=0 && row<rowsCount) && (col>=0 && col<colsCount);
    }
    static int getNodeNumber(int row,int col,int colsCount){
        //0 based indexing
        return (colsCount*row)+col;
    }
    public static void main(String[] args) {
        int n=4;
        int m=5;
        int[][] onlineQueries={
            {0,0},
            {1,1},
            {1,0},
            {0,4},
            {1,3},
            {1,4},
            {3,2},
            {2,2},
            {1,2}

        };
        ArrayList<Integer> ans=getIslandsInQuery(n, m, onlineQueries);
        System.out.println(ans);
    }
}