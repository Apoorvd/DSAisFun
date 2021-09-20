package com.array;


import com.sun.jdi.connect.spi.Connection;

import java.util.*;
import java.util.Collections;


public class aew {
    public static void main(String[] args) {

        aew obj = new aew();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(10);
        arrayList.add(25);
        arrayList.add(35);
        arrayList.add(60);

        PairInt p = obj.selectPackages(90,5,arrayList);
        System.out.println(p.first);
//        System.out.println(obj.removeProducts(4,arrayList,1));
    }

    PairInt selectPackages(int truckSpace, int numPackages, ArrayList<Integer> packageSpaces)
    {
        PairInt res = new PairInt(-1,-1);
        if(truckSpace < 30)
            return res;
        int target = truckSpace - 30;
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<numPackages;i++) {
            if(map.containsKey(packageSpaces.get(i))) {
                if(packageSpaces.get(i) > max || packageSpaces.get(map.get(packageSpaces.get(i))) > max) {
                    res.first = map.get(packageSpaces.get(i));
                    res.second = i;
                    max = Math.max(packageSpaces.get(i), packageSpaces.get(map.get(packageSpaces.get(i))));
                }
            }
            map.put(target - packageSpaces.get(i), i);
        }
        return res;
    }

//    PairInt selectPackages(int truckSpace, int numPackages, ArrayList<Integer> packageSpaces)
//    {
//        PairInt res = new PairInt(-1,-1);
//        if(truckSpace < 30)
//            return res;
//        int spaceLeft = truckSpace -30;
//        HashMap<Integer,Integer> map= new HashMap<>();
//        int i = 0;
//
//        int remain = 0;
//        while(i < numPackages) {
//            remain = spaceLeft - packageSpaces.get(i);
//            if (map.containsKey(remain)) {
//                return new
//                        PairInt(map.get(remain), i);
//            }
//            map.put(packageSpaces.get(i), i);
//            i++;
//        }
//        return res;
//    }

    int removeProducts(int num,ArrayList<Integer> ids, int rem) {
        HashMap<Integer,
                Integer> numToFreq = new HashMap<>();

        for (int i = 0; i < num; i++) {
            numToFreq.put(ids.get(i),
                    numToFreq.getOrDefault(ids.get(i), 0) + 1);
        }
        int result = 0;

return 0;
    }


//     int removeProducts(int num,ArrayList<Integer> ids, int rem)
//    {
//        HashMap<Integer,
//                Integer> numToFreq = new HashMap<>();
//
//        for(int i = 0 ; i < num ; i++)
//        {
//            numToFreq.put(ids.get(i),
//                    numToFreq.getOrDefault(ids.get(i), 0) + 1);
//        }
//        int result = 0;
//
//        PriorityQueue<Integer> minHeap =
//                new PriorityQueue<Integer>();
//        for(Map.Entry<Integer,
//                Integer> p : numToFreq.entrySet())
//        {
//            if(p.getValue() == 1)
//                ++result;
//            else
//                minHeap.add(p.getValue());
//        }
//
//        while(rem != 0 && !minHeap.isEmpty())
//        {
//
//            Integer t = minHeap.poll();
//            if(t == 1)
//            {
//                ++result;
//            }
//            else
//            {
//                --t;
//                --rem;
//                minHeap.add(t);
//            }
//        }
//
//        return result;
//    }

//    public static ArrayList<Connection> minimumCostConnection(int n, ArrayList<Connection> connection) {
//        HashMap<Character, List<Connection>> map = buiildMap(n, connection);
//        return bfsHelper(n, connection.get(0), map);
//    }
//
//    private static ArrayList<Connection> bfsHelper(int n, Connection startConn, HashMap<Character, List<Connection>> map) {
//        HashSet<Character> visited = new HashSet<>();
//        ArrayList<Connection> result = new ArrayList<>();
//
//        // sort queue based on cost
//        Queue<Connection> pq = new PriorityQueue<Connection>((a, b) -> a.cost - b.cost);
//        pq.add(startConn);
//        while (!pq.isEmpty()) {
//            int size = pq.size();
//            for (int i = 0; i < size; i++) {
//                Connection currentConn = pq.poll();
//
//                // stop when processed
//                if (visited.contains(currentConn.from))
//                    continue;
//
//                result.add(currentConn);
//                visited.add(currentConn.from); // only place set visited
//
//                List<Connection> nextconns = map.get(currentConn.to);
//                for (Connection nextconn : nextconns) {
//                    pq.add(nextconn);
//                }
//            }
//        }
//
//        return result;
//    }
//
//    private static HashMap<Character, List<Connection>> buiildMap(int n, List<Connection> connections) {
//        HashMap<Character, List<Connection>> map = new HashMap<>();
//
//        for (char c = 'A'; c <= 'E'; c++)
//            map.put(c, new ArrayList<>());
//
//        int len1 = connections.size();
//        for (int i = 0; i < len1; i++) {
//            Connection conn = connections.get(i);
//            map.get(conn.from).add(conn);
//            map.get(conn.to).add(conn);
//        }
//        return map;
//    }

}
class PairInt
{
    int first, second;
    PairInt()
    {}
    PairInt(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
};