package problems;

public class SingleNumber3Duplicate {
    static int findUnique(int[] arr){
        //just adding all set bits in their position for all 32 bits indivudually mod with 3 to get bit of unique one
        StringBuilder ansInBinary=new StringBuilder();
        for(int i=0;i<32;i++){
            int bitsCount=0;
            for(int num : arr){
                //finding if that bit is 1 then add 1 to bit count
                bitsCount+= (num & (1 << i)) !=0 ? 1: 0;

            }
            int unqiueBit= bitsCount%3==0 ? 0 : 1 ;
            ansInBinary.append(unqiueBit);

        }
        //now reverse the ans bcs we added from last 
        ansInBinary.reverse();


        
        return binaryToDecimal(ansInBinary.toString());

    }
    private static int binaryToDecimal(String binary){
        int ans=0;
        int power=1;


        for(int i=binary.length()-1;i>=0;i--){

            if(binary.charAt(i)=='1'){
                ans=ans+power;
               

            }
        power*=2;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,2,5,1,2,3,5,2,1,5,3,3,9};
        System.out.println(findUnique(arr));
    }
    
}
