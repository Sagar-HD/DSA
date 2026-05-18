package SubSets;

import java.util.ArrayList;
// this problem is not actual combination bcs order matters here 
//must learn approch where order doent matter or else it will be same as permutation with n digits
//in recursion we must move foraerd to acheive that 
public class PossibleCombinationOfNfromList {
    static void possibleCombinations(int[] list,int n,ArrayList<Integer> ans){
        if(n==0){
        System.out.println(ans);
        return;
        }
        for(int i : list){
            ans.add(i);
            possibleCombinations(list, n-1, ans);
            ans.remove(ans.size()-1);
        }
    }

     static void possibleCombinationsWithoutRepetation(int[] list,int n,ArrayList<Integer> ans,boolean[] visited){
        if(n==0){
        System.out.println(ans);
        return;
        }
        for(int i=0;i<list.length;i++){
            if(visited[i]==false){
                visited[i]=true;
            ans.add(list[i]);
            possibleCombinationsWithoutRepetation(list, n-1, ans, visited);
            ans.remove(ans.size()-1);
            visited[i]=false;
            }
        }
    }
    
     static void possibleCombinationsNoOrder(int[] list,int n,int start,ArrayList<Integer> ans){
        if(n==0){
        System.out.println(ans);
        return;
        }
        for(int i=start;i<list.length;i++){
           
            ans.add(list[i]);
            possibleCombinationsNoOrder(list, n-1,i+1, ans);
            ans.remove(ans.size()-1);
          
            }
        }
    
    public static void main(String[] args) {
        int[] list={1,2,3,4,5};
        possibleCombinations(list, 2, new ArrayList<>());
        System.out.println("///////");
        boolean[] visited=new boolean[list.length];
        
        possibleCombinationsWithoutRepetation(list, 2, new ArrayList<>(), visited);
        System.out.println("///////");
        possibleCombinationsNoOrder(list, 2, 0, new ArrayList<>());

    }
    
}
