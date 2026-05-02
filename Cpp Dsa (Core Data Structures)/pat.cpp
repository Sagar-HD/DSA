#include <iostream>
#include<list>
using namespace std;

void reverse(list<int> &arr,int i,int j){

while(i<j)
{
    std::list<int>::iterator it = arr.begin();
     std::advance(it, i); 
     std::list<int>::iterator it1 = arr.begin();
     std::advance(it1, j); 
int temp=*it;
*it=*it1;
*it1=temp;
i++;
j--;



}


}

int main(){
    list<int> arr;
    arr.push_back(1);
    arr.push_back(2);
    arr.push_back(3);
    arr.push_back(4);
    arr.push_back(5);
    for (std::list<int>::iterator it = arr.begin(); it != arr.end(); ++it) {
        std::cout << *it << " ";
    }
cout<<endl;
    int k=3;
    k=k%arr.size();
  
    reverse(arr,0,arr.size()-k-1);
    reverse(arr,arr.size()-k,arr.size()-1);
    
    arr.reverse();
  

    for (std::list<int>::iterator it = arr.begin(); it != arr.end(); ++it) {
        std::cout << *it << " ";
    }


    return 0;
}