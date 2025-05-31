package dailyproblems.griddp;

public class MaxNonNegativeProduct 
{
    public int maxProductPath(int[][] grid) {
        return solve(grid, grid.length-1, grid[0].length-1);
    }

    // Recursion
    private int solve(int grid[][], int n, int m)
    {
        if(n==0 && m==0)
            return grid[0][0];
        if(n<0 || m<0)
            return Integer.MIN_VALUE;
        int right=grid[n][m]*solve(grid, n, m-1);
        int down=grid[n][m]*solve(grid, n-1, m);
        return Math.max(right, down);
    }

    public static void main(String[] args) {
        MaxNonNegativeProduct maxNonNegativeProduct=new MaxNonNegativeProduct();
        int arr[][]={{1,-2,1},{1,-2,1},{3,-4,1}};
        System.out.println(maxNonNegativeProduct.maxProductPath(arr));
    }
}
