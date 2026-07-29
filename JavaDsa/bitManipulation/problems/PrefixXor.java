package problems;

public class PrefixXor {
    static int getXorInRange(int[] arr,int start,int end){
        int[] prefixXor=new int[arr.length];
        prefixXor[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefixXor[i]=prefixXor[i-1]^arr[i];
        }
        return prefixXor[start-1]^prefixXor[end];

    }
    public static void main(String[] args) {
        int[] arr={3,2,45,3,2,67};
        System.out.println(getXorInRange(arr, 2, 4));
        System.out.println(45^3^2);
        //perfect

    }
    
}
