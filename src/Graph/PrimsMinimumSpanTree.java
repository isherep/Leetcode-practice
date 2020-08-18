package Graph;

import java.util.ArrayList;
import java.util.Comparator;
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

        while (h.size() > 0) {
            // Pair ele = extractMin(list);
            Pair cur = h.poll(); //[from-A,to-B,1]

            // find the current's parent
            Node parentFrom = findParent(node[cur.from - 'A'], new ArrayList<>());
            // find the current's child. It will be one since assumption in the description
            Node parentTo = findParent(node[cur.to - 'A'], new ArrayList<>());
            // check for the cycle
            if (parentFrom != parentTo) {
                parentTo.parent = parentFrom;
                res.add(new Pair(cur.from, cur.to, cur.cost));
            }
        }
        System.out.println("Finished findmintree");
        return res;
    }

    public static Node findParent(Node node, ArrayList<Node> path) {
        if (node.parent == node) {
            for (int i = 0; i < path.size(); i++) {
                path.get(i).parent = node;
            }
            return node;
        }
        path.add(node);
        return findParent(node.parent, path);
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
    }
}
