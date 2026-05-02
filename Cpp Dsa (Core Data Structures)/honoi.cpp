
#include<iostream>
using namespace std;
void tower_of_honoi(int n,char source,char target,char aux){
    if(n==0){
        return;
    }

    tower_of_honoi(n-1,source,aux,target);
    cout<<"Move disk from "<<source<<" to "<<target<<endl;
    tower_of_honoi(n-1,aux,target,source);
}
 int main(){
    tower_of_honoi(2,'A','C','B');
    return 0;
 }