package basics;
//exploiting xor property to make same numbers as 0 and dirrent num as 1 
public class SwapTwoNumbersUsingXor {
    public static void main(String[] args) {
        int a=6;
        int b=5;
        a=a^b; // xor of both 
        b=a^b; // (a ^ b) ^b b cancels a remians
        a=a^b; //now b has a value and a has a ^b so (a ^ b ) ^ a a cancels b remains
        System.out.println(a);
        System.out.println(b);
    }
    
}
