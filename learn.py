


# def reverse(string):
#     reversed_string=""
#     for char in string :
#         reversed_string=char + reversed_string
#     return reversed_string




# def checkpali(string):
#     if reverse(string)==string:
#         print("it is a palindrome")
#     else:
#         print("its not a palindrome")
#     return 0       

# string=input("enter a string \n")
# checkpali(string)

# array=[1,2,83,12,8,93]

# def bigis(array):
#     biggest=-1
#     for num in array:
#         if num>biggest:
#             biggest=num
#     print(biggest)       
#     return 0

# bigis(array)


# input= [1, 5, 4, 6, 3, 2, 8]
# def findmiss(array):
#     sum=0
#     array_sum=0
   
#     for i in range(1,len(array)+2):
#         sum+=i
    
#     for num in array:
#         array_sum+=num
   
    
#     missing_num=sum-array_sum
#     print(missing_num)
#     return 0

# findmiss(input)