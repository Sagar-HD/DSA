package SubSetsAndPermutation;

public class SubSequencesOfString {
static void printSub(String str,int index,String ans){
    if(index==str.length()){
      System.out.println(ans);
      return ;
    }
    printSub(str, index+1, ans);

    printSub(str, index+1, ans+str.charAt(index));

}
    public static void main(String[] args) {
        String str="abc";
        printSub(str, 0, "");

    }
}
