def magic(inp1,inp2,inp3):
    rotated_array=[0,0,0,0,0,0,0]
    
    
    for j in range(inp2):
        rotated_array[j]=inp1[j+inp3-inp2]
 
    m=0
    for k in range(inp2,inp3):
         if(m<inp3-inp2):
           rotated_array[k]=inp1[m]
         m=m+1
    print(rotated_array)    
    p=0
    res=0
    
    for l in range(inp3):
       
        if(m%2==0):
            res+=l
        else:
            res-=l
      
    print(res) 
             
    return 0       
        
magic([-1,2,4,-8,9],2,5)