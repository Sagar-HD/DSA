package graphs.problems.Directed.CycleDetection.EventualSafeState;

import java.util.ArrayList;

import graphs.representation.GraphBuildUtil;
//in stateInfo 0 is unvisited , 1 is visited , 2 is safe and -1 is unsafe
public class FindEventualSafeState2 {
    private static int[] giveSafeNodes(ArrayList<ArrayList<Integer>> adjList) {
        int[] stateInfo=new int[adjList.size()];//this is like visited array
      
        for(int i=0;i<adjList.size();i++){
            if(stateInfo[i]==0){
                isSafeNodeDfs(adjList,stateInfo,i);
            }
        }

        return stateInfo;
        
    
}
static boolean isSafeNodeDfs(ArrayList<ArrayList<Integer>> adjList,int[] stateInfo,int source){
    boolean isSafe=true;
    stateInfo[source]=1;
   
    for(int neighbour:adjList.get(source)){
        if(stateInfo[neighbour]==0){

            boolean isThisNeighBourSafe=(isSafeNodeDfs(adjList, stateInfo, neighbour));
            if(!isThisNeighBourSafe){
                isSafe=false;
            }

        }
        else{
            if(stateInfo[neighbour]==1 || stateInfo[neighbour]==-1){
            isSafe=false;
            }
           
            
        }
    }
  if(isSafe){
    stateInfo[source]=2;
    return true;
  }
  else{
     stateInfo[source]=-1;
    return false;
  }



}

public static void main(String[] args) {
    
      int v=12;
        int[][] edges={
            {0,1},
            {1,2},
            {2,3},
            {3,4},
            {4,6},
            {6,7},
            {4,5},
            {5,6},
            {8,1},
            {8,9},
            {9,10},
            {10,8},
            {11,9}

        };
        ArrayList<ArrayList<Integer>> adjList=GraphBuildUtil.buildDirectedGraph(v, edges);
        int[] safeNodes=giveSafeNodes(adjList);
        for(int i=0;i<safeNodes.length;i++){
            if(safeNodes[i]==2){
           System.out.println(i);
            }
        }


}


    
}