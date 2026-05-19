package RecursionWithPassingAnsInArgs;

public class StringWithoutAInIt {
    static String find(String str,String ans,int index){
if(index==str.length()){
    return ans;
}
if(str.charAt(index)=='a'){
    return find(str,ans,index+1);
}
else{
return find(str,ans+str.charAt(index),index+1);
}
    }
    public static void main(String[] args) {
        String str="sagaaar";
        String ans=find(str,new String(),0);
        System.out.println(ans);
    }
    
}
