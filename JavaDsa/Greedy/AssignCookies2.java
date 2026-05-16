package Greedy;
import java.util.*;

public class AssignCookies2 {
    public static void main(String[] args) {
      int[] cookiesNeeded={1,5,3,3,4};
      int[] cookies={4,2,1,2,1,3};
      Arrays.sort(cookiesNeeded);
      Arrays.sort(cookies);
      int ptr1=0;
      int ptr2=0;
      while(ptr2<cookies.length){
        if(cookiesNeeded[ptr1]<=cookies[ptr2]){
          ptr1++;
        }
        ptr2++;
      }
      
      System.out.println("no of students satisfied: "+ptr1);
    }
}