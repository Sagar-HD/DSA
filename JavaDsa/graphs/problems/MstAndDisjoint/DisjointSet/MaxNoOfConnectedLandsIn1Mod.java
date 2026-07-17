package DisjointSet;

import java.util.HashSet;

public class MaxNoOfConnectedLandsIn1Mod {
    //assuming grid passed is always n*n same no of cols and rows

    static int getMaxConnectedComponentBy1Mod(int[][] grid){
        int n=grid.length;
        int maxComp=0;
        DisjointSet dsj=new DisjointSet(n*n);
        int[] delRow={0,0,-1,1};
        int[] delCol={-1,1,0,0};

        //union in disjoint set for all connected components
        //doin union by size bcs we use size later
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1){
                    for(int i=0;i<delRow.length;i++){
                        int adjRow=row+delRow[i];
                        int adjCol=col+delCol[i];
                        if(isValid(adjRow, adjCol, n, n) && grid[adjRow][adjCol]==1){
                            int curNode=getNodeNumber(row, col, n);
                            int adjNode=getNodeNumber(adjRow, adjCol, n);
                            if(!dsj.isConnected(curNode, adjNode)){
                                dsj.unionBySize(curNode, adjNode);

                            }

                        }
                    }

                }


            }
        }
           //now checking all possibilties of 1 modification
           //here we dont actually connect and check just calculate wt happens if we connect
          for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0){
                    int compSum=0;
                     HashSet<Integer> unqieAdjParent=new HashSet<>();
                     for(int i=0;i<delRow.length;i++){
                        int adjRow=row+delRow[i];
                        int adjCol=col+delCol[i];

                        if(isValid(adjRow, adjCol, n, n) && grid[adjRow][adjCol]==1){
                           
                            int adjNode=getNodeNumber(adjRow, adjCol, n);

                            unqieAdjParent.add(dsj.getUltimateParent(adjNode));


                        }

                     }
                     //calculating sum 
                     for(int i : unqieAdjParent){
                        compSum+=dsj.getSizeOfComponent(i);
                     }
                     //adding that elem to comp sum
                     compSum=compSum+1;

           maxComp=Math.max(maxComp, compSum);



                }
            }
        }
        //at this stage we have max comp 
        //but wt if grid already had all as land no 0s 
        //in that case maxComp will be returned as 0 its not true so daftey check against that
        int edgeCompSum=0;
        edgeCompSum=dsj.getSizeOfComponent(0);
        maxComp=Math.max(maxComp, edgeCompSum);
       



        return maxComp;
    }
      static boolean isValid(int row,int col,int rowsCount,int colsCount){
        return (row>=0 && row<rowsCount) && (col>=0 && col<colsCount);
    }
    static int getNodeNumber(int row,int col,int colsCount){
        //0 based indexing
        return (colsCount*row)+col;
    }
    public static void main(String[] args) {

        int[][] grid={
            {1,1,0,1,1},
            {1,1,0,1,1},
            {0,1,0,1,0},
            {0,0,1,0,0},
            {1,1,1,1,1},
        };
        System.out.println(getMaxConnectedComponentBy1Mod(grid));
    }
    
}
