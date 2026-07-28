package basics;
public class SetIthBit {
    public static void main(String[] args) {
        //setting i th bit to 1
        int num=13; // 1101
        int i=1;
        Integer added1=num |(1<<i);

        System.out.println(Integer.toBinaryString(added1));

        //setting ith bit to 0
        //but doing and to that place with 0 we can get 0 but to maintain other places same we make remaning as 1 

      int removed1=added1 & (~(1<<i));
      System.out.println(Integer.toBinaryString(removed1));


    }
    
}
