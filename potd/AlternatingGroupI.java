package dailyproblems.potd;

public class AlternatingGroupI 
{
    public int numberOfAlternatingGroups(int[] colors) 
    {
        int n=colors.length;
        int count=0;
        for(int i=0;i<colors.length;i++)
        {
            int prev=colors[(i-1+n)%n];
            int curr=colors[i];
            int next=colors[(i+1+n)%n];

            if(prev!=curr && curr!=next)
                count++;
        }
        return count;   
    }
}
