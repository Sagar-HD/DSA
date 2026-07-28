package basics;


/**
 * DecimalToBinary
 */
public class DecimalToBinary {
    //can do with bitwise and also 
    static String getBinary(int num){
        StringBuilder ans=new StringBuilder();
        while(num>0){
            int digit=num%2;
            ans.append(digit);
            num=num/2;
        }
        return ans.reverse().toString();

    }

    public static void main(String[] args) {
        int num=5;
        System.out.println(getBinary(num));
    }
}