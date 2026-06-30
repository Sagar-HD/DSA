import java.util.*;
class Solution {
    public boolean isCycleExist(ArrayList<ArrayList<Integer>> adjList,boolean[] visited,boolean[] pathVisited,int node){
        visited[node]=true;
        pathVisited[node]=true;
        for(int neighbour:adjList.get(node)){
            if(!visited[neighbour]){

               if(isCycleExist(adjList,visited,pathVisited,neighbour)){
                return true;
               }

            }
            else if(pathVisited[neighbour]){
                return true;
            }
        }
      pathVisited[node]=false;
      return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        for(int row=0;row<prerequisites.length;row++){
            Integer fromEdge=prerequisites[row][0];
            Integer toEdge=prerequisites[row][1];
           adjList.get(fromEdge).add(toEdge);

        }
        boolean[] visited=new boolean[numCourses];
        boolean[] pathVisited=new boolean[numCourses];
        for(int node=0;node<numCourses;node++){
            if(isCycleExist(adjList,visited,pathVisited,node)){
                return false;
            }
        }
        
 return true;

    }
}