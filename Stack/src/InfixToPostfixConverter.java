import java.io.*;
public class InfixToPostfixConverter {
    public static void main(String[] args) throws IOException {
        String file = "C:\\Users\\neera\\OneDrive\\Desktop\\CMPS 390\\data.txt";
        BufferedReader bufferedReader = new BufferedReader(new

                FileReader(file));
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            iTp(currentLine);
            System.out.println("\n");
        }
        bufferedReader.close();
    }
    static String iTp(String equation) {
        String postFix = " ";
        charStack post = new charStack();
        charStack opStack = new charStack();
        charStack revPostFix = new charStack();
        char myOp, ch;
        int i;
        for (i = 0; i < equation.length(); i++) {
            ch = equation.charAt(i);
            if (ch >= '0' && ch <= '9') {
                post.push(ch);
            }
            if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                opStack.push(ch);
            } else if (ch == ')') {
                if (opStack.isItEmpty() == false) {
                    myOp = opStack.pop();

                    post.push(myOp);
                }
            }
        }
        while (opStack.isItEmpty() == false) {
            myOp = opStack.pop();
            post.push(myOp);
        }
        while (!post.isItEmpty()) {
            revPostFix.push(post.pop());
        }
        System.out.print("POSTFIX: ");
        while (revPostFix.isItEmpty() == false) {
            postFix = postFix + revPostFix.getTop();
            System.out.print(revPostFix.pop());
        }
        System.out.print("\n");
        return postFix;
    }
}