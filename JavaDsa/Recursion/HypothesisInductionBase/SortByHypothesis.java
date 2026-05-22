package HypothesisInductionBase;

import java.util.ArrayList;
//IBH for sort 
/*
hypothesis:
       sort(n)=sorted array till n
       sort(n-1)=sorted array till n-1
Induction:
      sort(n)=sort(n-1) then insert last element in coorect position
      sort(n)= insert(sort(n-1),last element);
Base:
     when array size is 1 its sorted
     if(arr.size()==1)
     return
         
*/


//IBH for insert method
/*
this method takes sorted array as input and element to insert 

Hypothesis: insert(n,element to insert)= full array
            insert(n-1,element to insert)= array without max element in sorted array

Induction : insert(n,element to insert)=insert(n-1.last element) + arr.add(last max element removed);

Base: if element to insert >= max of array then add this to array last pos  and return
           if(element to insert >= arr.get(arr.size()-1))
             {
            arr.add(element to insert);
            return;
             }



*/
public class SortByHypothesis {
    static void sort(ArrayList<Integer> arr){
        if(arr.size()==1){
            return;
        }

      int num=arr.remove(arr.size()-1);

      sort(arr);
      insert(arr,num);
}
static void insert(ArrayList<Integer> arr,int num){
    if(arr.size()<=0 || num>=arr.get(arr.size()-1)){
        arr.add(num);
        return;
    }
    int removedNum=arr.remove(arr.size()-1);
    insert(arr,num);
    arr.add(removedNum);

}
    public static void main(String[] args) {
        int[] arr={1,4,5,2,7,8,3};
        ArrayList<Integer> array=new ArrayList<>();
        for(int i:arr){
            array.add(i);
        }
        sort(array);
        System.out.println(array);
    }
    
}
