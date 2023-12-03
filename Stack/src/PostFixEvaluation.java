import java.io.*;
public class PostFixEvaluation {
    public static void main(String[] args) throws IOException {
        String file = "C:\\Users\\neera\\OneDrive\\Desktop\\CMPS 390\\data.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            System.out.println(currentLine);
            System.out.println(postFixEvaluation(currentLine) + "\n");
        }
        bufferedReader.close();
    }
    static int postFixEvaluation(String equation) {
        intStack solve = new intStack();
        char ch;
        int i, x, y, z, num;
        solve.init();
        for (i = 0; i < equation.length(); i++) {
            ch = equation.charAt(i);
            if ((ch >= '0') && (ch <= '9')) {
                num = Character.getNumericValue(ch);
                solve.push(num);
            } else if (ch == '+') {
                y = solve.pop();
                x = solve.pop();
                z = x + y;
                solve.push(z);
            } else if (ch == '-') {
                y = solve.pop();
                x = solve.pop();
                z = x - y;
                solve.push(z);
            } else if (ch == '*') {
                y = solve.pop();
                x = solve.pop();
                z = x * y;
                solve.push(z);
            } else if (ch == '/') {
                y = solve.pop();
                x = solve.pop();
                z = x / y;
                solve.push(z);
            }
        }
        return solve.pop();
    }
}
