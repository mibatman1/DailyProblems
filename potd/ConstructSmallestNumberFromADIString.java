package dailyproblems.potd;

import java.util.Stack;

public class ConstructSmallestNumberFromADIString 
{
    public String smallestNumber(String pattern) 
    {
        StringBuilder str=new StringBuilder();
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<=pattern.length();i++)
        {
            st.push(i+1);
            if(i==pattern.length() || pattern.charAt(i)=='I')
            {
                while(!st.isEmpty())
                {
                    str.append(st.pop());
                }
            }
        }
        return str.toString();
    }

    class Solution {

        public String smallestNumber(String pattern) {
            StringBuilder result = new StringBuilder();
    
            // Start building the sequence by calling the helper function
            buildSequence(0, 0, pattern.toCharArray(), result);
            // Reverse the final result
            return result.reverse().toString();
        }
    
        // Recursively build the sequence
        int buildSequence( int currentIndex, int currentCount, char[] patternArray, StringBuilder result) {
            if (currentIndex != patternArray.length) 
            {
                if (patternArray[currentIndex] == 'I') 
                    buildSequence(currentIndex + 1,currentIndex + 1,patternArray,result);
                else 
                    currentCount = buildSequence(currentIndex + 1,currentCount,patternArray,result);
            }
    
            result.append(currentCount + 1);
            // Return the next count for the sequence
            return currentCount + 1;
        }
    }


    public static void main(String[] args) {
        String str="IIIDIDDD";
        ConstructSmallestNumberFromADIString constructSmallestNumberFromADIString=new ConstructSmallestNumberFromADIString();
        System.out.println(constructSmallestNumberFromADIString.smallestNumber(str));
    }
}
