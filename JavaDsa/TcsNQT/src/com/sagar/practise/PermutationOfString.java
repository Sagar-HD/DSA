package com.sagar.practise;

class PermutationOfString{


    static void print(String str, StringBuilder temp,int index){
        if(temp.length()==str.length()){
            System.out.println(temp);
            return;
        }
        for(int i=index;i<str.length();i++){
            temp.append(str.charAt(i));
            print(str,temp,i+1);
            temp.deleteCharAt(i);
        }
    }
    public static void main(String[] args) {
        StringBuilder temp=new StringBuilder();
        String str="abc";
        print(str,temp,0);

    }
}