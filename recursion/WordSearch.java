package recursion;

// https://leetcode.com/problems/word-search/description/?envType=problem-list-v2&envId=mk7dslmg
public class WordSearch 
{
    public boolean exist(char[][] board, String word) 
    {
        boolean vis[][]=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(i))
                {
                    vis[i][j]=true;
                    if(solve(board, word, i, j, 1, vis))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean solve(char board[][], String word, int r, int c, int idx, boolean vis[][])
    {
        if(idx==word.length())
            return true;
        int delRow[]={-1,0,+1,0};
        int delCol[]={0,+1,0,-1};
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<4;i++)
        {
            int rr=r+delRow[i];
            int cc=c+delCol[i];
            if(rr<n && rr>=0 && cc<m && cc>=0 && vis[rr][cc]!=true && board[rr][cc]==word.charAt(idx))
            {
                vis[rr][cc]=true;
                if(solve(board, word, rr, cc, idx+1, vis))
                    return true;
            }
        }
        vis[r][c]=false;
        return false;
    }

    public static void main(String[] args) {
        char arr[][]={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String wrod="SEE";
        WordSearch wordSearch=new WordSearch();
        System.out.println(wordSearch.exist(arr, wrod));
    }
}
