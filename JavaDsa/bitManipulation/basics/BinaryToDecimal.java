package basics;
public class BinaryToDecimal {
    static int getDecinal(String binary){
        int ans=0;
        int pow=1;
        for(int i=binary.length()-1;i>=0;i--){
            if(binary.charAt(i)=='1'){
                ans=ans+pow;
            }
            pow*=2;
        }
        return ans;
    }
    public static void main(String[] args) {
        String binary="1101";
        System.out.println(getDecinal(binary));
    }
    
}
