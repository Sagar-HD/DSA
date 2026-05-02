#include<iostream>
#include<vector>
using namespace std;
void perstr(string &str,int index,int n){
if(index==n){
    cout<<str;
    cout<<endl;
    return;

}
for(int i=index;i<str.size();i++){
   char ch = str[i];
   str[i]=str[index];
   str[index]=ch;
    perstr(str,index+1,n);
    ch = str[i];
   str[i]=str[index];
   str[index]=ch;
    
    }
    

}

int main(){
    string str = "ABC";
    string temp;
 
    perstr(str,0,str.size());
    return 0;
}