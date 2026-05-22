package HypothesisInductionBase;

public class TowerOfHonoi {
    static void toh(int n,char source,char destination,char helper){
        if(n==1){
            System.out.println("move disk from "+source+" to "+destination);
            return;
        }
        toh(n-1, source, helper, destination);
        System.out.println("move disk from "+source +" to "+destination);
        toh(n-1, helper, destination, source);

    }
    public static void main(String[] args) {
        int n=3;
        toh(n,'A','C','B');
    }
    
}
