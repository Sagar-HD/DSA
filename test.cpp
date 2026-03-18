#include <iostream>
using namespace std;

int main() {
    int n;
   cout<<"enter a number \n";
   cin>>n;

   for(int i=1;i<=n;i++){
     
    for(int j=1;j<=n-i;j++){
        cout<<" ";
       
        
    }

    for(int k=1;k<=i;k++){
       cout<<"* ";

       
        
    }
    // for(int l=1;l<=i;l++){
    //     cout<<"*";

        
         
    //  }
    
    cout<<endl;
    
}

///
    for(int i=1;i<=n;i++){
     
        for(int j=1;j<i;j++){
            cout<<" ";
           
            
        }

        for(int k=1;k<=n-i+1;k++){
           cout<<"* ";

           
            
        }
        // for(int l=i;l<=n-1;l++){
        //     cout<<"*";
 
            
             
        //  }
        
        cout<<endl;
        
    }
    cout<<endl;
   
}