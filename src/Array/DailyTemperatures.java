package Array;

import java.util.Stack;

public class DailyTemperatures {
    /*
   Enter every index into the stack

   Pop indexes when current temperature is larger that temperature at the top index in the stak
   Pop untill you get to the  first index that is larger
   */
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            // System.out.println(T[i] + ", " + T[stack.peek()]);
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                System.out.println("i " + i + ", " + T[i] + ", " + T[stack.peek()]);
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
