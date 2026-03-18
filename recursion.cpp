#include <iostream>
#include <vector>
using namespace std;

void mergep(int arr[],int start,int end,int mid){
 int i = start, j = mid + 1;
    int k = 0;
    int temp[end - start + 1]; // temporary array

    while (i <= mid && j <= end) {
        if (arr[i] < arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
        }
    }

    while (i <= mid) {
        temp[k++] = arr[i++];
    }

    while (j <= end) {
        temp[k++] = arr[j++];
    }

    // Copy merged elements back to the original array
    for (int i = 0; i < k; ++i) {
        arr[start + i] = temp[i];
    }
}


void sort(int arr[],int start,int end){
if(start>=end)
{
  return;
}
  int mid=start+(end-start)/2;
  sort(arr,start,mid);
  sort(arr,mid+1,end);
mergep(arr,start,end,mid);




};
void printn(int n){
    if(n==0){
        return;
    }
  
    printn(n-1);
    cout<<n<<endl;
}
void printhelper(int i,int N){
    if(i>N){
        return;
    }
  cout<<i<<endl;
    printhelper(i+1,N);
    
}
void printn1(int n){
    printhelper(1,n);
}

void printarr(int arr[],int start,int end){
    if(end<start){
        return;
    }
     
    printarr(arr,start,end-1);
   cout<<arr[end]<<endl;
}
int sumarr(int arr[],int n){
    if(n<0){
        return 0;
    }
     
    return arr[n]+sumarr(arr,n-1);
   
}
int min_elem(int arr[],int n){
    if(n==1){
        return arr[0];
    }
    return min(arr[n-1],min_elem(arr,n-2));
}
bool palster(string s , int i,int j){
   if(i>j){
    return true;
   }
   if(s[i]!=s[j]){
    return false;
   }else{
    return palster(s,i+1,j-1);
   }
}

int countvol(string s,int i,int n){
    if(i==n){
        return 0;
    }
    if(s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u'){
return 1+countvol(s,i+1,n);
    }
    else{
        return countvol(s,i+1,n);
    }
}
void revarr(int arr[],int n,int i ,int j){
    if(i>=j){
        return;
    }
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
    revarr(arr,n,i+1,j-1);
    
}
int bin(int arr[],int start,int end,int key){
 if(start>end){
    return -1;
 }
 int mid=start+(end-start)/2;
    if(arr[mid]==key){
        return mid;
    }
    else if(arr[mid]>key){
       return bin(arr,start,mid-1,key);
    }
    else{
       return bin(arr,mid+1,end,key);
    }
return -1;
}
void merge(int arr[],int start,int end,int mid){
int i=start;
int j=mid+1;
int k=0;
int temp[end-start+1];
while(i<=mid&&j<=end){
    if(arr[i]<arr[j]){
        temp[k]=arr[i];
        i++;
        k++;

    }else{
        temp[k]=arr[j];
        j++;
        k++;
    }
   

}
 while(i<=mid){
      temp[k]=arr[i]  ;
      i++;
      k++;
    }
     while(j<=end){
      temp[k]=arr[j]  ;
      j++;
      k++;
    }
    k=0;
    int total=end-start;
    while(k<=total){
        arr[start]=temp[k];
        start++;
        k++;
    }

}
void msort(int arr[],int start,int end){
    if(start>=end){
        return;
    }
    int mid=start+(end-start)/2;
    msort(arr,start,mid);
    msort(arr,mid+1,end);
    merge(arr,start,end,mid);
    cout<<endl<<"sorted till now"<<endl;
    printarr(arr,start,end);
}
void swap(int arr[],int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
}
int partition(int arr[],int start,int end){
    int pivot=arr[start];
    int i=start+1;
    int j=end;
    while(i<=j){
        while(i<=j&&arr[i]<=pivot){
            i++;
        }
         while(i<=j&&arr[j]>=pivot){
            j--;
        }
        
       if (i < j) {
            swap(arr, i, j);
        }


    }
    swap(arr,j,start);
    cout<<arr[j]<<"placed correctly array is :"<<endl;
    printarr(arr,start,end);
    return j;
}
void quicksort(int arr[],int start,int end){
if(start>=end){
    return;
}
int m=partition(arr,start,end);
quicksort(arr,start,m-1);
quicksort(arr,m+1,end);




}

void printsub(int arr[],int i,int n,string s=""){
if(i>n){
    cout<<"{"<<s<<"}"<<endl;
    return;
}

printsub(arr,i+1,n,s+to_string(arr[i])+",");
printsub(arr,i+1,n,s+"");

}

bool tarsubsum(int arr[],int target, int index,vector <int> & res,int n){
    if(index>n||target<0){
        return 0;
    }
    if(target==0){
        return 1;
    }

res.push_back(arr[index]);
if(tarsubsum(arr,target-arr[index],index+1,res,n)){
    return 1;
}
res.pop_back();
if(tarsubsum(arr,target,index+1,res,n)){
  return 1;
}
return 0;

}
void alltarsubsum(int arr[],int target, int index,vector <vector<int>> & ans,int n,vector<int> &res){
    if(index>n||target<0){
        return ;
    }
    if(target==0){
        ans.push_back(res); 
        return ;
    }

res.push_back(arr[index]);
alltarsubsum(arr,target-arr[index],index+1,ans,n,res);
res.pop_back();
alltarsubsum(arr,target,index+1,ans,n,res);
 
return;

}
void targetsumrep(int arr[],int target,int index,int n,vector<vector<int>> &ans,vector<int> &res){
 
    if(target==0){
        ans.push_back(res);
        return;
    }
    if(target<0||index>n){
    return;
   }

res.push_back(arr[index]);
targetsumrep(arr,target-arr[index],index,n,ans,res);
res.pop_back();
targetsumrep(arr,target,index+1,n,ans,res);

    }
int main(){
int arr[]={6,3,4,5,1};
printarr(arr,0,4);
// sort(arr,0,4);


// printarr(arr,4);
// cout<<endl<<sumarr(arr,4)<<endl;
// printn1(5);
// cout<<"min element :"<<min_elem(arr,5)<<endl;
// cout<<palster("motrom",0,5)<<endl;
// cout<<countvol("aeiouxyz",0,8)<<endl;
// revarr(arr,5,0,4);
// msort(arr,0,4);
// quicksort(arr,0,4);
// cout<<"final sort"<<endl;
// printarr(arr,0,4);
// printsub(arr,0,4);
// vector<int> sub;
// tarsubsum(arr,9,0,sub,4);
// for(int i=0;i<sub.size();i++){
//     cout<<sub[i];
// }
// vector<vector<int>> allsub;
// sub.clear();
// alltarsubsum(arr,9,0,allsub,4,sub);
// for(int i = 0; i < allsub.size(); i++){   
//     for(int j = 0; j < allsub[i].size(); j++){
//         cout << allsub[i][j];
//     }
//     cout << endl;
// }
// cout<<bin(arr,0,4,5)<<endl;
vector<vector<int>> ans;
vector<int> res;
targetsumrep(arr,9,0,4,ans,res);
for (int i = 0; i < ans.size(); i++) {   
    for (int j = 0; j < ans[i].size(); j++) {
        cout << ans[i][j] << " ";
    }
    cout << endl;
}

    return 0;
}