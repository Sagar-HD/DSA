package graphs.problems.Traversal.BipartiteVerification;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import graphs.representation.GraphBuildUtil;
//we are coloring nodes as 0 and 1 
public class BipartiteBfs {

     static boolean checkBipartiteOfGraph(ArrayList<ArrayList<Integer>> adjList){
          int[] color=new int[adjList.size()];
        //this similar to visited array but stored colored or not , if color then which colour is also stored
        for(int i=0;i<adjList.size();i++){
            //marking all nodes as not coloured
            color[i]=-1;
        }
        for(int i=0;i<adjList.size();i++){
            if(color[i]==-1){
                if(checkBipartiteOfComponent(adjList, i, color)==false){
                     return false;
                }
            }
        }
        return true;

     }
    static boolean checkBipartiteOfComponent(ArrayList<ArrayList<Integer>> adjList,int source,int[] color){
        
        Queue<Integer> q=new LinkedList<>();
      
        //marking first node as 0 opposite is 1
        color[source]=0;
        q.offer(source);
        while(!q.isEmpty()){
            int curNode=q.poll();
            for(Integer neighnour:adjList.get(curNode)){
                if(color[neighnour]==-1){
                    color[neighnour]=color[curNode]==1?0:1;//giving opoosite color of to its neighbour
                    q.offer(neighnour);


                }
                else{
                    //if its already colred by any other path
                    //we check if color satisifies to be mt neighbour if not return false else continue
                    if(color[neighnour]==color[curNode]){
                        return false;
                    }
                }

            }

        }



       return true;
    }
    public static void main(String[] args) {
        int v=6;
        //this has even cycle and can be divided into 2 group
        int[][] edges={
            {0,1},
            {1,2},
            {2,3},
            {3,0},
            {3,4},
            {4,5}

        };

        ArrayList<ArrayList<Integer>> adjList=GraphBuildUtil.buildUndirectedGraph(v, edges);
        System.out.println(checkBipartiteOfGraph(adjList));
        
    }
    
}
