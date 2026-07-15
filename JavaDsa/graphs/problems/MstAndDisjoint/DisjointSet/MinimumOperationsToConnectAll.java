package DisjointSet;


public class MinimumOperationsToConnectAll {
    public static void main(String[] args) {
        int vertices=7;

        int[][]edges={
            {0,1},
            {1,2},
            {2,3},
            {4,5},
            {0,3},
            {1,3}
           

        };

        DisjointSet dsj=new DisjointSet(vertices);
        int extraEdges=0;
        for(int i=0;i<edges.length;i++){
            if(dsj.isConnected(edges[i][0],edges[i][1])){
                extraEdges++;
            }
            else{
                dsj.unionBySize(edges[i][0], edges[i][1]);
            }
        }
       int noOfProvinces=0;
       for(int i=0;i<vertices;i++){
        if(dsj.getUltimateParent(i)==i){
            noOfProvinces++;
        }
       }
       int requiredEdges=noOfProvinces-1;
       if(extraEdges>=requiredEdges){

        System.out.println(" minimum opertaions :"+requiredEdges);
       }
       else{
        System.out.println("not possible");
       }

        
    }
    
}
