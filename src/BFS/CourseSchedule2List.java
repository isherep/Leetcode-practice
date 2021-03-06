package BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * <p>
 * Example 2:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should
 * also have finished course 1. So it is impossible.
 */
public class CourseSchedule2List {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //if(prerequisites.length <1) return true;
        int[] res = new int[numCourses];
        // Key - course, Value - list of all the courses that depend on the key course
        HashMap<Integer, List<Integer>> map = buildMap(numCourses, prerequisites);
        int[] inDegree = getInDegreeArray(numCourses, prerequisites);
        // find all the courses that have no dependencies/prerequisites to them
        // and add them to the queueu.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
            //break;
        }
        int count = 0;
        int i = 0;
        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            count++;
            res[i] = currCourse;
            i++;
            for (int neighboor : map.get(currCourse)) {
                // now degrement indegree since we took a course
                inDegree[neighboor]--;
                if (inDegree[neighboor] == 0) {
                    queue.offer(neighboor);
                }
            }
        }

        if (count != numCourses) {
            System.out.println(count);
            return new int[]{};
        } else {
            return res;
        }
        //return count == numCourses;
    }


    public int[] getInDegreeArray(int numCourses, int[][] prerequisites) {
        // indegree is how many prerequisite courses does that course have
        int[] inDegree = new int[numCourses];
        for (int[] arr : prerequisites) {
            int course = arr[0];
            // increment course indegrees
            inDegree[course] += 1;
        }

        return inDegree;
    }
// Course is the key and values are all the courses that depend on that course
    // for each of those neighboor courses - decrement their indegree. because we took
    // one prerequisite course.
    // Every time we take a course - increment counter by one.

    public HashMap<Integer, List<Integer>> buildMap(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        // numCourses courses you have to take, labeled from 0 to numCourses-1.(sequencial)
        // Key - course, Value - list of all the courses that depend on the key course
        for (int i = 0; i < numCourses; i++) {
            // in case if no other courses depend on this course
            map.put(i, new LinkedList<>());
        }
        for (int[] arr : prerequisites) {
            int courseX = arr[1];
            int courseThatDependsOnX = arr[0];
            // get courses that depend on courseX
            List<Integer> list = map.getOrDefault(courseX, new LinkedList<Integer>());
            // if(list == null) {
            //     LinkedList list = new LinkedList<>();
            // }

            list.add(courseThatDependsOnX);
            map.put(courseX, list);
        }

        return map;
    }
}
