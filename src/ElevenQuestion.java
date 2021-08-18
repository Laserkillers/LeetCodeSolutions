import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ElevenQuestion{
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        String pattern = bufferedReader.readLine();
        System.out.println(isMatch(line,pattern));
        //System.out.println(isMatch(line, pattern));
    }

    static Result[][] memo;

    public static boolean isMatch(String s, String p) {
        memo = new Result[s.length() + 1][p.length() + 1];
        return find(0,0,s,p);
    }

    public static boolean find(int i, int j, String text, String pattern){
        if(memo[i][j] != null)
            return memo[i][j] == Result.TRUE;
        boolean ans;
        if(j == pattern.length()){
            ans = i == text.length();
        }
        else{
            boolean first_match = ( (i < text.length()) && (text.charAt(i) == pattern.charAt(j) ||
                    pattern.charAt(j) == '.'));
            if ( j + 1 < pattern.length() && pattern.charAt(j + 1) == '*'){
                ans = find(i ,j+2, text, pattern) || first_match && find(i+1, j, text, pattern);
            }else {
                ans = first_match && find(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
    enum Result {
        TRUE, FALSE
    }
}


