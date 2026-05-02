#include <iostream>
#include<vector>
using namespace std;


void countsort(int arr[],int n){
   int max=arr[0];
  for(int i=1;i<n;i++){
if(arr[i]>max){
    max=arr[i];
}
  }
vector<int> log(max+1,0);

for(int i=0;i<n;i++){
    int num=arr[i];
    log[num]++;
}
int m=0;
for(int i=0;i<=max;i++){
while(log[i]!=0){
    arr[m]=i;
    m++;
    log[i]--;
}
}



    }




int main(){
    int arr[5]={4,3,2,1,5};

countsort(arr,5);

for(int i=0;i<5;i++){
cout<<arr[i]<<" ";
}

return 0;
}