package Backtracking;


public class LargestNumberInKSwaps {
static String max="";
//main point 
//answer was always in base case in recursion but in backtracking answer can be anywhere
//we are just controlling recursion // undoing changes choices // stopping unwated decisions

    static void largest(String input,int index,int swaps){
      
        if(swaps==0 || index==input.length()){
           return;
        }
        int max=Integer.MIN_VALUE;
        for(int i=index+1;i<input.length();i++){
            int num=input.charAt(i)-'0';
            if(num>max){
                max=num;

            }

        }
        //horizontal drifting
        if(input.charAt(index)-'0'>=max){
            largest(input, index+1, swaps);
            return;
           
        }
        for(int i=index+1;i<input.length();i++){
                  int num=input.charAt(i)-'0';
                  if(num==max){
                      String newInput=swap(input, index, i);
                      if(newInput.compareTo(LargestNumberInKSwaps.max)>0){
                      LargestNumberInKSwaps.max=newInput;
                      }
                  largest(newInput, index+1,swaps-1);
                
                  }
        }
        
      

    }
static String swap(String str,int index1,int index2){
    if(index1==index2) return str;
    char char1=str.charAt(index1);
    char char2=str.charAt(index2);
    return str.substring(0,index1)+char2+str.substring(index1+1,index2)+char1+str.substring(index2+1);
}
    public static void main(String[] args) {
        String str="543299";
         largest(str, 0,4);
         System.out.println(LargestNumberInKSwaps.max);

    }
}