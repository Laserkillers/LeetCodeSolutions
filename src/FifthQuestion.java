import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FifthQuestion {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string = bufferedReader.readLine();
        System.out.println(longestPalindrome(string));
    }
    //O(n^2) - difficulty; memory O(n)
    public static String longestPalindrome(String s) {
        if(s.length() < 2) return s;

        int[] substring = {0,0};

        for(int i = 0, len = s.length(); i != len; ++i)
            i = manacher(s, i, substring);

        return s.substring(substring[0], substring[0] + substring[1]);
    }
    private static int manacher(String s, int i, int[] sub) {
        int len = s.length();
        int j = i--;
        //данный цикл ищет палидром из одинаковых букв
        while((j != len - 1) && (s.charAt(j) == s.charAt(j + 1)))
            ++j;

        int next = j++;

        while((i != -1) && (j != len) && (s.charAt(i) == s.charAt(j)) ) {
            --i;
            ++j;
        }
        if((j - i - 1) > sub[1]) {
            sub[1] = j - i - 1;
            sub[0] = i + 1;
        }
        return next;
    }

/* O(n^2) - difficulty; memory O(1)
    public static String longestPalindrome(String s) {
        if (s.equals("")|| s == null)
            return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++){
            int len1 = goAround(s, i, i);
            int len2 = goAround(s, i,i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    public static int goAround(String s, int left, int right){
        while ((left >= 0) && (right < s.length()) && (s.charAt(left) == s.charAt(right))){
            left--;
            right++;
        }
        return right - left - 1;
    }*/
}

