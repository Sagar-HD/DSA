import java.util.*;

public class BestTimeofStock {
    public static void main(String[] args) {
      
      int arr[]={10,1,6,7,4};
      int maxProfit=0;
      int min=arr[0];
      for(int i=1;i<arr.length;i++){
        int profit=arr[i]-min;
        if(profit>maxProfit){
          maxProfit=profit;
        }
        if(arr[i]<min){
          min=arr[i];
        }
      }
      System.out.println(maxProfit);
    }
}