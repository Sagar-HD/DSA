package graphs.problems.generalTraversalProblems;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {
    static class Pair{
        int row;
        int col;
        public Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    static void bfs(int[][]grid,int[][]visited,int row,int col){
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(row, col));
        visited[row][col]=1;
        while (!q.isEmpty()) {
            Pair curNode=q.poll();
            int curRow=curNode.row;
            int curCol=curNode.col;
            //for all 8 direction row -1 to +1 varies and col also -1 to +1 varies from cur row and col
            for(int delRow=-1;delRow<=1;delRow++){
                for(int delCol=-1;delCol<=1;delCol++){
                    int neighbourRow=curRow+delRow;
                    int neighbourCol=curCol+delCol;
                    boolean validNeighbour=(neighbourRow>=0&&neighbourRow<grid.length)&&(neighbourCol>=0&&neighbourCol<grid[0].length);

                    if(validNeighbour && grid[neighbourRow][neighbourCol]==1 && visited[neighbourRow][neighbourCol]==0){
                        visited[neighbourRow][neighbourCol]=1;
                        q.offer(new Pair(neighbourRow, neighbourCol));
                    }

                }
            }

            
        }


    }


    static int getIslandsCount(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[][] visited=new int[m][n];
        int count=0;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1 && visited[row][col]==0){
                    count++;
                    //can do dfs also goal is to traverse and mark all reachable
                    bfs(grid,visited,row,col);


                }

            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid={
            {0,1,0,0},
            {0,1,0,1},
            {0,0,0,0},
            {1,0,1,1}
        };
System.out.println(getIslandsCount(grid));
        
    }
    
}
