package Backtracking;

import java.util.ArrayList;

public class SubSequenceOfAString {
    //* just removed index as parameter and started passing unproccesed string further
static void printSub(String str,StringBuilder ans){
if(str.isEmpty()){
    System.out.println(ans);
    return;
}
printSub(str.substring(1), ans);
ans.append(str.charAt(0));
printSub(str.substring(1),  ans);
ans.deleteCharAt(ans.length()-1);
}


//returning array list by creating it in each function body 
static ArrayList<String> printSub(String str,String ans){
    ArrayList<String> list=new ArrayList<>();
if(str.isEmpty()){
    list.add(ans);
    return list;
}
 ArrayList<String> left=printSub(str.substring(1), ans);

 ArrayList<String> right=printSub(str.substring(1),  ans+str.charAt(0));
 list.addAll(right);
 list.addAll(left);
 return list;

}
static ArrayList<String> printSubAscii(String str,String ans){
    ArrayList<String> list=new ArrayList<>();
if(str.isEmpty()){
    list.add(ans);
    return list;
}
 ArrayList<String> left=printSubAscii(str.substring(1), ans);

 ArrayList<String> right=printSubAscii(str.substring(1),  ans+str.charAt(0));
 ArrayList<String> ascii=printSubAscii(str.substring(1), ans+(str.charAt(0)+0));
 list.addAll(right);
 list.addAll(left);
 list.addAll(ascii);
 return list;

}
    public static void main(String[] args) {
        String str="abc";
        StringBuilder ans=new StringBuilder();
        printSub(str,  ans);
        ArrayList<String> list=printSub(str, "");
        System.out.println(list);
        ArrayList<String> listAscii=printSubAscii(str, "");
        System.out.println(listAscii);
        
    }
    
}
