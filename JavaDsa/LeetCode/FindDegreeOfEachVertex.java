/*

Code
Testcase
Testcase
Test Result
3898. Find the Degree of Each Vertex
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given a 2D integer array matrix of size n x n representing the adjacency matrix of an undirected graph with n vertices labeled from 0 to n - 1.

matrix[i][j] = 1 indicates that there is an edge between vertices i and j.
matrix[i][j] = 0 indicates that there is no edge between vertices i and j.
The degree of a vertex is the number of edges connected to it.

Return an integer array ans of size n where ans[i] represents the degree of vertex i.
 */

class Solution {
    public int[] findDegrees(int[][] matrix) {
        int[] degree=new int[matrix.length];
        for(int row=0;row<matrix.length;row++){
             for(int col=0;col<matrix[0].length;col++){
                if(matrix[row][col]==1){
                    degree[row]++;
                    //any one node degree increse count 
                  
                }
             }

        }
return degree;
        
    }
}