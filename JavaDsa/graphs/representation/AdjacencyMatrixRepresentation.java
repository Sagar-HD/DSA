package graphs.representation;

public class AdjacencyMatrixRepresentation {
    public static void main(String[] args) {
        //given n is number of nodes
        int n=3;
        //given m is no of edges
        int m=3;
        //matrox of size n+1 to store data
        int[][] adjMatrix=new int[n+1][n+1];

        //for undirected
                    //connection between 1 and 2 
                    adjMatrix[1][2]=1;
                    adjMatrix[2][1]=1;
                    //connection between 2 and 3
                    adjMatrix[2][3]=1;
                    adjMatrix[3][2]=1;




        //for directed graph
                    //connection from 3 to 4
                    adjMatrix[3][4]=1;
                    //connection from 4 to 5
                    adjMatrix[4][5]=1;


      // for weighted just add weight in place of 1



    }
    
}
