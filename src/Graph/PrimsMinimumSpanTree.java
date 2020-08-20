package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Pair {
    char from, to;
    int cost;

    Pair(char from, char to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

class Node {
    int data;
    Node parent;

    Node(int data) {
        this.data = data;
        this.parent = this;
    }
}

public class PrimsMinimumSpanTree {


    public static ArrayList<Pair> findMinimumCostToConnectServers(ArrayList<Pair> list) {
        PriorityQueue<Pair> h = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.cost - o2.cost;
            }
        });
        // add the list of pairs to the queue
        for (Pair pair : list) {
            h.add(pair);
        }
        ArrayList<Pair> res = new ArrayList<>();

        //formHeap(list);
        // create an hashtable for characters
        Node node[] = new Node[26];
        for (int i = 0; i < 26; i++) {
            //[0,1,2,3,4,5,6,7,8.......26]
            node[i] = new Node(i);
        }
        HashMap<Node, Node> map = new HashMap<>();
        for(Pair pair: list){
            Node from = new Node(pair.from-'A');
            from.parent = null;
            Node to = new Node(pair.to-'A');
            to.parent = null;
            // node is assigned as a parent to itself[
            map.put(from, to);
        }
        while (h.size() > 0) {
            // Pair ele = extractMin(list);
            Pair cur = h.poll(); //[from-A,to-B,1]
            System.out.println("cur " + cur.from + ", " + cur.to);
            System.out.println("cur " + (cur.from -'A') + ", " + (cur.to - 'A'));
            // find the current's parent
            //Node parentFrom = findParent(node[cur.from - 'A'], new ArrayList<>());
            Node curNode = new Node(cur.from -'A');
            curNode.parent = null;

            System.out.println("cur node: " + curNode.data);
           // Node parentFrom = map.get(new Node(0));
            Node curT =node[cur.to - 'A'];
            curT.parent = null;
            Node parentFrom = map.get(curT);
            // find the current's child. It will be one since assumption in the description
            Node parentTo = findParent(node[cur.to - 'A'], new ArrayList<>());
            System.out.println("parentFrom.data " + parentFrom.data + " - " + "parentTo.data "+ parentTo.data );
            // check for the cycle

           // return parents;
            if (parentFrom != parentTo) {
              //  map.get(parentTo.data).parent = parentFrom;
              //  System.out.println("map");
               // System.out.println("parentTo " + parentTo.data + "ap.get(parentTo).parent: " + map.get(parentTo).parent);

                parentTo.parent = parentFrom;
                //System.out.println("non map");
                //System.out.println("parentTo " + parentTo.data + ", parentTo.parent: " + parentTo.parent.data);
                        res.add(new Pair(cur.from, cur.to, cur.cost));
            }
        }
        System.out.println("Finished findmintree");
        return res;
    }
// in the beginning each parent is a parent to himself this.parent = this;
    // create a map of each node and it's parent
//    public static HashMap<Node, Node> createParentMap(ArrayList<Pair> list){
//        HashMap<Node, Node> parents = new HashMap<>();
//        for(Pair pair: list){
//            parents.put(new Node(pair.from-'A'), new Node(pair.to-'A'));
//        }
//
//        return parents;
//
//    }

    public static Node findP(Node startChild, ArrayList<Pair> list, HashMap<Node, Node> parents){
        //HashMap<Node, Node> parents = createParentMap(list);
        return parents.get(startChild);
//        while(startChild != parent){
//            child
//        }
    }

    public static Node findParent(Node node, ArrayList<Node> path) {
        System.out.println(node.parent == node);
        if (node.parent == node) { // default case
            // 0 parent - 0
            System.out.println("path size: " + path.size());
            // if parent is a parent to itself, this will be skipped
            // because 0 is not less than 0
            for (int i = 0; i < path.size(); i++) {

                path.get(i).parent = node;
                System.out.print(path.get(i).data + ", ");
            }

            return node;
        }
        path.add(node);
        //System.out.println(path);
        return findParent(node.parent, path);
    }


    public static ArrayList<Pair> prims(ArrayList<Pair> list){
        if(list.isEmpty())throw new NullPointerException("The Graph is empty");

        ArrayList<Pair> mst = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.cost - o2.cost;
            }
        });

//        for(Pair e:G.get(0)){
//            pq.add(e);
//        }

        pq.add(list.get(0));
        boolean[] marked = new boolean[26];
        //marked[0] = true;
        marked[list.get(0).from-'A'] = true;
        while(!pq.isEmpty()){
            Pair e = pq.poll();
            System.out.println("pair " + e.from + ", " + e.to);

           // pq.poll();
            // if a cycle - continue to the next iteration
            if(marked[e.from -'A'] && marked[e.to-'A'])continue;

            marked[e.from-'A'] = true;
            // there will be only one edge from G.getto
           // System.out.println("e.to " + e.to);
           // Pair edge = list.get(e.to);
            Pair edge = list.get(e.to-'A');
            if(!marked[edge.to-'A']){
                pq.add(edge);
            }

//            for(Pair edge: G.get(e.to)){
//                if(!marked[edge.to]){
//                    pq.add(edge);
//                }
//            }
            marked[e.to-'A'] = true;
            mst.add(e);

        }
        return mst;
    }

    public static void main(String[] args) throws java.lang.Exception {
        //Scanner sc = new Scanner(System.in);
        //int n=sc.nextInt();
        int n = 5;
        ArrayList<Pair> a = new ArrayList<>();
//        for(int i=0;i<n;i++){
//            a.add(new Pair(sc.next().charAt(0), sc.next().charAt(0), sc.nextInt()));
//        }
        ArrayList<Pair> listTest = new ArrayList<>();
        Pair p1 = new Pair('A', 'B', 1);
        Pair p2 = new Pair('B', 'C', 4);
        Pair p3 = new Pair('B', 'D', 6);
        Pair p4 = new Pair('D', 'E', 5);
        // Pair p3 = new Pair('C', 'E', 1);
        Pair p5 = new Pair('C', 'E', 1);

        listTest.add(p1);
        listTest.add(p2);
        listTest.add(p3);
        listTest.add(p4);
        listTest.add(p5);

        ArrayList<Pair> ans = findMinimumCostToConnectServers(listTest);

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i).from + " " + ans.get(i).to + " " + ans.get(i).cost);
        }

//        ArrayList<Pair> primsRes = prims(listTest);
//        for(int i = 0; i< primsRes.size(); i++){
//            System.out.println(primsRes.get(i).from + " " + primsRes.get(i).to + " " + primsRes.get(i).cost);
//        }
        //System.out.println(primsRes);
    }
}
