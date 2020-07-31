package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseScheduleTopolDFS {
    // DFS
    // DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length <1) return true;
        // Key - course, Value - list of all the courses that depend on the key course
        HashMap<Integer, List<Integer>> graph = buildMap(numCourses, prerequisites);
        boolean[] seen = new boolean[graph.size()];
        for(Map.Entry<Integer,List<Integer>> e: graph.entrySet()){
            int course = e.getKey();

            if(dfs(course, graph, seen) == false){
                return false;
            }
            // List<Integer> list = e.getValue();
            //return true;
        }

        // perform DFS and see it it has a cycle
        return true;
    }
    // false means it has a cycle
    public boolean dfs(int course, HashMap<Integer, List<Integer>> graph, boolean[] seen){
        // check if course is seen
        if(seen[course]) return false;
        seen[course] = true;

        boolean canFinish = true;
        List<Integer> adj = graph.getOrDefault(course, new LinkedList<Integer>());
        for(int i = 0; i< adj.size(); i++){
            int cur = adj.get(i);
            // if already seen - circular
            if(!dfs( cur, graph, seen)){
                return false;
            }
        }
        seen[course]  = false;
        return canFinish;
    }


    public HashMap<Integer, List<Integer>> buildMap(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        // numCourses courses you have to take, labeled from 0 to numCourses-1.(sequencial)
        // Key - course, Value - list of all the courses that depend on the key course
        for (int i = 0; i < numCourses; i++) {
            // in case if no other courses depend on this course
            map.put(i, new LinkedList<>());
        }
        for(int[] arr: prerequisites){
            //Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
            int courseX = arr[1];
            int courseThatDependsOnX = arr[0];
            // get courses that depend on courseX
            List<Integer> list = map.getOrDefault(courseX, new LinkedList<Integer>());
            list.add(courseThatDependsOnX);
            map.put(courseX, list);
        }

        return map;
    }


    public static void main(String[] args){
        CourseScheduleTopolDFS mySched = new CourseScheduleTopolDFS();
       // mySched.buildMap(3, new int[][]{{1,0},{2,0},{0,2}});
        System.out.println("expected false: " + mySched.canFinish(3, new int[][]{{1,0},{2,0},{0,2}}));
        System.out.println("expected true: " + mySched.canFinish(3, new int[][]{{0,1},{0,2},{1,2}}));
        System.out.println("expected true: " + mySched.canFinish(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}));


    }
}
