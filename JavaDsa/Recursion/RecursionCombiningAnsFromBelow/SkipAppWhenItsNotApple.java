package RecursionCombiningAnsFromBelow;

public class SkipAppWhenItsNotApple {
static String skipApp(String str){
    if(str.isEmpty()){
        return "";
    }
    if(str.startsWith("app")&&!str.startsWith("apple")){
           return skipApp(str.substring(3));
    }
    else{
        return str.charAt(0)+skipApp(str.substring(1));
    }

}
    public static void main(String[] args) {
        String str="sagarmadeanappwhichhasanapple";
        String ans=skipApp(str);
        System.out.println(ans);

    }
}