import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NineQuestion {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int num = Integer.parseInt(bufferedReader.readLine());
        System.out.println(isPalindrome(num));
    }

    public static boolean isPalindrome(int x){
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int number = 0;
        int temp = x;

        while (temp > number){
            number = number * 10 + (temp % 10);
            temp /= 10;
        }
        return number == temp || number / 10 == temp;

    }

    /*
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x == 0)
            return true;
        int temp = x;
        int number = 0;
        while (temp > 0){
            number = number * 10 + (temp % 10);
            temp /= 10;
        }
        return number == x;
    }*/
}
