package problems;
//this is not designed for negatives
public class XorInRange {
    //we have noticed a pattern that 
    //in xor always if we wanr xor till 0 to n  
    // if n % 4 == 1 xor is 1
    // if n % 4 == 2 xor is n+1
    // if n % 4 == 3 xor is 0
    // if n % 4 == 0 xor is n

    static int xorTillN(int n){
         if (n % 4 == 1 ) return 1;
         if(n % 4 == 2 ) return n+1;
          if (n % 4 == 3 ) return 0;

        //  if(n % 4 ==  0 ) return n; 
        //write this directly
         
        return n;

    }

    static int getXorInRange(int start,int end){
        int xorUntilStart=xorTillN(start-1);
        int xorTillEnd=xorTillN(end);
        return xorUntilStart^xorTillEnd;
        //duplicate which was intentionaly calculated wull be removed

    }


    public static void main(String[] args) {
        System.out.println(getXorInRange(1,8));
        System.out.println(getXorInRange(3, 18));
        
    }
    
}
