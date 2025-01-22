package potd;

import java.util.HashMap;
import java.util.Map;

public class FirstCompletelyPaintedRowOrColumn 
{
    public int firstCompleteIndex(int[] arr, int[][] mat) 
    {
        int n=mat.length;
        int r[]=new int[mat.length];
        int c[]=new int[mat[0].length];
        Map<Integer, int[]>mp=new HashMap<>();
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                mp.put(mat[i][j], new int[]{i,j});
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            var it=mp.get(arr[i]);
            int rr=it[0];
            var cc=it[1];

            r[rr]++;
            c[cc]++;

            if(r[rr]==n || c[cc]==mat[0].length)
            {
                return i;
            }
        }
        return -1;   
    }

    public static void main(String[] args) {
        FirstCompletelyPaintedRowOrColumn firstCompletelyPaintedRowOrColumn=new FirstCompletelyPaintedRowOrColumn();
        int arr[]={1,4,5,2,6,3};
        int arr1[][]={{4,3,5},{1,2,6}};
        System.out.println(firstCompletelyPaintedRowOrColumn.firstCompleteIndex(arr, arr1));
    }
}
