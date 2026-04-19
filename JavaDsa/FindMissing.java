import java.util.*;

public class FindMissing {
    public static void main(String[] args) {
    int[] arr={1,6,5,2,3};
    int len=arr.length+1;
    int sum=0,sum1=0;
    for(int n:arr){
      sum+=n;
    }
    for(int i=1;i<=len;i++)
    {
      sum1+=i;
    }
    System.out.println(sum1-sum);
    }
}