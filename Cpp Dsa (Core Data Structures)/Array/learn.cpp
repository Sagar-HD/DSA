#include<math.h>
#include<iostream>
using namespace std;
void bishop(int x,int y){
int count=0;
count+=min(8-x,8-y);
count+=min(8-x,y-1);
count+=min(x-1,8-y);
count+=min(x-1,y-1);
cout<<count;


}

//18
//81

int main(){
cout<<"enter x:";
int x;
cin>>x;
cout<<"enter y:";
int y;
cin>>y;
bishop(x,y);
return 0;
}