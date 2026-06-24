package graphs.problems.generalTraversalProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NoOfDistinctIslands {
    // we know to find no of islands
    // to find distinct we should any how store its shape
    // there are two known ways one is cordinates and other is movement direcction
    // while traversing like Up down
    // these 2 can tell shapes of island
    // these work only when the source node will be same while traversing , we go
    // top down left to right always so this is maintained
    // another condition is while traversing we should move in same order of
    // directions for all islands , this is also maintained we dont change order of
    // moving
    // this can be solved using dfs or bfs just need to traverse from same starting
    // point and same direction for all islands

    // in this sollution ill use cordinates to store shape bcs its a new learning
    // using directions is easy one we can use string to store shape of island
    // represent like "UDRL"
    // I don't care where the island is.
    // I only care about how its cells are arranged.





    //subracting the base from all nodes is like 
    //imagine having a graph sheet and u place a ball in middle 
    //its just like moving the graph sheet top left order to balls top left corner thats it
    //by this where may be the ball inside graph location doesnt matter but it gives us the shape

    static class Pair{
        int row;
         int col;
         public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
    }
    static ArrayList<String> bfs(int[][] grid,int row,int col,boolean[][] visited,int[] delRow,int[] delCol){
        Queue<Pair> q=new LinkedList<>();
        ArrayList<String> islandShape=new ArrayList<>();
        visited[row][col]=true;
        //just for readability
        int baseRow=row;
        int baseCol=col;
        q.offer(new Pair(row, col));
        islandShape.add(getCordString(row-baseRow, col-baseCol));
      
        
        while(!q.isEmpty()){
        Pair curNode=q.poll();
        int curRow=curNode.row;
        int curCol=curNode.col;
        for(int i=0;i<delRow.length;i++){
            int neighbourRow=curRow+delRow[i];
            int neighbourCol=curCol+delCol[i];
            if(isValid(neighbourRow, neighbourCol, grid) && grid[neighbourRow][neighbourCol]==1 && !visited[neighbourRow][neighbourCol]){
                visited[neighbourRow][neighbourCol]=true;
                q.add(new Pair(neighbourRow, neighbourCol));
                islandShape.add(getCordString(neighbourRow-baseRow, neighbourCol-baseCol));

            }

        }
        }
        return islandShape;

    }
    static String getCordString(int row,int col){
        return row+" "+col;
    }
    static boolean isValid(int row,int col,int[][]grid){
        return (row>=0&&row<grid.length)&&(col>=0&&col<grid[0].length);

    }


    static int getDistinctIslandsCount(int[][] grid){
        HashSet<ArrayList<String>> set=new HashSet<>();
        boolean[][] visited=new boolean[grid.length][grid[0].length];
       int[] delRow={0,0,-1,+1};
       int[] delCol={+1,-1,0,0};

        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col]==1&&!visited[row][col]){
                   ArrayList<String> islandShape= bfs(grid, row, col, visited,delRow,delCol);
                   set.add(islandShape);
                }

            }
        }
        


System.out.println(set);
return set.size();

    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 0, 0, 1, 1 },
                { 0, 1, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0 },
                { 0, 0, 0, 0, 1, 1 }
        };
        System.out.println(getDistinctIslandsCount(grid));
    }

}
