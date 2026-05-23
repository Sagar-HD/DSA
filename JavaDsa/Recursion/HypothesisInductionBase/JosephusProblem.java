package HypothesisInductionBase;

import java.util.ArrayList;

public class JosephusProblem {
    static int safePerson(int k,int index,ArrayList<Integer> people){
        if(people.size()==1){
            return people.get(0);
        }
         index=(index+k)%people.size();
        people.remove(index);
        return safePerson(k,index, people);
    }
    public static void main(String[] args) {
        int k=7;
        int n=40;
        ArrayList<Integer> people=new ArrayList<>();
        k=k-1;//bcs deletion is based on 0 based indexing

        for(int i=1;i<=n;i++){
            people.add(i);
        }
        System.out.println(safePerson(k, 0, people));

    }
    
}
