package trees;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private List<String>trie;

    public Trie() {
        trie=new ArrayList<>();    
    }
    
    public void insert(String word) {
        trie.add(word);
    }
    
    public boolean search(String word) {
        if(trie.contains(word))
            return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        for(var it:trie)
        {
            if(it.startsWith(prefix))
                return true;
        }
        return false;
    }
}
