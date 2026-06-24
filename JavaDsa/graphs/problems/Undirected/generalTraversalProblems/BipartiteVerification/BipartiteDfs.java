package graphs.problems.Undirected.generalTraversalProblems.BipartiteVerification;

import java.util.ArrayList;

import graphs.representation.GraphBuildUtil;

public class BipartiteDfs {
    static boolean checkBipartiteOfGraph(ArrayList<ArrayList<Integer>> adjList){
        int[] color=new int[adjList.size()];
        //marking all nodes as not coloured
        for(int i=0;i<color.length;i++){
            color[i]=-1;
        }
        for(int node=0;node<adjList.size();node++){
            if(color[node]==-1){
                if(checkBipartiteOfComponent(adjList, color, node, 0)==false){
                    return false;
                }
            }
            
        }
        return true;
    }

    static boolean checkBipartiteOfComponent(ArrayList<ArrayList<Integer>> adjList, int[] color, int source,
            int startColor) {
        color[source] = startColor;
        for (int neighbour : adjList.get(source)) {
            if (color[neighbour] == -1) {

                int colorToNeigbour = startColor == 1 ? 0 : 1;

                if (checkBipartiteOfComponent(adjList, color, neighbour, colorToNeigbour) == false) {
                    return false;
                }

            } else {
                if (color[neighbour] == startColor) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int v = 6;
        // this has even cycle and can be divided into 2 group
        int[][] edges = {
                { 0, 1 },
                { 1, 2 },
                { 2, 3 },
                { 3, 0 },
                { 3, 4 },
                { 4, 5 }

        };

        ArrayList<ArrayList<Integer>> adjList = GraphBuildUtil.buildUndirectedGraph(v, edges);
        System.out.println(checkBipartiteOfGraph(adjList));

    }

}
