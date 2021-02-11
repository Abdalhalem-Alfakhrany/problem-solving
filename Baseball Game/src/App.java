import java.util.Stack;

public class App {
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            int last = stack.size() - 1;
            if (op.equals("+")) {
                stack.push(stack.get(last) + stack.get(last - 1));
            } else if (op.equals("D")) {
                stack.push(stack.get(last) * 2);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for (Integer integer : stack) {
            sum += integer;
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        String[] ops = { "5", "2", "C", "D", "+" };
        System.out.println(calPoints(ops));
    }
}
