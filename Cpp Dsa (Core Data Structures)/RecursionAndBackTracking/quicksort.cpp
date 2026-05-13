#include <iostream>
using namespace std;
void swap(int i,int j,int arr[]){
int temp=arr[i];
arr[i]=arr[j];
arr[j]=temp;
}
int partition(int arr[],int low,int high){
  
    
    int pivot=arr[low];
int i=low+1;
int j=high;
while(i<=j){
    
while(arr[i]<=pivot){
    i++;

}
while(arr[j]>pivot){
    j--;

}
if (i < j) {
    swap(i, j, arr);
}

   

}
swap(low,j,arr);
cout<<" array after partition: ";
for(int i=low;i<=high;i++){
    cout<<arr[i];
    }
    cout<<endl;
cout<<"partition of array :"<<arr[j]<<endl;
return j;
}
void quicksort(int arr[],int low,int high){
    if(low<high){
    cout<<"quick sort on array : ";
    for(int i=low;i<=high;i++){
        cout<<arr[i];
        }
        cout<<endl;
    int partion_index=partition(arr,low,high);

        quicksort(arr,low,partion_index-1);
        quicksort(arr,partion_index+1,high);
    }

}


int main(){
    int arr[7]={5,1,3,2,7,6,8};

quicksort(arr,0,6);

for(int i=0;i<7;i++){
cout<<arr[i];
}

return 0;
}