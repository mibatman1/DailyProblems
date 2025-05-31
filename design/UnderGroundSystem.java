package dailyproblems.design;

import java.util.HashMap;
import java.util.Map;

public class UnderGroundSystem
{
    private Map<Integer, Person>checkIn;
    private Map<String, HashMap<String, Journey>> journeyMap;

    public UnderGroundSystem() {
        checkIn=new HashMap<>();
        journeyMap=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new Person(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        if(!checkIn.containsKey(id))
            return;
        
        var totalTime=t-checkIn.get(id).time;
        var startStation=checkIn.get(id).name;
        if(!journeyMap.containsKey(startStation)|| !journeyMap.get(startStation).containsKey(stationName))
        {
            journeyMap.putIfAbsent(startStation, new HashMap<>());
            journeyMap.get(startStation).put(stationName, new Journey(totalTime, 1));
        }
        else
        {
            var jour=journeyMap.get(startStation).get(stationName);
            jour.add(totalTime, 1);
            journeyMap.get(startStation).put(stationName, jour);
            checkIn.remove(id);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        long tripSum=journeyMap.get(startStation).get(endStation).totalTime;
        long count=journeyMap.get(startStation).get(endStation).totalTrip;
        return tripSum/count;
    }
}

class Person
{
    String name;
    int time;

    public Person(String name, int time)
    {
        this.name=name;
        this.time=time;
    }
}

class Journey
{
    long totalTime;
    long totalTrip;

    public Journey(long totalTime, long totalTrip)
    {
        this.totalTime=totalTime;
        this.totalTrip=totalTrip;
    }

    public void add(long totalTime, long totalTrip)
    {
        this.totalTime+=totalTime;
        this.totalTrip+=totalTrip;
    }
}