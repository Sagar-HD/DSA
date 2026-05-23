package SubSetsAndPermutation;

public class PermutationWithCaseChange {
    static void permuteChangeCase(String input,String output){
        if(input.isEmpty()){
            System.out.println(output);
            return;
        }
        permuteChangeCase(input.substring(1), output+input.toLowerCase().charAt(0));
        permuteChangeCase(input.substring(1), output+input.toUpperCase().charAt(0));
    }
    public static void main(String[] args) {
        String str="abc";
        permuteChangeCase(str, "");
    }
    
}
