import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ThirdQuestion {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String in = bufferedReader.readLine();

        System.out.println(lengthOfLongestSubstring(in));

    }

    public static int lengthOfLongestSubstring(String s){
        Map<Character, Integer> map = new HashMap<>(); // Текущий индекс буквы последний раз встречавшийся
        int length = 0;
        for (int i = 0, j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            if (map.containsKey(c)){
                i = map.get(c) > i ? map.get(c) : i;
            }
            length = Math.max(length, j - i + 1);
            map.put(c, j + 1);
        }
        return length;
    }
}
/*int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;

 */
