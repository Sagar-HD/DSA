package graphs.problems.ShortestPath.Weighted.Dijkstra.SourceToDestination.ShortestDistance;

import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static class Pair {
        private int row;
        private int col;
        private int absoluteDistance;

        public Pair(int row, int col, int absoluteDistance) {
            this.row = row;
            this.col = col;
            this.absoluteDistance = absoluteDistance;

        }

    }

    public static boolean isValid(int row, int col, int[][] grid) {
        return (row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length);
    }

    public static boolean isBetter(int parentAbsoulte, int curAbsolute, int neighbourOldAbsolute) {
        return Math.max(parentAbsoulte, curAbsolute) < neighbourOldAbsolute;

    }

    public static int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] minAbsoluteToReachThis = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                minAbsoluteToReachThis[row][col] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> q = new PriorityQueue<>(
                (pair1, pair2) -> Integer.compare(pair1.absoluteDistance, pair2.absoluteDistance));
        q.offer(new Pair(0, 0, 0));
        minAbsoluteToReachThis[0][0] = 0;
        int[] delRow = { 1, -1, 0, 0 };
        int[] delCol = { 0, 0, -1, +1 };
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int curRow = cur.row;
            int curCol = cur.col;
            int curMinAbsolute = cur.absoluteDistance;
            if (curRow == m - 1 && curCol == n - 1) {
                return curMinAbsolute;
            }
            for (int i = 0; i < delRow.length; i++) {
                int neighbourRow = curRow + delRow[i];
                int neighbourCol = curCol + delCol[i];

                if (isValid(neighbourRow, neighbourCol, heights)) {
                    int thisAbsolute = Math.abs(heights[neighbourRow][neighbourCol] - heights[curRow][curCol]);
                    if (isBetter(curMinAbsolute, thisAbsolute, minAbsoluteToReachThis[neighbourRow][neighbourCol])) {

                        minAbsoluteToReachThis[neighbourRow][neighbourCol] = Math.max(thisAbsolute, curMinAbsolute);
                        q.offer(new Pair(neighbourRow, neighbourCol,
                                minAbsoluteToReachThis[neighbourRow][neighbourCol]));
                    }

                }

            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] heights1={
            {1,2,2},
            {3,8,2},
            {5,3,5}

        };
        //second graph
        
       int[][] heights2={
            {1,2,3},
            {3,8,4},
            {5,3,5}

        };
        System.out.println(minimumEffortPath(heights1));
        System.out.println(minimumEffortPath(heights2));

    }

}