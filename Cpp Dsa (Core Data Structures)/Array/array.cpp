#include<iostream>
using namespace std;
void display(int arr[],int size){

for(int i=0;i<size;i++)
cout<<arr[i];

cout<<endl;
}

void insert(int arr[],int elem, int index,int size){
  
    for(int i=size;i>index;i--){
        arr[i]=arr[i-1];
    }
  
arr[index]=elem;

}

int binarysearch(int arr[],int elem,int size){
  int low=0;
  int high=size-1;
  while(low<=high)  {
int mid=low+high/2;
if(arr[mid]==elem){
   
    return mid;
}
else if(elem>arr[mid]){
low=mid+1;
}
else{
    high=mid-1;
}

  }

return -1;

}

int insert(int arr[], int index,int size){
  int deleted=arr[index];
    for(int i=index;i<size-1;i++){
        arr[i]=arr[i+1];
    }
  
return deleted;

}



int main(){
 int arr[100]={1,2,3,4};
 int size=4;
 display(arr,size);
insert(arr,5,3,size);
size++;
display(arr,size);
insert(arr,1,size);
size--;
display(arr,size);
cout<<"enter element to serach \n";
int elem;
cin>>elem;
int res=binarysearch(arr,elem,size);
if(res!=-1){
cout<<"element found at:"<<res;
}
else{
    cout<<"element not found :"<<res;  
}
return 0;
}