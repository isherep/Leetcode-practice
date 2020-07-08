package BFS;

import java.util.*;

public class CourseSchedule207 {
    // 36 ms
    public class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (numCourses <= 0)
                return false;
            // a queueu to process vertices- course numbers
            Queue<Integer> queue = new LinkedList<>();
            // hashtable to record how many dependencies each course has
            int[] inDegree = new int[numCourses];
            // filling up the number of indegrees for courses
            for (int i = 0; i < prerequisites.length; i++) {
                // prerequisites[i][1] shows the corse dependency
                // like [0,1] course 0 is dependent on course 1
                //        now course 1 will have 1 indegree dependency
                //      [0,3] course 0 is dependent on course 3
                //      now course 3 will have 1 indegree dependency
                //
                inDegree[prerequisites[i][1]]++;
            }
            // starting with the courses that have no indegrees
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0)
                    queue.offer(i);
            }
            // the first courses in the queue will be the ones with no inDegrees 0.
            while (!queue.isEmpty()) {
                int x = queue.poll();
                for (int i = 0; i < prerequisites.length; i++) {
                    // go over each prerequisite and find the course
                    // find the course to which the currect course is the prerequisite
                    // and decrement indegree count of that course
                    if (x == prerequisites[i][0]) {
                        // decrement by one because we took one of those prerequisite courses
                        inDegree[prerequisites[i][1]]--;

                        // if some course in the queueu also has indegree of 0 - add to the queueu
                        if (inDegree[prerequisites[i][1]] == 0)
                            queue.offer(prerequisites[i][1]);
                    }
//             if (inDegree[prerequisites[i][1]] == 0)
// 					queue.offer(prerequisites[i][1]);

                }
            }
            // if after processing some course left - it means it is ciclic
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] != 0)
                    return false;
            }
            return true;
        }
    }

    // ************BETTER ***** GRAPH AS HASHMAP*************/

    // HashMap implementatio - faster
    public boolean canFinishMap(int numCourses, int[][] prerequisites) {
        // Key - course, Value - list of all the courses that depend on the key course
        HashMap<Integer, List<Integer>> map = buildMap(numCourses, prerequisites);
        int[] inDegree = getInDegreeArray(numCourses, prerequisites);
        // find all the courses that have no dependencies/prerequisites to them
        // and add them to the queueu.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        int count = 0;

        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            count++;
            for (int neighboor : map.get(currCourse)) {
                // now degrement indegree since we took a course
                inDegree[neighboor]--;
                if (inDegree[neighboor] == 0) {
                    queue.offer(neighboor);
                }
            }
        }
        return count == numCourses;
    }

    public int[] getInDegreeArray(int numCourses, int[][] prerequisites) {
        // indegree is how many prerequisite courses does that course have
        int[] inDegree = new int[numCourses];
        for (int[] arr : prerequisites) {
            int course = arr[0];
            // increment course indegrees
            inDegree[course]++;
        }

        return inDegree;
    }
    // Course is the key and values are all the courses that depend on that course
    // for each of those neighboor courses - decrement their indegree. because we took
    // one prerequisite course.
    // Every time we take a course - increment counter by one.

    public HashMap<Integer, List<Integer>> buildMap(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        // courses are sequencial:
        // numCourses courses you have to take, labeled from 0 to numCourses-1.
        // Key - course, Value - list of all the courses that depend on the key course
        // ! there could be a course that exists that can have no courses
        // dependent on it, so it's better to first fill the map with
        // and empty arraylists in values to prevent null pointer exception

        // There could be a list that was never initialized for the course
        // and we will get null pointer exeption
        // Keys - list of courses that depend on that course
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new LinkedList<>());
        }
        //  for example to take course 0 you have to first take course 1,
        //  which is expressed as a pair: [0,1] - [1] is prereq to [0]
        for (int[] arr : prerequisites) {
            int courseThatDependsOnX = arr[0];
            int courseX = arr[1];
            //  for example to take course 0 you have to first take
            //  course 1, which is expressed as a pair: [0,1]
            //
            // get courses that depend on courseX
            List<Integer> list = map.get(courseX);
            list.add(courseThatDependsOnX);
            map.put(courseX, list);
        }
        for (int[] pair : prerequisites) {
            // to take course 0 you have to first take course 1,
            // which is expressed as a pair: [0,1]
            // [0,1],[0,3]
            // course - other course that depends on it.
            if (map.containsKey(pair[0])) {
                // add to the dependent couses list
                map.get(pair[0]).add(pair[1]);
            } else {
                LinkedList<Integer> dependents = new LinkedList<>();
                dependents.add(pair[1]);
                map.put(pair[0], dependents);
            }
        }
        return map;
    }
}
