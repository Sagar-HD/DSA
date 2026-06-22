package graphs.representation;

import java.util.ArrayList;

public class AdjacencyListRepresentation {

    static class Pair{
        int value;
        int weight;
        public Pair(int value,int weight){
            this.value=value;
            this.weight=weight;

        }
    }
    public static void main(String[] args) {
        //n is no of nodes
        int n=3;
         

        //adjacency list of size n+1
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>(n+1);

         
        //for undirected graph
                //connection between 1 and 2
                adjList.get(1).add(2);
                adjList.get(2).add(1);
                //connection between 2 and 3
                adjList.get(2).add(3);
                adjList.get(3).add(2);


         //for directed graph
                //connection from 3 to 4
                adjList.get(3).add(4);
               
                 //connection from 4 to 5
                adjList.get(4).add(5);


       //for weighted graph instead of just storing value store pair of value and weight
        ArrayList<ArrayList<Pair>> adjListWeighted=new ArrayList<>(n+1);
        //undirected
        //connection between 1 and 2 with weight 3
        adjListWeighted.get(1).add(new Pair(2, 3));
        adjListWeighted.get(2).add(new Pair(1, 3));

        //directed
        //connection from 2 to 3 with weight 5
        adjListWeighted.get(2).add(new Pair(3, 5));



        
             




    }
    
}
