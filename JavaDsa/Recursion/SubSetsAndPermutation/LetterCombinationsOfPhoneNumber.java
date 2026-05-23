package SubSetsAndPermutation;

public class LetterCombinationsOfPhoneNumber {
    static void find(String processed,String unProcessed){
if(unProcessed.isEmpty()){
    System.out.println(processed);
    return;
}
int num=unProcessed.charAt(0)-'0';

int start=(num-1)*3;
for(int i=start;i<start+3;i++){
    if(i>=26)continue;
    find(processed+(char) ('a' + i), unProcessed.substring(1));
}


    }
    public static void main(String[] args) {
        String str="12";
        find("",str);

    }
    
}
