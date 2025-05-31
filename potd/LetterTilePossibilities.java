package dailyproblems.potd;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/letter-tile-possibilities/editorial/?envType=daily-question&envId=2025-02-17
public class LetterTilePossibilities 
{
    public int numTilePossibilities(String tiles) {
        // Set<String>str=new HashSet<>();
        // boolean used[]=new boolean[tiles.length()];
        // solve(tiles,"",str,used);
        //return str.size()-1;

        // Approach 2
        var charCount=new int[26];
        for(var ch:tiles.toCharArray())
        {
            charCount[ch-'A']++;
        }
        return solve1(charCount);
    }

    // Approach 1
    private void solve(String tiles, String sub, Set<String>str,boolean used[])
    {
        str.add(sub);
        for(int i=0;i<tiles.length();i++)
        {
            if(!used[i])
            {
                used[i]=true;
                solve(tiles, sub+tiles.charAt(i), str, used);
                used[i]=false;
            }
        }
    }

    // Approach 2
    private int solve1(int charCount[])
    {
        int totalCount=0;
        for(int i=0;i<26;i++)
        {
            if(charCount[i]==0)
                continue;
            charCount[i]--;
            totalCount=1+solve1(charCount);
            charCount[i]++;
        }
        return totalCount;
    }

    public static void main(String[] args) {
        String str="AAB";
        LetterTilePossibilities letterTilePossibilities=new LetterTilePossibilities();
        System.out.println(letterTilePossibilities.numTilePossibilities(str));
    }
}


// public int numTilePossibilities(String tiles) {
//     Set<String> sequences = new HashSet<>();
//     int len = tiles.length();
//     boolean[] used = new boolean[len];

//     // Generate all possible sequences including empty string
//     generateSequences(tiles, "", used, sequences);

//     // Subtract 1 to exclude empty string from count
//     return sequences.size() - 1;
// }

// public void generateSequences(String tiles,String current,boolean[] used,Set<String> sequences) {
//     // Add current sequence to set
//     sequences.add(current);

//     // Try adding each unused character to current sequence
//     for (int pos = 0; pos < tiles.length(); pos++) {
//         if (!used[pos]) {
//             used[pos] = true;
//             generateSequences(tiles,current + tiles.charAt(pos),used,sequences);
//             used[pos] = false;
//         }
//     }
// }
// }
