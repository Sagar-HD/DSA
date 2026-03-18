#include<iostream>
using namespace std;
void print_star(int n,int currow=1,int stars_printed=0){
    if(currow>n){
        return ;
    }
   if(stars_printed!=currow){
    cout<<"*";
    print_star(n,currow,stars_printed+1);
   }
   else{
    cout<<endl;
    print_star(n,currow+1,0);
   }


}
int main(){
    print_star(4);
    return 0;
}