import java.io.*;
public class ParenthesisTest {
    public static void main(String[] args) throws IOException {
        String file = "C:\\Users\\neera\\OneDrive\\Desktop\\CMPS 390\\data.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            System.out.println(currentLine);
            checkParenthesis(currentLine);
            System.out.println("\n");

        }
        bufferedReader.close();
    }
    static boolean checkParenthesis(String equation) {
        charStack parenStack = new charStack();
        parenStack.init();

        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);
            if (c == '(') {
                parenStack.push(c);
            } else if (c == ')') {
                if (parenStack.isItEmpty()) {
                    System.out.println("INVALID EQUATION!!");
                    return false;
                }
                parenStack.pop();
            }
        }
        if (!parenStack.isItEmpty()) {
            System.out.println("INVALID EQUATION!!");
            return false;
        }
        {
                 System.out.println("VALID EQUATION");
                    return true;
        }
    }
}