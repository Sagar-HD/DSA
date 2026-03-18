#include<iostream>
#include<stdlib.h>
using namespace std;
int main(){
    int arr[3][3]={1,2,3,4,5,6,7,8,9};
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            cout<<arr[i][j]<<" ";
        }
        cout<<endl;
    }

int a=5;
int b=3;
for(int i=0;i<3-1;i++){
    for(int j=i+1;j<3;j++){
        swap(arr[i][j],arr[j][i]);
    }
}

cout<<endl<<" next    ///"<<endl;
 for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            cout<<arr[i][j]<<" ";
        }
        cout<<endl;
    }
cout<<endl<<" rotated   ///"<<endl;
int rot[3][3];
 for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
rot[j][3-1-i]=arr[i][j];
        }
    }
 for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            cout<<rot[i][j]<<" ";
        }
        cout<<endl;
    }
    return 0;
}