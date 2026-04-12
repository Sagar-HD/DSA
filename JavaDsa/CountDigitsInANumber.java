import java.util.*;

public class CountDigitsInANumber {
    public static void main(String[] args) {
      int n=3210;
      int count=0;
      while(n>0){
        count++;
        n/=10;
      }
      System.out.println(count);
    }
}