#include<iostream>
#include<vector>
using namespace std;
int main(){
    vector<int> arr={3,4,5,6,7,8,1,2};
    int ele=5;
    int n=arr.size();
    int start=0;
    int end=n-1;
    while(start<=end){
        int mid=start+(end-start)/2;
       
        if(arr[mid]==ele){
            cout<<"found at:"<<mid<<endl;
            
            return 0;
        }
        else if (arr[mid]>arr[start])
        {
            if(arr[start]<=ele&&ele<arr[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        else{
            if(arr[mid]<ele&&ele<=arr[end]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
     
    }
       cout<<"not found";
        return 0;
}