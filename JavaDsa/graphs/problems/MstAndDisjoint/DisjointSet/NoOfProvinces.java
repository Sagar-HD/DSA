package DisjointSet;


public class NoOfProvinces {
    public static void main(String[] args) {
          int vertices=7;
        int[][]edges={
            {0,1},
            {1,2},
            {2,3},
            {4,5},
           

        };
        DisjointSet dsj=new DisjointSet(vertices);
        for(int  i=0;i<edges.length;i++){
            dsj.unionBySize(edges[i][0], edges[i][1]);
        }
        int provinces=0;
        for(int i=0;i<vertices;i++){
            if(dsj.getUltimateParent(i)==i){
                provinces++;
            }
        }
        System.out.println(provinces);
    }
    
}
