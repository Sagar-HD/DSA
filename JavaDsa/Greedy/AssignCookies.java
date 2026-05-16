package Greedy;
import java.util.*;

public class AssignCookies {
    public static void main(String[] args) {
      int[] cookiesNeeded={1,5,3,3,4};
      int[] cookies={4,2,1,2,1,3};
      Arrays.sort(cookiesNeeded);
      Arrays.sort(cookies);
      int ptr=0;
      int satisfied=0;
      for(int stud:cookiesNeeded){
        
        while(ptr<cookies.length && cookies[ptr]<stud){
          ptr++;
        }
        
        if(ptr<cookies.length){
          
        satisfied++;
        ptr++;
        
        }
        else{
          break;
        }
        
        
      }
      System.out.println("no of students satisfied: "+satisfied);
    }
}