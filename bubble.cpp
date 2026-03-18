#include <iostream>
using namespace std;
void swap(int i,int j,int arr[]){
int temp=arr[i];
arr[i]=arr[j];
arr[j]=temp;
}

void bubblesort(int arr[],int n){
    for(int i=0;i<=n-2;i++){
        int swaps=0;
        for(int j=0;j<=n-2-i;j++)
        {
            if(arr[j]>arr[j+1]){
                swap(j,j+1,arr);
                swaps++;
            }
        }
        if(swaps==0){
            cout<<"already sorted at "<<i+1<<" th iteration\n";
            return ;
        }
    }

}


int main(){
    int arr[5]={5,4,2,3,1};

bubblesort(arr,5);

for(int i=0;i<5;i++){
cout<<arr[i];
}

return 0;
}