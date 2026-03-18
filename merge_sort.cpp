#include <iostream>
using namespace std;
void swap(int i,int j,int arr[]){
int temp=arr[i];
arr[i]=arr[j];
arr[j]=temp;
}
void merge(int arr[],int low,int high,int mid){
  int B[100];
  int i=low;
  int j=mid+1;
  int k=0;
  while(i<=mid && j<=high){
    if(arr[i]<arr[j]){
B[k]=arr[i];
i++;
k++;
    }
    else{
        B[k]=arr[j];
        j++;
        k++;  
    }
  }
  while(i<=mid){
    B[k]=arr[i];
    i++;
    k++;
  }
  while(j<=high){
    B[k]=arr[j];
    j++;
    k++;  
  }
  for(int m = 0, i = low; i <= high; i++, m++) {
    arr[i] = B[m];
    
}

}

void mergesort(int arr[],int low,int high){
  if(low<high){

int mid=(low+high)/2;
mergesort(arr,low,mid);
mergesort(arr,mid+1,high);
merge(arr,low,high,mid);



  }

}


int main(){
    int arr[7]={5,1,3,2,7,6,8};

mergesort(arr,0,6);

for(int i=0;i<7;i++){
cout<<arr[i];
}

return 0;
}