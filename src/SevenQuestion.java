import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SevenQuestion {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int x = Integer.parseInt(bufferedReader.readLine());
        System.out.println(reverse(x));
    }
    public static int reverse(int x){
        int reversenum = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (reversenum > Integer.MAX_VALUE/10 || (reversenum == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (reversenum < Integer.MIN_VALUE/10 || (reversenum == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            reversenum = reversenum * 10 + pop;
        }
        return reversenum;
    }
}
