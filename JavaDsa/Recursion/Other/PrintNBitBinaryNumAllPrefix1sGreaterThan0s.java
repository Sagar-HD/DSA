package Other;

public class PrintNBitBinaryNumAllPrefix1sGreaterThan0s {
    static void printBinary(String output,int n,int countOf1,int countOf0){
        if(output.length()==n){
            System.out.println(output);
            return;
        }
        if(countOf1>countOf0){
            printBinary(output+'0', n, countOf1, countOf0+1);
        }
        printBinary(output+'1', n, countOf1+1, countOf0);
    }
    public static void main(String[] args) {
       int n=4;
       printBinary("", n, 0, 0);
        
    }
    
}
