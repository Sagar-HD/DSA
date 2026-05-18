package SubSets;

import java.util.ArrayList;

public class PossibleValueOfDiceToTarget {
static void find(int target,int dices,ArrayList<Integer> ans){
    if(target==0 && dices==0){
        System.out.println(ans);
        return;
    }
    if( target<0){
        return;
    }
    
    for(int i=1;i<=6;i++){
        ans.add(i);
        find(target-i,dices-1,ans);
        ans.remove(ans.size()-1);
    }
}
    public static void main(String[] args) {
        int target=4;
        find(target, 2,new ArrayList<>());
    }
}