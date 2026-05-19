package Practise.LinearRecursion;

public class PowerFunction {
    static double power(int x,int n){
     if(n==0){
        return 1;
     }
     if(n>0){
     return x*power(x, n-1);
     }
     else{
        n=-n;
        System.out.println(n);
        return x/power(x, n+1);
     }
    }
    public static void main(String[] args) {
        System.out.println(power(2, 10));
         System.out.println(power(2, -2));
    }
}
