package potd;

public class CountServerThatCommunicate 
{
    public int countServers(int[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;
        int row[]=new int[n];
        int col[]=new int[m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && (row[i]>1 || col[j]>1))
                {
                    count++;
                }
            }
        }
        return count;   
    }

    public static void main(String[] args) {
        CountServerThatCommunicate countServerThatCommunicate=new CountServerThatCommunicate();
        int arr[][]={{1,0},{1,1}};
        System.out.println(countServerThatCommunicate.countServers(arr));
    }
}
