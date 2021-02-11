import java.util.Stack;

public class App {
    public static String minRemoveToMakeValid(String s) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // Copy the chars into String Builder and Pushing the parentheses in to Stack.
        for (int i = 0; i < s.length(); i++) {

            sb.append(s.charAt(i));

            if (s.charAt(i) == '(') {
                stack.push(i); // Push the valid index value if Open Parentheses
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    stack.push(-1); // Push the -1 value if Close Parentheses
                } else if (stack.peek() > -1) {
                    stack.pop(); // Pop the Open parentheses for one of close Parentheses
                } else {
                    stack.push(-1); // If peek is not Open, then push the -1 again
                }
            }
        }

        // Find Count of Open and Close parentheses
        int closeCount = 0;

        while (!stack.isEmpty()) {
            if (stack.peek() > -1) {
                sb.deleteCharAt(stack.peek()); // Delete the Extra Open Parentheses by saved Index value
            } else if (stack.peek() == -1) {
                closeCount++; // Find the count of extra Close parentheses
            }
            stack.pop();
        }

        // Remove the Close parentheses from String Builder which is occurred
        if (closeCount == 0) {
            return sb.toString();
        } else {

            int length = sb.length();
            for (int i = 0; i < length; i++) {
                if (sb.charAt(i) == ')') {
                    sb.deleteCharAt(i);
                    closeCount--;
                    length--;
                    i = i - 1;
                }

                if (closeCount == 0) {
                    break;
                }
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println((minRemoveToMakeValid("))((")));
    }
}
