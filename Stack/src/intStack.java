import java.util.EmptyStackException;
public class intStack {
    int top;
    int stack[] = new int[50];
    void init() {
        top = -1;
    }
    void push(int c) {
        top++;
        stack[top] = c;
    }
    int pop() {
        int c = stack[top];
        top--;
        return c;
    }
    boolean isItEmpty() {
        return top < 0;
    }
    void showstack() {
        int i;
        for (i = 0; i <= top; i++) {
            System.out.println(stack[i]);
        }
    }
    public int getTop() {
        if (isItEmpty()) {
            throw new EmptyStackException(); // or handle the empty stack case appropriately
        }
        return stack[top];
    }
}
