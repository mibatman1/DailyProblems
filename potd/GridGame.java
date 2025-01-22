package potd;

// https://leetcode.com/problems/grid-game/?envType=daily-question&envId=2025-01-21
public class GridGame 
{
    public long gridGame(int[][] grid) {
        long topSum=0;
        for(int i=0;i<grid[0].length;i++)
        {
            topSum+=grid[0][i];
        }
        long bottomSum=0;
        long ans=Long.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++)
        {
            topSum-=grid[0][i];
            ans=Math.min(ans, Math.max(topSum, bottomSum));
            bottomSum+=grid[1][i];
        }
        return ans;
    }

    public static void main(String[] args) {
        GridGame gridGame=new GridGame();
        int arr[][]={{3,3,1},{8,5,1}};
        System.out.println(gridGame.gridGame(arr));
    }
}

