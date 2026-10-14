import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static Boolean endsSequence(Token tok) {
        if (tok == null) return true;
        if (tok instanceof OpToken) {
            if (((OpToken) tok).getOperator() == ';') return true;
            if (((OpToken) tok).getOperator() == '.') return true;
        }
        return false;
    }
    private static ArrayList<Token> getNextSequence(Tokenizer toknizr) throws IOException {
        ArrayList<Token> tokens = new ArrayList<>();
        Token tok;
        do {
            tok = toknizr.nextToken();
            if (tok != null) tokens.add(tok);
        } while (!endsSequence(tok));
        if (tok == null) return null;
        if (tok instanceof OpToken) {
            if (((OpToken) tok).getOperator() == '.') {
                return null;
            }
        }
        return tokens;
    }

    public static void main(String[] args) {
        try {
            Tokenizer myScanner = new Tokenizer(System.in);
            ArrayList<Token> tokenSequence;
            ArrayList<Token> postfixSequence = null;
            do {
                System.out.print("Equation: ");
                tokenSequence = getNextSequence(myScanner);
                if (tokenSequence != null) {
                    // Replace the code starting here with code to evaluate the expression
                    System.out.print("Result: ");
                    Stack<Integer> valStack = new Stack<>();
                    for(int i = tokenSequence.size() - 1; i >= 0; i--) {
                        Token tok = tokenSequence.get(i);
                        String value = tok.getTokenString();

                        if(value.matches("\\d+")){
                            valStack.push(Integer.parseInt(value));
                        }
                        else if (value.equals("*")) {
                            int right = valStack.pop();
                            int left = valStack.pop();
                            valStack.push(left * right);
                        }
                        else if (value.equals("+")) {
                            int right = valStack.pop();
                            int left = valStack.pop();
                            valStack.push(left + right);
                        }
                        else if  (value.equals("/")) {
                            int right = valStack.pop();
                            int left = valStack.pop();
                            valStack.push(left / right);
                        }
                        else if (value.equals("-")) {
                            int right = valStack.pop();
                            int left = valStack.pop();
                            valStack.push(left - right);
                        }
                    }
                    int result = valStack.pop();
                    System.out.println(result);
                    // End where to replace
                }
            } while (tokenSequence != null);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}