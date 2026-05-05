#include<iostream>
#include<vector>
using namespace std;
int main(){
    vector<int> arr={4,5,2,10,3,4,12,19,3,43};
     vector<int> ans(arr.size());
     int first=0;
     int second;
     while(first<=arr.size()-2){
second=first+1;
while(arr[second]<=arr[first]){
    second++;
}
ans[first]=arr[second];
first++;
     }
ans[arr.size()-1]=-1;

     for(int i=0;i<ans.size();i++){
        cout<<ans[i]<<endl;
     }
    return 0;
}