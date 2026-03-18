#include<iostream>
#include<vector>
using namespace std;
void ps(vector<int> &arr,vector<int> &temp,int n,int i=0){
if(i==n){
cout<<"{";
for(int k=0;k<temp.size();k++){
   
cout<<temp[k];
}
cout<<"}";
return;
}

ps(arr,temp,n,i+1);

temp.push_back(arr[i]);
ps(arr,temp,n,i+1);
temp.pop_back();
}
int main(){
vector<int> arr={1,2,3,4};
vector<int> temp;
ps(arr,temp,arr.size());
    return 0;
}