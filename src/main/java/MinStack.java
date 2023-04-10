import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MinStack {
    private Map<Integer, Integer> stack;
    private int len;

    public MinStack() {
        this.stack = new HashMap<>();
        this.len = 0;
    }

    public void push(int val) {
        this.stack.put(this.len, val);
        this.len++;
    }

    public void pop() {
        this.stack.remove(this.len - 1);
        this.len--;
    }

    public int top() {
        return this.stack.get(this.len - 1);
    }

    public int getMin() {
        return Collections.min(this.stack.values());
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(6);
        obj.push(5);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println("Top: " + param_3 + ", min: " + param_4);
    }
}
