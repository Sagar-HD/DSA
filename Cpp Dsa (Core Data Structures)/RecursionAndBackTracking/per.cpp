#include<iostream>
#include<vector>
using namespace std;
void per(vector<int> &arr,vector<vector<int>> &ans,vector<bool> &used,vector<int> &temp){
if(temp.size()==arr.size()){
    ans.push_back(temp);
    return;
}
for(int i=0;i<arr.size();i++){
   if(!used[i]){
    used[i]=true;
    temp.push_back(arr[i]);
    per(arr,ans,used,temp);
    temp.pop_back();
    used[i]=false;

   }

}
}
int main(){
vector<int> arr={1,2,3};
vector<vector<int>> ans;
vector<int> temp;
vector<bool> used(arr.size(),false);
per(arr,ans,used,temp);
for(int i=0;i<ans.size();i++){
    cout<<"{";  
    for(int j=0;j<ans[i].size();j++){
        cout<<ans[i][j];
    }
    cout<<"}"<<endl;
}   

    return 0;
}

