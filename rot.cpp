#include <iostream>
using namespace std;


void swap(int arr[],int i ,int j){
   int temp = arr[i];
   arr[i]=arr[j];
   arr[j]=temp;
   
};

int main(){
    int arr[]={0,1,1,0,1,0};

int start=0;
int end=5;

while(start<end){
    if(arr[start]==1){
if(arr[end]==0){
    swap(arr,start,end);
    start++;
    end--;
}else{
    end--;
}
     }
     else{
start++;
     }
   
}
for(int i=0;i<6;i++){
    cout<<arr[i]<<endl;
}
 return 0;
}