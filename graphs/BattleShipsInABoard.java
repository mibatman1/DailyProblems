package dailyproblems.graphs;

import java.util.Arrays;

public class BattleShipsInABoard 
{
    public int countBattleships(char[][] board) {
        boolean vis[][]=new boolean[board.length][board[0].length];
        Arrays.fill(vis, false);
        int cnt=0;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='X')
                {
                    cnt++;
                    dfs(board, vis, i, j);
                }
            }
        }
        return cnt;
    }

    void dfs(char board[][], boolean vis[][], int r, int c)
    {
        vis[r][c]=true;
        int delRow[]={-1, 0, 1, 0};
        int delCol[]={0, 1, 0, -1};
        for(int i=0;i<4;i++)
        {
            int nr=r+delRow[i];
            int nc=c+delCol[i];
            if(nr<board.length && nr>=0 && nc<board[0].length && nc>=0 && board[nr][nc]=='X' && vis[nr][nc]==false)
            {
                dfs(board, vis, nr, nc);
            }
        }
    }
}
