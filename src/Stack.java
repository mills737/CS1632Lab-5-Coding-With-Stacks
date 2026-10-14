import java.util.LinkedList;

public class Stack<Token> {
    protected LinkedList<Token> stackData;
    public Stack() {stackData = new LinkedList<>();}
    public void push(Token tok) {
        stackData.add(tok);
    }
    public Token pop() {
        Token res = stackData.getFirst();
        stackData.remove();
        return res;
    }
    public Token peek() {return stackData.getFirst();}
    public boolean isEmpty() {return stackData.isEmpty();}
}
