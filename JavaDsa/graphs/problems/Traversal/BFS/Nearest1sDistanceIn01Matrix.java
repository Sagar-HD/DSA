package graphs.problems.Traversal.BFS;

import java.util.LinkedList;
import java.util.Queue;

//this question can be solved using two approaches
// first one which comes naturally is finding nearest 1 for all 0s using bfs on all sepeartely
//this works but time complexity is huge bfs for all 0s in matrix
//another approach is reverse engineering 
//we need nearest 1 for every 0s
//instead of going from 0 and finding its nearest 1 and then updating distance 
//we can go from 1 to all nearest 0s and update distance
//at first both seems as same
//in first approach we were searching but in second approach we start traversing level wise and update the first found value
//in search we find nearest 1 for a 0 and stop we dont want next distance 1 for it
// but in second approach we are not finding nearest 0 for 1 
//but We are propagating distances outward from all 1s.
//  keep on traversing every 0 will be visited once by the 1 that is reaching it first
//of its already visited we are not going to touch that 0 with any other 1 which has same distance or greater distance
//bcs we care about the shortest distance only it may be any path
// we are doing mutli source bfs adding all 1s togther in signle level as negbiours and starting bfs

public class Nearest1sDistanceIn01Matrix {
    // class to store node info
    static class Pair {

        int row;
        int col;
        int distance;

        public Pair(int row, int col, int distance) {

            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    // this method is running bfs for all 0s present in matrix and finding its
    // nearest 1 and replacing the distance
    // if its 1 then replacing it with 0
    // dont manipluate given matrix keep a copy for that and work else it effects
    // the future calls
    static int[][] replaceWithNearest1Distance(int[][] matrix) {
        // first iam creating a copy
        int[][] ansMatrix = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                ansMatrix[row][col] = matrix[row][col];
            }
        }
        for (int row = 0; row < ansMatrix.length; row++) {
            for (int col = 0; col < ansMatrix[0].length; col++) {

                if (ansMatrix[row][col] == 0) {
                    // if its 0s replace its ans with distance to its nearest 1
                    ansMatrix[row][col] = findMyNearest1(matrix, row, col);
                } else {
                    // if its 1 then it is only nearest so replace it with 0
                    ansMatrix[row][col] = 0;
                }

            }
        }
        return ansMatrix;

    }

    // this is method to find nearest distance from any 0 to 1

    static int findMyNearest1(int[][] matrix, int row, int col) {
        // assuming will not pass an empty matrix
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<Pair> q = new LinkedList<>();
        visited[row][col] = true;
        q.offer(new Pair(row, col, 0));
        while (!q.isEmpty()) {
            Pair curNode = q.poll();

            int curRow = curNode.row;
            int curCol = curNode.col;
            // if we found a 1 we return bcs in bfs it will be the shortest
            if (matrix[curRow][curCol] == 1) {
                return curNode.distance;
            }

            // all neighbours is up down left right , no diagonal
            int[] delRow = { -1, +1, 0, 0 };
            int[] delCol = { 0, 0, +1, -1 };
            for (int i = 0; i < delRow.length; i++) {
                int neighbourRow = curRow + delRow[i];
                int neighbourCol = curCol + delCol[i];
                // check calculated neighbour is valid position in matrix or not
                if (isValid(neighbourRow, neighbourCol, matrix)) {
                    if(!visited[neighbourRow][neighbourCol]){
                    visited[neighbourRow][neighbourCol]=true;
                    q.offer(new Pair(neighbourRow, neighbourCol, curNode.distance + 1));
                    }

                }
            }

        }

        // if there is no 1 is present in matrix // if its present it will be reachable
        return -1;
    }

    static boolean isValid(int row, int col, int[][] matrix) {
        return (row >= 0 && row < matrix.length) && col >= 0 && col < matrix[0].length;
    }



    //this is the second method which is explained above ,this is multiple sources bfs
    static int[][] replaceWithNearest1Distance2(int[][] matrix){
          // first iam creating a copy
        int[][] ansMatrix = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                ansMatrix[row][col] = matrix[row][col];
            }
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<Pair> q = new LinkedList<>();
        //addinf all 1s as source at level 0 to queue
          for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col]==1){
                   visited[row][col] = true;
                   q.offer(new Pair(row, col, 0));
                   ansMatrix[row][col]=0;
                }
            }
        }
          //do bfs of input matrix and changes in copy matrix
        while (!q.isEmpty()) {
           
            Pair curNode = q.poll();

            int curRow = curNode.row;
            int curCol = curNode.col;
            
            // if we found a 0 then change in ansMatrix with its nearest distance the first visit is always nearest and we visit only once
            if (matrix[curRow][curCol] == 0) {
                ansMatrix[curRow][curCol]=curNode.distance;
            }

            // all neighbours is up down left right , no diagonal
            int[] delRow = { -1, +1, 0, 0 };
            int[] delCol = { 0, 0, +1, -1 };
            for (int i = 0; i < delRow.length; i++) {
                int neighbourRow = curRow + delRow[i];
                int neighbourCol = curCol + delCol[i];
                // check calculated neighbour is valid position in matrix or not
                if (isValid(neighbourRow, neighbourCol, matrix)) {
                    if(!visited[neighbourRow][neighbourCol]){
                        visited[neighbourRow][neighbourCol]=true;
                    q.offer(new Pair(neighbourRow, neighbourCol, curNode.distance + 1));
                    }

                }
            }

        }

        return ansMatrix;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 0, 0, 1 },
                { 1, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 1, 0, 1, 0 },
        };
        int[][] ansMatrix = replaceWithNearest1Distance(matrix);

        for (int row = 0; row < ansMatrix.length; row++) {
            for (int col = 0; col < ansMatrix[0].length; col++) {
                System.out.print(ansMatrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println("second method");
         int[][] ansMatrix2 = replaceWithNearest1Distance2(matrix);

        for (int row = 0; row < ansMatrix2.length; row++) {
            for (int col = 0; col < ansMatrix2[0].length; col++) {
                System.out.print(ansMatrix2[row][col] + " ");
            }
            System.out.println();
        }
    }

}
