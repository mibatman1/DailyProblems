package dailyproblems.linerdp;

public class FormLargestIntegerThatAddsUpToTarget 
{
    public String largestNumber(int[] cost, int target) 
    {
        return solve(cost, target, cost.length-1);
    }

    private String solve(int cost[], int tar, int idx)
    {
        
    }

    public static void main(String[] args) {
        FormLargestIntegerThatAddsUpToTarget formLargestIntegerThatAddsUpToTarget=new FormLargestIntegerThatAddsUpToTarget();
        int arr[]={4,3,2,5,6,7,2,5,5};
        int tar=9;
        System.out.println(formLargestIntegerThatAddsUpToTarget.largestNumber(arr, tar));
    }
}
