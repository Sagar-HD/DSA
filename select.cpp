#include <iostream>
using namespace std;
void swap(int i,int j,int arr[]){
int temp=arr[i];
arr[i]=arr[j];
arr[j]=temp;
}
void selectsort(int arr[],int n){
int i=0;
while(i<n){
    int min=i;
    for(int j=i+1;j<n;j++){
        if(arr[j]<arr[min]){
            min=j;
        }
    }
    swap(min,i,arr);
    i++;
}

}
int main(){
    int arr[5]={6,5,4,3,2};

selectsort(arr,5);

for(int i=0;i<5;i++){
cout<<arr[i];
}

return 0;
}