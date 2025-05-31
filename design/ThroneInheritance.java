package dailyproblems.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThroneInheritance 
{
    private String king;
    private Map<String, Person>mp;

    public ThroneInheritance(String kingName) {
        this.king=kingName;
        mp=new HashMap<>();
        this.birth(null, kingName);
    }
    
    public void birth(String parentName, String childName) {
        Person person=new Person(parentName, childName);
        mp.put(childName, person);
        if(parentName==null)
            return;
        mp.get(parentName).child.add(childName);
    }
    
    public void death(String name) {
        mp.get(name).isAlive=false;
    }
    
    public List<String> getInheritanceOrder() {
        List<String>ans=new ArrayList<>();
        getOrder(king, ans);
        return ans;
    }

    private void getOrder(String king, List<String>ans)
    {
        Person person=mp.get(king);
        if(person.isAlive)
        {
            ans.add(king);
        }
        for(var it:person.child)
        {
            getOrder(it, ans);
        }
    }

    public static void main(String[] args) {
        ThroneInheritance throneInheritance=new ThroneInheritance("king");
    }
}

class Person
{
    private String parent;
    private String name;
    List<String>child;
    boolean isAlive;

    public Person(String parent, String name)
    {
        this.parent=parent;
        this.name=name;
        child=new ArrayList<>();
        this.isAlive=true;
    }
}
