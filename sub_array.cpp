#include<iostream>
#include<vector>
using namespace std;
int main(){
    vector<int> arr={4,-2,3,4,5,4};
    vector<int> pref;
        
    int n=arr.size();
    vector<int> suf(n,0);
    pref.push_back(arr[0]);
    for(int i=1;i<n;i++){
     
 pref.push_back(pref[i-1]+arr[i]);
        
    }
        for(int i=0;i<n;i++){
            cout<<pref[i]<<endl;
        }
cout<<endl<<"suffix"<<endl;
        suf[n-1]=arr[n-1];
for(int i=n-2;i>=0;i--){
     
 suf[i]=suf[i+1]+arr[i];
        
    }
     for(int i=0;i<n;i++){
            cout<<suf[i]<<endl;
        }

int pre=0;
int total=0;
for(int i=0;i<n;i++){
    total+=arr[i];
}

int ans=0;
for(int i=0;i<n;i++){
    if(ans<0){
        ans=0;
    }
    ans+=arr[i];
    
}
cout<<ans<<": max of sub array"<<endl;




for(int j=0;j<n;j++){
if(pref[j]==total-pref[j]){
       cout<<"found at "<<j<<endl;
    return 0;
 
}

}

cout<<"no equal partiotion"<<endl;


    return 0;
}