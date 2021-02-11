import java.util.Stack;

public class App {
    public static int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();

        for (String dir : logs) {
            if (dir.equals("./")) {
                continue;
            } else if (dir.equals("../")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(dir);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) throws Exception {
        String[] logs = { "./", "../", "./" };
        System.out.println(minOperations(logs));
    }
}