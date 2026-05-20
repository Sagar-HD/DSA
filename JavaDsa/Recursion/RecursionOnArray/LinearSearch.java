package RecursionOnArray;
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr={2,1,56,23,89,3};
        System.out.println("element is at : "+find(arr,89,0));
    }
    static int find(int[] arr,int target,int index){
        if(index>=arr.length){
          return -1;
        }
       if(arr[index]==target){
        return index;
       }
     return find(arr,target,index+1);
       
    }

    
}
