package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Pair{
    char from, to;
    int cost;
    Pair(char from, char to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

class Node{
    int data;
    Node parent;
    Node(int data){
        this.data = data;
        this.parent = this;
    }
}

public class PrimsMinimumSpanTree {



    public static ArrayList<Pair> findMinimumCostToConnectServers(ArrayList<Pair> heap){
        PriorityQueue<Pair> h = new PriorityQueue<>(heap);
        ArrayList<Pair> res = new ArrayList<>();

        //formHeap(heap);

        Node node[] = new Node[26];
        for(int i=0;i<26;i++){
            node[i] = new Node(i);
        }

        while(h.size() > 0){
           // Pair ele = extractMin(heap);
            Pair ele = h.poll();

            Node parentFrom = findParent(node[ele.from - 'A'], new ArrayList<> ());
            Node parentTo = findParent(node[ele.to - 'A'], new ArrayList<> ());

            if(parentFrom != parentTo){
                parentTo.parent = parentFrom;
                res.add(new Pair(ele.from, ele.to, ele.cost));
            }
        }
        return res;
    }

    public static Node findParent(Node node, ArrayList<Node> path){
        if(node.parent == node){
            for(int i=0;i<path.size();i++){
                path.get(i).parent = node;
            }
            return node;
        }
        path.add(node);
        return findParent(node.parent, path);
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Pair> a = new ArrayList<> ();
        for(int i=0;i<n;i++){
            a.add(new Pair(sc.next().charAt(0), sc.next().charAt(0), sc.nextInt()));
        }
        ArrayList<Pair> ans = findMinimumCostToConnectServers(a);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i).from+" "+ans.get(i).to+" "+ans.get(i).cost);
        }
    }
}
