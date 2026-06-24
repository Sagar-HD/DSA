package graphs.problems.Undirected.generalTraversalProblems;
//this problem is solved usinf dfs it could also been solved using multi source bfs
public class ReplaceBoundedOWithX {

    //this dfs reacbility rule is it must be '0' in any 4 direction up down and left right
    static void dfs(char[][] grid,boolean[][] visited,int row,int col,int[]delRow,int[] delCol){
        visited[row][col]=true;
        for(int i=0;i<delRow.length;i++){
            int neighbourRow=row+delRow[i];
            int neighbourCol=col+delCol[i];
            //if neighbour is valid
            if((neighbourRow>=0&&neighbourRow<grid.length)&&(neighbourCol>=0&&neighbourCol<grid[0].length)){
                //if its O and not visited,visit and do dfs
                if(grid[neighbourRow][neighbourCol]=='O'&&!visited[neighbourRow][neighbourCol]){
                    
                     dfs(grid, visited, neighbourRow, neighbourCol, delRow, delCol);

                }

            }

        }

    }
 
    

    static char[][] fill(char[][] grid){
        //copy of grid
        char[][] ansGrid=new char[grid.length][grid[0].length];
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                ansGrid[row][col]=grid[row][col];
            }
        }
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        //creating diretion arrays
        int[] delRow={0,0,-1,+1};
        int[] delCol={+1,-1,0,0};

        //top and bottom boundery O check and marking visited for all its connection using dfs , you can use bfs also doesnt matter just need to visit reachable
        for(int col=0;col<grid[0].length;col++){
            
            if(grid[0][col]=='O'){
                if(!visited[0][col]){
                    dfs(ansGrid, visited, 0, col, delRow, delCol);

                }

            }
            if(grid[grid.length-1][col]=='O'){
                if(!visited[grid.length-1][col]){
                    dfs(ansGrid, visited, grid.length-1, col, delRow, delCol);

                }

            }

        }
          //left and right boundery O check and marking visited
        for(int row=0;row<grid.length;row++){
            
            if(grid[row][0]=='O'){
                if(!visited[row][0]){
                      dfs(ansGrid, visited, row, 0, delRow, delCol);

                }

            }
            if(grid[row][grid[0].length-1]=='O'){
                if(!visited[row][grid[0].length-1]){
                      dfs(ansGrid, visited, row, grid[0].length-1, delRow, delCol);

                }

            }

        }
        //marking the remaining Os which are bounded and no contact to any boundary as X
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col]=='O'&&!visited[row][col]){
                    ansGrid[row][col]='X';
                }
            }
        }
        return ansGrid;
    }
    public static void main(String[] args) {
        char[][] grid={
            {'X','X','X','X','X'},
            {'X','O','O','X','O'},
            {'X','O','X','O','X'},
            {'X','X','X','O','X'},
        };
        char[][] ansGrid=fill(grid);
           for(int row=0;row<ansGrid.length;row++){
            for(int col=0;col<ansGrid[0].length;col++){
                System.out.print(ansGrid[row][col]+" ");
            }
            System.out.println();
        }

        
    }

    
}