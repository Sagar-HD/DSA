package graphs.problems.ShortestPath.Unweighted.BFS.SourceToDestination.ShortestDistance;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static class Pair{
        private int row;
        private int col;
        private int level;
        public Pair(int row,int col,int level){
            this.row=row;
            this.col=col;
            this.level=level;

        }
    }
    public boolean isValid(int row,int col,int[][] grid){
        return (row>=0 && row<grid.length) && (col>=0 && col<grid[0].length) && (grid[row][col]==0);

    }
    public int shortestPathBinaryMatrix(int[][] grid) {
          if(grid[0][0]==1)return -1;
       
        int[] delRow={1,-1,0,0,+1,-1,+1,-1};
         int[] delCol={0,0,1,-1,+1,-1,-1,+1};
         boolean[][] visited=new boolean[grid.length][grid[0].length];
         Queue<Pair> q=new LinkedList<>();
         visited[0][0]=true;
         q.offer(new Pair(0,0,0));
         while(!q.isEmpty()){

            
           
            Pair cur=q.poll();
            int curRow=cur.row;
            int curCol=cur.col;
            int curDistance=cur.level;

            if(curRow==grid.length-1 && curCol==grid[0].length-1){
                return curDistance+1;
            }
            for(int i=0;i<delRow.length;i++){

                int neighbourRow=curRow+delRow[i];
                int neighbourCol=curCol+delCol[i];
                
                if(isValid(neighbourRow,neighbourCol,grid)&&!visited[neighbourRow][neighbourCol]){
                    visited[neighbourRow][neighbourCol]=true;
                    q.offer(new Pair(neighbourRow,neighbourCol,curDistance+1));
                }

            }
           

         }

     return -1;

    }
}