package basics;
public class RemoveLastSetBit {
    public static void main(String[] args) {
       // int num=13;//1101 --> 1100
        int num=84;//1010100 --> 1010000 

        //num-1 will always make last 1 in binary to 0 and right to it all bits as 1
        //so doing n & n-1 will remove last set bit
        //for 84 --> 1010100 & 1010011 --> 1010000

        int removed=num&num-1;
        System.out.println(Integer.toBinaryString(removed));
    }
    
}
