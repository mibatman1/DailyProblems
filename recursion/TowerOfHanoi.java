package recursion;

public class TowerOfHanoi 
{
    public int towerOfHanoi(int n, int from, int to, int aux) 
    {
        if(n==1)
            return n;
        towerOfHanoi(n, from, to, aux-1);
        towerOfHanoi(n, to, from, aux-1);
    }
}
