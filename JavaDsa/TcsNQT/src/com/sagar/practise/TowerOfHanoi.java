package com.sagar.practise;

public class TowerOfHanoi {
    static  void print(int n,char source,char aux,char des){
        if(n==1){
            System.out.println("Shift 1 from "+source+" to "+des);
            return;
        }
        print(n-1,source,des,aux);
        System.out.println("Shift "+n+ " from "+source+" to "+des);
        print(n-1,aux,source,des);

    }
    public static void main(String[] args) {
print(3,'a','b','c');
    }
}
