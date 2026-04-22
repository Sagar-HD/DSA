import java.util.*;

public class MinimaxFrequency {
    public static void main(String[] args) {
      int[] arr={1,3,6,3,7,8,9,7,7};
      boolean[] visited=new boolean[arr.length];
      int minElem=0;
      int maxElem=0;
      int maxFreq=Integer.MIN_VALUE;
      int minFreq=Integer.MAX_VALUE;
      for(int i=0;i<arr.length;i++){
        if(visited[i]) continue;
        
        int count=0;
        for(int j=i+1;j<arr.length;j++){
          if(arr[i]==arr[j])
          {
          count++;
          visited[j]=true;
          }
        }
        if(count>maxFreq){
          maxFreq=count;
          maxElem=arr[i];
        }
        if(count<minFreq){
          minFreq=count;
          minElem=arr[i];
        }
        
        
      }
      System.out.println("max :"+maxElem);
      System.out.println("min :"+minElem);
      
    }
}