package dailyproblems.recursion;

public class ReverseAnArray 
{
    private void reverse(int arr[], int l, int r)
    {
        if(l>=r)
            return;
        swap(arr[l], arr[r]);
        reverse(arr, l+1, r-1);
    }

    private void swap(int arr)
    {

    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,2};    
    }
}
