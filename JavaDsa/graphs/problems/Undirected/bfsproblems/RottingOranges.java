package graphs.problems.Undirected.bfsproblems;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
   static class Pair{
        int row;
        int col;
        int time;
        public Pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }

    static int timeTaken(int[][] grid,int[] delRow,int[] delCol){
        Queue<Pair> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int maxTimeTaken=0;
        int freshCount=0;
        int nowMadeRottenCount=0;
        boolean[][] visited=new boolean[m][n];
        //copying all data to copy of grid bcs we dont want to manipluate given input
        int[][] gridCopy=new int[m][n];
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                gridCopy[row][col]=grid[row][col];

            }
        }

        //first adding all rotten oranges to queue
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(gridCopy[row][col]==2){
                    q.offer(new Pair(row, col, 0));
                    visited[row][col]=true;

                }
                else if(gridCopy[row][col]==1){
                    freshCount++;
                }

            }
        }
        while(!q.isEmpty()){
            Pair curNode=q.poll();
            int curRow=curNode.row;
            int curCol=curNode.col;
            int curTime=curNode.time;
            maxTimeTaken=Math.max(maxTimeTaken, curTime);
           

              //this could have been i<delCol.length doesnt matter bcs both must be same length
            for(int i=0;i<delRow.length;i++){
              
                int neighbourRow=curRow+delRow[i];
                int neighbourCol=curCol+delCol[i];
                //if neighbour row col is in grid boundry and if it not empty and if its not visited and its rotten then only traverse
                //no need to check not rotten bcs if its rotten it would have been visited , visited initially when we add all rotted or any time after that
                if(isValid(neighbourRow, neighbourCol, gridCopy,visited)){
                   
                    nowMadeRottenCount++;
                    gridCopy[neighbourRow][neighbourCol]=2;
                    visited[neighbourRow][neighbourCol]=true;
                    q.offer(new Pair(neighbourRow, neighbourCol, curTime+1));
                  
                }
                


            }


        }
        if(freshCount==nowMadeRottenCount){
            return maxTimeTaken;
        }
        System.out.println("couldnt rot all fresh oranges");
        System.out.println("total fresh oranges originally :"+freshCount);
        System.out.println("no of oranges got rotted :"+nowMadeRottenCount);
        return -1;
       
        
    }

static boolean isValid(int row,int col,int[][] grid,boolean[][] visited){
       System.out.println("checking validity for "+row+" "+col);
       boolean valid=(row>=0&&row<grid.length)&&(col>=0&&col<grid[0].length)&&!visited[row][col]&&grid[row][col]!=0;
       System.out.println("validation :"+valid);
    return (row>=0&&row<grid.length)&&(col>=0&&col<grid[0].length)&&!visited[row][col]&&grid[row][col]!=0;
}
    public static void main(String[] args) {
        //0 represents empty cell
        //1 is fresh orange
        //2 is rotten orange
        int[][] basket={
            {0,1,1,1,1},
            {0,1,2,2,2},
            {0,0,0,0,0},
            {1,1,1,0,0}

        };
        int[] delRow={-1,+1,0,0};
        int[] delCol={0,0,+1,-1};
        System.out.println(timeTaken(basket, delRow, delCol));
        
    }
    
}
