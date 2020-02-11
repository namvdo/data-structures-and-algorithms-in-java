import java.util.Stack;
public class HTMLTagsMatched {
    public static boolean isHTMLMatched(String html){
        Stack <String> buffer = new Stack<>();
        int i = html.indexOf('<'); // if there is opening tag
        while(i != -1){ 
            int j = html.indexOf('>', i + 1); // search for '>' from the index i + 1 till the end
            if(j == -1){
                return false; // returns false if cannot find one
            }
            String tag = html.substring(i + 1, j); // get the substring ex <html> this will be html
            if(!tag.startsWith("/")){ // if it doesn't start with a closing sign tag
                buffer.push(tag); // pushes it into the stack
            }else{
                if(buffer.size() == 0) return false; // no tag to match
                if(!tag.substring(1).equals(buffer.pop())){ // mismatch tag
                    return false;
                }
            }
            i = html.indexOf('<', j + 1); // finds the next '<' (if any)
        }
        return buffer.empty(); 
    }
}