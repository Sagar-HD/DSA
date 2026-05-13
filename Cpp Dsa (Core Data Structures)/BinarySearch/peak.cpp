#include<iostream>
#include<vector>
using namespace std;

int main() {
    vector<int> arr = {1, 2, 5,5,5, 5, 7, 8, 3};
    int n = arr.size();

    int start = 0;
    int end = n - 1;
    int mid;
int f=-1;
int l=-1;
int ele=5;
    while (start <= end) {
        mid = start + (end - start) / 2;
       if(arr[mid]==ele){
        f=mid;
       end=mid-1;
       }
       else if (ele > arr[mid]) {
            start=mid+1;
        } else {
            end = mid -1;
        }
    }
cout<<f<<"first occurence"<<endl;
   start=0;
   end= n - 1;
  while (start <= end) {
        mid = start + (end - start) / 2;

       if(arr[mid]==ele){
        l=mid;
       start=mid+1;
       }
       else if (ele > arr[mid]) {
            start=mid+1;
        } else {
            end = mid -1;
        }
    }
cout<<l<<"last occurence";
}
