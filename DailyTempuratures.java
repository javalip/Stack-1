import java.util.Stack;

public class DailyTempuratures {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[] {};
        }
        /**
         when current index solves the problem for
         immediate smaller index first and doesnt solve intermediate values, but solves the value before that. and until it gets solved we have to put them in a storage place

         */

        // LIFO DS is eeded. Monotonic stack.
        // temperatures top to bottom increase. indices bottom to top increase
        /***
         Time complexity - o(n)
         space complexity - o (n)
         * stack will be of Integer type in which we will add indices of temperature.
         * we will start iterating through elements and add elemnts until discoer
         * highter
         * temperature than the previous one.
         * once we find temperature that is greater than the previous, we will pop the
         * temp and calculate
         * the differance of temperatures if indices. and add to the resultant array.
         * we will do this if stack is not empty. We will do this until we
         * iterate through the entre array of temperatures.
         */
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int popped = stack.pop();
                result[popped] = i - popped;
            }
            stack.push(i);
        }
        return result;
    }
}
