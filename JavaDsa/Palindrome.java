import java.util.*;

public class Palindrome {
  static boolean isPali(String str,int start,int end)
  {
    if(start>=end) return true;
    if(str.charAt(start)==str.charAt(end)){
      start++;
      end--;
      return isPali(str,start,end);
    }
    else{
      return false;
    }
  }
    public static void main(String[] args) {
      String str="momu";
      System.out.println(isPali(str,0,str.length()-1));
      
    }
}