package graphs.problems.ShortestPath.General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
752. Open the Lock
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.


Example 1:

Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation: 
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
Example 2:

Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation: We can turn the last wheel in reverse to move from "0000" -> "0009".
Example 3:

Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation: We cannot reach the target without getting stuck.


*/
public class OpenTheLock {
    static class Pair{
       private String node;
        private int distance;
        public Pair(String node, int distance) {
            this.node = node;
            this.distance = distance;
        }
        
    }
     public static int openLock(String[] deadends, String target,String source) {
        HashSet<String> de=new HashSet<>(Arrays.asList(deadends));
        Queue<Pair> q=new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        if(de.contains(source)){
            return -1;
        }
        visited.add(source);
        q.offer(new Pair(source, 0));
        
        while(!q.isEmpty()){
            
            Pair cur=q.poll();
            String curNode=cur.node;
            int curDistance=cur.distance;
           
            if(curNode.equals(target)){
                return cur.distance;
            }


            for(String neighbour : getNeighbours(curNode)){
                //we get only valid neigbhours so bfs on all
                //but only thing is it must not be in dead end and must not be visited
                //if its dead end or already visited just ignore just for other neighbours 
                if(!de.contains(neighbour) && !visited.contains(neighbour)){
                    visited.add(neighbour);
                q.offer(new Pair(neighbour, curDistance+1));
                }

            }
        }

        
return -1;
        
    }
    static ArrayList<String> getNeighbours(String node){
        ArrayList<String> neighbours=new ArrayList<>();
        char[] wheels=node.toCharArray();
        //overal 8 possible neigbhuors +1 and -1 for all 4 wheels
        for(int wheel=0;wheel<4;wheel++){
            int num=wheels[wheel]-'0';
            //2 possible neighbours +1 and -1 for this wheel 
            int prev= (num + 9) % 10;
            int next=(num +1)%10;
            String neighbour1=node.substring(0,wheel)+(prev)+node.substring(wheel+1);
             String neighbour2=node.substring(0,wheel)+(next)+node.substring(wheel+1);
              neighbours.add(neighbour1);
             neighbours.add(neighbour2);
            

        }
        return neighbours;
    }
    public static void main(String[] args) {
        String[] deadends={"0201","0101","0102","1212","2002"};
        String target="0202";
        String source="0000";
        System.out.println(openLock(deadends, target, source));

        
    }
    
}
