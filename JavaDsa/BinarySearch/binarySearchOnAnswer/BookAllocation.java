package binarySearchOnAnswer;

public class BookAllocation {
    static int maxPagesAllocatedWithMinPossible(int[] books,int students){
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i:books){
            sum+=i;
            max=Math.max(max, i);

        }
        int start=max;
        int end=sum;
      
        while(start<end){
            int mid=start+(end-start)/2;
            if(isAllocationPossible(mid,students,books)){
               
                end=mid;
                
            }
            else{
                start=mid+1;
            }

        }
        return start;

    }
    private static boolean isAllocationPossible(int mid, int students,int[] books) {
        int pages=0;
        int usedStudent=1;
        for(int i : books){
            if(pages+i<=mid){
                pages+=i;
            }
            else{
                usedStudent++;
                pages=i;
            }

        }
        return usedStudent <= students;
    }
    public static void main(String[] args) {
       int[] books = {12, 34, 67, 90};
       int students = 2;
       System.out.println(maxPagesAllocatedWithMinPossible(books, students));
    }
    
}
