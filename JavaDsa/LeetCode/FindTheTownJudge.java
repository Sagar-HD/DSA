/*
In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

 

*/
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree=new int[n+1];
        int[] outdegree=new int[n+1];
        for(int relation=0;relation<trust.length;relation++){
            int fromNode=trust[relation][0];
            int toNode=trust[relation][1];
            outdegree[fromNode]++;
            indegree[toNode]++;

        }
        for(int node=1;node<=n;node++){
            if(indegree[node]==n-1&&outdegree[node]==0){
                return node;
            }
        }
return -1;
        
    }
}