package dailyproblems.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ShortestPathToGetAllKeys 
{
    void solve(String grid[], int vis[][], int r, int c, Map<Character, Character>mp)
    {
        vis[r][c]=1;
        int n=grid.length;
        int m=grid[0].length();
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(r, c));
        while(!q.isEmpty())
        {
            var node=q.poll();
            var rr=node.first;
            var cc=node.second;
            int delRow[]={-1, 0, 1, 0};
            int delCol[]={0, 1, 0, -1};
            for(int i=0;i<4;i++)
            {
                int rn=rr+delRow[i];
                int cn=cc+delCol[i];
                if(rn< n && rn>=0 && cn<m && cn>=0)
                {
                    char ch=grid[rn].charAt(cn);
                    if(ch=='#' || (ch>='A' || ch<='F') && !mp.containsKey(Character.toLowerCase(ch)))
                        continue;
                    else if(ch>='a' && ch<='f')
                    {
                        vis[rn][ch]=1;
                        q.add(new Pair(rn, cn));
                        mp.put(ch, Character.toUpperCase(ch));
                    }
                    else
                    {
                        vis[rn][ch]=1;
                        q.add(new Pair(rn, cn));
                    }
                }
            }
        }

    }

    public int shortestPathAllKeys(String[] grid) {
        int n=grid.length;
        int m=grid[0].length();
        int vis[][]=new int[n][m];
        Map<Character, Character>mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            Arrays.fill(vis[i],0);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if((grid[i].charAt(j)=='@') && vis[i][j]!=1)
                {
                    solve(grid, vis, i, j, mp);
                }
            }
        }
        int totalKeys=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'z') {
                    totalKeys++;
                }
            }
        }
        return mp.size()==totalKeys?mp.size():-1;
    }
}

class Pair
{
    int first, second;
    public Pair(int first, int second)
    {
        this.first=first;
        this.second=second;
    }
}
