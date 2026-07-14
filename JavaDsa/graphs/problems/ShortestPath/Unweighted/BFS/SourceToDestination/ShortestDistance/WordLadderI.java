package graphs.problems.ShortestPath.Unweighted.BFS.SourceToDestination.ShortestDistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadderI {
    public static class Node{
        private String value;
        private int distance;
        public Node(String value,int distance){
            this.value=value;
            this.distance=distance;
        }
    }
       public static ArrayList<String> getNeighbours(String word,HashSet<String> wordList){
        ArrayList<String> neighbours=new ArrayList<>();
        int len=word.length();
    
        StringBuilder sb=new StringBuilder("");
         sb.append(word);
        for(int i=0;i<len;i++){
           
             for(int j=0;j<26;j++){
            
            char ch = (char) (j + 'a');
             sb.setCharAt(i,ch);
            
                 
                if(wordList.contains(sb.toString())){
                    
                 neighbours.add(sb.toString());
               
                }
                 sb.setLength(0);
                  sb.append(word);
             }
           
        }
        return neighbours;

    }
     public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordListSet=new HashSet<>(wordList);
        Queue<Node> q=new LinkedList<>();
        HashSet<String> visited=new HashSet<>();
        
        q.offer(new Node(beginWord,0));
        visited.add(beginWord);

        while(!q.isEmpty()){
            Node cur=q.poll();
            int curDistance=cur.distance;
            if(cur.value.equals(endWord)){
                return curDistance+1;
            }
            for(String neighbour:getNeighbours(cur.value,wordListSet)){
                if(!visited.contains(neighbour)){
                 visited.add(neighbour);
                q.offer(new Node(neighbour,curDistance+1));
                }
            }

      
        }
       
        return 0;
        
    }


    public static void main(String[] args) {
        String beginWord="hit";
        String[] wordArray={"hot","dot","dog","lot","log","cog"};
        String endWord="cog";
        List<String> wordList=Arrays.asList(wordArray);
        System.out.println(ladderLength(beginWord, endWord, wordList));
        
    }


    
}
