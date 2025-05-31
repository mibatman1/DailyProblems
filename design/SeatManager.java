package dailyproblems.design;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/seat-reservation-manager/?envType=problem-list-v2&envId=mbnk3qwv
// public class SeatManager 
// {
//     private int seat[];

//     public SeatManager(int n) {
//         seat=new int[n+1];
//         Arrays.fill(seat, 0);
//     }
    
//     // 1->0,2->0,3->0,4->0,5->0
//     public int reserve() {
//         int reservedSeat=0;
//         for(int i=1;i<seat.length;i++)
//         {
//             if(seat[i]==0)
//             {
//                 seat[i]=1;
//                 reservedSeat=i;
//                 break;
//             }
//         }
//         return reservedSeat;
//     }
    
//     public void unreserve(int seatNumber) {
//         seat[seatNumber]=0;
//     }

//     public static void main(String[] args) {
        
//     }
// }

public class SeatManager
{
    private int reservedSeat=0;
    private PriorityQueue<Integer>seats;

    public SeatManager(int n) {
        seats=new PriorityQueue<>();
        reservedSeat=1;
    }
    
    public int reserve() {
        if(!seats.isEmpty())
        {
            return seats.poll();
        }
        return reservedSeat++;
    }
    
    public void unreserve(int seatNumber) {
        seats.add(seatNumber);
    }

    public static void main(String[] args) {
        SeatManager seatManager=new SeatManager(3);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
    }
}
