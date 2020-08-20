package Graph;

import java.util.*;

public class CheapestFlightDijkstra {
    private Graph graph;
    //HashMap<String, HashMap<String, Integer>> map;


    public CheapestFlightDijkstra() {
        // this.map = new HashMap<>();
        //System.out.println(map);
        this.graph = new Graph();
    }


    class Graph {
        HashMap<String, HashMap<String, Integer>> map;

        public Graph() {
            this.map = new HashMap<>();
            //System.out.println(map);
        }

        // builds directed graph using multimap
        public void addEdge(String vertex, HashMap<String, Integer> edgeToNeighboor) {
            // check if it contains first
            if (!map.containsKey(vertex)) {
                // retrieve it's hashmap
                map.put(vertex, edgeToNeighboor);
            } else {
                HashMap<String, Integer> adj = map.get(vertex);
                if (adj != null) {
                    for (Map.Entry<String, Integer> e : edgeToNeighboor.entrySet()) {
                        // check if adj has that value
                        if (adj.containsKey(e.getKey())) {
                            map.get(e.getKey()).put(e.getKey(), e.getValue());
                        } else {
                            adj.put(e.getKey(), e.getValue());
                        }
                    }
                }
            }
        }


        public HashMap<String, HashMap<String, Integer>> getGraph() {
            return this.map;
        }

        public List<String> getCheapestPath(String source, String dest) {
            List<String> res = new LinkedList<>();
            // starting from the source put all the elements into the queueu
            Queue<String> q = new LinkedList<>();
            HashSet<String> seen = new HashSet<>();
            // looping over map entry wil not work because doesn't guarantee starting from sourse
            HashMap<String, String> route = new HashMap<>();
            HashMap<String, Integer> cost = new HashMap<>();
            Queue<String> util = new LinkedList<>();
            util.offer(source);
            seen.add(source);
            while (!util.isEmpty()) {
                String cur = util.poll();

                // add to a normal queue for further processing
                q.offer(cur);
                // add each city and costs in the row
                if (cur.equals(source)) {
                    cost.put(cur, 0);
                } else {
                    cost.put(cur, Integer.MAX_VALUE);
                }

                // add to the route dictionary
                route.put(cur, null);
                // iterate for each adjacent towns
                HashMap<String, Integer> neighbors = map.get(cur);
                if (neighbors != null && neighbors.size() > 0) {
                    // System.out.println(neighbors);
                    // for each unseen neighboor in the queueu
                    for (String n : neighbors.keySet()) {
                        if (!seen.contains(n)) {
                            seen.add(n);
                            util.offer(n);
                        }
                    }
                }
            }

            System.out.println("util\n" + util);
            System.out.println("q\n" + q);
            System.out.println("route\n" + route);
            System.out.println("cost\n" + cost);

            //
            while (!q.isEmpty()) {
                String cur = q.poll();
                // find the cur in cost and change it's value to what it is in the graph
                if(cur.equals(source)){
                    continue;
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        CheapestFlightDijkstra myFlights = new CheapestFlightDijkstra();
        // System.out.println(myFlights.graph);
        // add new York flighrts
        HashMap<String, Integer> nyc = new HashMap<>();
        nyc.put("CH", 75);
        nyc.put("DEN", 100);
        nyc.put("DALL", 125);
        nyc.put("MIA", 70);
        myFlights.graph.addEdge("NYC", nyc);
        // add CHicago flighrs
        HashMap<String, Integer> chic = new HashMap<>();
        chic.put("SF", 25);
        chic.put("DEN", 20);
        myFlights.graph.addEdge("CH", chic);

        // add SF flights
        HashMap<String, Integer> sf = new HashMap<>();
        sf.put("LA", 45);
        myFlights.graph.addEdge("SF", sf);

        // add Denver
        HashMap<String, Integer> den = new HashMap<>();
        den.put("LA", 100);
        den.put("SF", 75);
        den.put("LA", 100);
        myFlights.graph.addEdge("DEN", den);

        // add Miami
        HashMap<String, Integer> mia = new HashMap<>();
        mia.put("DALL", 50);
        myFlights.graph.addEdge("MIA", mia);

        // adding Dallas
        HashMap<String, Integer> dal = new HashMap<>();
        dal.put("LA", 80);
        dal.put("SD", 90);
        // adding San Diego
        HashMap<String, Integer> sd = new HashMap();
        myFlights.graph.addEdge("DALL", dal);

        System.out.println(myFlights.graph.map);
        myFlights.graph.getCheapestPath("NYC", "LA");

    }

}
