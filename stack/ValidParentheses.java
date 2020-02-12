package stack;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isMatched (String expression){
        final String opening = "[{(";
        final String closing = "]})";
        Stack <Character> buffer = new Stack<>();
        for(char c : expression.toCharArray()){
            if(opening.indexOf(c) != -1){
                buffer.push(c);
            }else if(closing.indexOf(c) != -1){
                if(buffer.empty()){
                    return false;
                }if(closing.indexOf(c) != opening.indexOf(buffer.pop())){
                    return false;
                }
            }
        }
        return buffer.size() == 0;
    }
}