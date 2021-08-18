import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EightQuestion {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String x = bufferedReader.readLine();
        System.out.println(myAtoi(x));
    }
    public static int myAtoi(String s) {
        boolean sign = false;
        s = s.trim();
        if (s.isEmpty())
            return 0;
        int index = 0;
        if(s.charAt(index) == '-'){
            sign = true;
            index++;
        }else if(s.charAt(index) == '+'){
            index++;
        }
        long number = 0;
        while (index < s.length()){
            if(Character.isDigit(s.charAt(index))){
                number = number * 10 + (s.charAt(index) - '0');
            }else break;

            if (number > Integer.MAX_VALUE)
                return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            index++;
        }
        return sign ? (int) -number : (int) number;
    }
    /* Non optimal algoritm
    public static int myAtoi(String s) {
        StringBuilder line = new StringBuilder(s.trim());
        boolean sign = false;
        if( (line.length() == 0) || ( ((line.charAt(0) == '-')||(line.charAt(0) == '+')) && (line.length() == 1) ))
            return 0;
        if(line.charAt(0) == '-'){
            sign = true;
            line.deleteCharAt(0);
        }
        else if(line.charAt(0) == '+')
            line.deleteCharAt(0);
        if(!line.substring(0,1).matches("[0-9]"))
            return 0;
        int numbspace = 0;
        for (int i = 0; i < line.length(); i++){
            if(!line.substring(i,i+1).matches("[0-9]"))
                break;
            numbspace++;
        }
        long test;
        try {
            test = Long.parseLong(line.substring(0,numbspace));
        }
        catch (Exception e){
            if (sign)
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }
        if(sign)
            test *= -1;
        if(test > Integer.MAX_VALUE - 1)
            return Integer.MAX_VALUE;
        if(test < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)test;
    }*/
}
