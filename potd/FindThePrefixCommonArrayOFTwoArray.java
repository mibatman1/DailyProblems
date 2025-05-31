package dailyproblems.potd;

public class FindThePrefixCommonArrayOFTwoArray {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int freq[]=new int[A.length+1];
        int count[]=new int[A.length];
        int cnt=0;
        for(int i=0;i<A.length;i++)
        {
            freq[A[i]]+=1;
            if(freq[A[i]]==2)
                cnt++;
            freq[B[i]]+=1;
            if(freq[B[i]]==2)
                cnt++;
            count[i]=cnt;
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[]={1,3,2,4};
        int arr1[]={1,2,3,4};
        FindThePrefixCommonArrayOFTwoArray findThePrefixCommonArrayOFTwoArray=new FindThePrefixCommonArrayOFTwoArray();
        System.out.println(findThePrefixCommonArrayOFTwoArray.findThePrefixCommonArray(arr, arr1));
    }
}
