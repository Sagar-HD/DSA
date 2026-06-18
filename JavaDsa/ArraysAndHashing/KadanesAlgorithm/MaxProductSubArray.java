package KadanesAlgorithm;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] arr={1,2,-3,6,0,1,2};
        //here we cant just rely on max at present 
        // min if encounters another - tive num it becomes max
        //so we main both mic=n and max product
   int maxProduct=arr[0];
   int minProduct=arr[0];
   int finalAns=arr[0];
        for(int i=1;i<arr.length;i++){

            int cur=arr[i];

            if(arr[i]<0){

                //swap min and max product bcs it does that 
                //negative number makes min a max and max a min so swaping makes it crt to compare with cur number
                int temp=maxProduct;
                maxProduct=minProduct;
                minProduct=temp;
            }
            maxProduct=Math.max(maxProduct,cur);
            minProduct=Math.min(minProduct, cur);
            finalAns=Math.max(finalAns,maxProduct);



        }
        System.out.println(finalAns);

    }
    
}
