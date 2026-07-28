package basics;
public class CountOfSetBits {
    public static void main(String[] args) {
        int num=Integer.MAX_VALUE; //31 ones 

        //2 methods 
       int count=0;

        while(num>0){
            int digit=num&1;
            if(digit==1) count++;
            num=num>>1;
        }
        System.out.println(count);


        //now using n & n-1 which removes last set bit 
        
        num=Integer.MAX_VALUE;
        count=0;
        while(num!=0){
            count++;
            num=num & (num-1);

        }
        System.out.println(count);


    }
    
}
