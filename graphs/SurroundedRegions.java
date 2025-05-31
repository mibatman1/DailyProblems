package dailyproblems.graphs;

public class SurroundedRegions 
{
    void dfs(int row, int col, int vis[][], char board[][], int delRow[], int delCol[])
    {
        int n=board.length;
        int m=board[0].length;
        vis[row][col]=1;
        for(int i=0;i<4;i++)
        {
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow<n && nrow>=0 && ncol<m && ncol>=0 && vis[nrow][ncol]==0 && board[nrow][ncol]=='0')
            {
                dfs(nrow, ncol, vis, board, delRow, delCol);
            }
        }
    }

    public void solve(char[][] board) 
    {
        int n=board.length;
        int m=board[0].length;
        int vis[][]=new int[n][m];
        int delRow[]={-1,0,1,0};
        int delCol[]={0,1,0,-1};
        for(int j=0;j<m;j++)
        {
            if(board[0][j]=='0' && vis[0][j]==0)
            {
                dfs(0, j, vis, board, delRow, delCol);
            }
            if(board[n-1][j]=='0' && vis[0][n-1]==0)
            {
                dfs(n-1, j, vis, board, delRow, delCol);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(board[i][0]=='0' && vis[i][0]==0)
            {
                dfs(i, 0, vis, board, delRow, delCol);
            }

            if(board[i][m-1]=='0' && vis[i][m-1]==0)
            {
                dfs(i, m-1, vis, board, delRow, delCol);
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='0' && vis[i][j]==0)
                {
                    board[i][j]='X';
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        char arr[][]={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        SurroundedRegions surroundedRegions=new SurroundedRegions();
        surroundedRegions.solve(arr);
        // for(int i=0;i<arr.length;i++)
        // {
        //     for(int j=0;j<arr[0].length;j++)
        //     {
        //         System.out.print(arr[i][j]);
        //     }
        //     System.out.println(" ");
        // }
    }
}
