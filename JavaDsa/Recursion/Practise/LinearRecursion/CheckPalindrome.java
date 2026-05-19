package Practise.LinearRecursion;

public class CheckPalindrome {
    static boolean isPali(String str,int start,int end){
        if(start>=end){
            return true;
        }
        if(str.charAt(start)==str.charAt(end)){
            return isPali(str, start+1, end-1);
        }

return false;
    }
    public static void main(String[] args) {
        String str="sagararagas";
        System.out.println(isPali(str, 0, str.length()-1));
        
    }
}
