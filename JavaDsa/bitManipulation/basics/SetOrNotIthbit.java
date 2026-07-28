package basics;
public class SetOrNotIthbit {
    public static void main(String[] args) {
       // int num=5; // 101
        int num=9; //  1001
        int i=2;
        //here ith bit means 0 based index means i+1 ith place

        //using right shift
        //shifting that ith bit to rightmost and and operator with 1
        System.out.println(((num>>i)&1)==1);

        //using left shift
        //left shifting 1 i times to get one in ith bit place rest as 0
        //now and operator with num and ith shifted 1 gives 0 if its not set any greater num if a set

        System.out.println((num&(1<<i))!=0);


    }
    
}
