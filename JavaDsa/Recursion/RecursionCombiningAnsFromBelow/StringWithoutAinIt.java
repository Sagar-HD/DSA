package RecursionCombiningAnsFromBelow;

public class StringWithoutAinIt {
    public static String find(String str,int index){
         String ans=new String();
        if(index==str.length()){
            return ans;
        }
       if(str.charAt(index)=='a'){
        return ans+find(str,index+1);
       }
       else{
        ans=ans+str.charAt(index);
        return ans+find(str, index+1);
       }
    }
    public static void main(String[] args) {
         String str="sagaaar";
        String ans=find(str,0);
        System.out.println(ans);
    }
}
