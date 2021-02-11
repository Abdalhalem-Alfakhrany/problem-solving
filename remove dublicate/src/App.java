import java.util.Stack;

public class App {

    public static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char lastElement = ' ';
            if (stack.size() >= 1) {
                lastElement = stack.lastElement();
            }
            if (S.charAt(i) == lastElement) {
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }
        String ret = "";
        for (Character character : stack) {
            ret += character;
        }
        return ret;
    }

    public static String removeDuplicates(String s, int k) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (Last_K_ElemntEquals(k, stack)) {
                for (int j = 0; j < k; j++) {
                    stack.pop();
                }
                stack.push(s.charAt(i));
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (Last_K_ElemntEquals(k, stack)) {
            for (int j = 0; j < k; j++) {
                stack.pop();
            }
        }

        String ret = "";
        for (Character character : stack) {
            ret += character;
        }

        return ret;

    }

    static boolean Last_K_ElemntEquals(int k, Stack<Character> stack) {

        boolean ret = true;

        if (stack.size() < k)
            return false;

        char lastElement = ' ';

        try {
            lastElement = stack.lastElement();
        } catch (Exception e) {
        }

        while (k > 0) {
            if (lastElement == stack.get(stack.size() - k)) {
                k--;
            } else {
                ret = false;
            }
            if (!ret)
                break;
        }

        return ret;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4));
    }
}