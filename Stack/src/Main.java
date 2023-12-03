import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        String file = "C:\\Users\\neera\\OneDrive\\Desktop\\CMPS 390\\data.txt";
        BufferedReader bufferedReader = new BufferedReader(new

                FileReader(file));
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            System.out.println(currentLine);
            System.out.println(evaluate(currentLine) + "\n");
        }
        bufferedReader.close();
    }
    static public int evaluate(String equation) {
        ParenthesisTest pTest = new ParenthesisTest();
        InfixToPostfixConverter iTp= new InfixToPostfixConverter();
        String postFix;
        PostFixEvaluation pFix = new PostFixEvaluation ();
        int evaluate = 0;
        if (pTest.checkParenthesis(equation)) {
            postFix = iTp.iTp(equation);
            System.out.print("Value: ");
            evaluate = pFix.postFixEvaluation(postFix);

        } else {

        }
        return evaluate;

    }

}