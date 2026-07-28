package basics;
public class PowerOf2 {
    public static void main(String[] args) {
        //pattern in 2 power nums in binary 
        // 2 power num always have only 1 set bit bcs it only need any one place to represent as its power of 2
        //so by doing n & (n-1) // n-1 has last bit of n to 0 and right side of it as 1
        // n & n-1 gives 0 if its poer of 2 else it gives value after removing last set bit 
        //in two power if we remove last set bit we get 0
        int num=8;
        int num2=9;
        System.out.println((num & (num-1)) ==0);
         System.out.println((num2 & (num2-1)) ==0);
    }
    
}
