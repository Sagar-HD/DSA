package problems;
public class NoOfFlipsToChange {
    static int getFlips(int x,int y){

         int xor= x ^ y ; //this gives 1 in place of diffrent bit need to be changed
        //by this counting set bits i can get the no of flips needed
        int count=0;
        while(xor>0){
            count++;
            xor=xor & (xor-1);


        }
        return count;

    }
    public static void main(String[] args) {
        int x=10;
        int y=7;

       
        System.out.println(getFlips(x, y));

        System.out.println(getFlips(3, 4));
    }
    
}
