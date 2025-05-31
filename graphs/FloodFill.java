package dailyproblems.graphs;

// https://www.geeksforgeeks.org/problems/flood-fill-algorithm1856/1
public class FloodFill 
{
    void dfs(int iniColor, int ans[][], int delRow[], int delCol[], int sr, int sc, int [][]image, int newColor)
    {
        ans[sr][sc]=newColor;
        int n=ans.length;
        int m=ans[0].length;
        for(int i=0;i<4;i++)
        {
            int nRow=sr+delRow[i];
            int nCol=sc+delCol[i];
            if(nRow<n && nRow>=0 && nCol<m && nCol>=0 && image[nRow][nCol]==iniColor && ans[nRow][nCol]!=newColor)
            {
                dfs(iniColor, ans, delRow, delCol, nRow, nCol, image, newColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int iniColor=image[sr][sc];
        int ans[][]=image;
        int delRow[]={-1,0,+1,0};
        int delCol[]={0,+1,0,-1};
        dfs(iniColor, ans, delRow, delCol, sr, sc, image, newColor);
        return ans;
    }
}
