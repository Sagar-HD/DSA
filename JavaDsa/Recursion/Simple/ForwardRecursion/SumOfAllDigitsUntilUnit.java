package Simple.ForwardRecursion;

public class SumOfAllDigitsUntilUnit {
    static int sum(int num){
        if(num<10){
            return num;
        }
        int newNum=0;
        while(num>0){
            newNum+=num%10;
            num=num/10;
        }
        
        return sum(newNum);
    }
    public static void main(String[] args) {
        int num=9875;
        System.out.println(sum(num));
    }
}
