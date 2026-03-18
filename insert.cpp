#include <iostream>
using namespace std;
void swap(int i,int j,int arr[]){
int temp=arr[i];
arr[i]=arr[j];
arr[j]=temp;
}

void insertsort(int arr[],int n){
    for(int i=1;i<n;i++){
int key=arr[i];
int j=i-1;
while(j>=0 && arr[j]>key){
arr[j+1]=arr[j];
j--;
}
 arr[j+1]=key;   
          


        
    }
  
    }




int main(){
    int arr[5]={99,2,53,56,3};

insertsort(arr,5);

for(int i=0;i<5;i++){
cout<<arr[i]<<" ";
}

return 0;
}