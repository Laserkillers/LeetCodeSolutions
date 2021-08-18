import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SixQuestion {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string = bufferedReader.readLine();
        int numberOfRows = Integer.parseInt(bufferedReader.readLine());
        System.out.println(convert(string, numberOfRows));
    }
    public static String convert(String s, int numbRows){
        if (numbRows == 1)
            return s;

        StringBuilder answer = new StringBuilder();
        int stringSize = s.length();
        int cycleLen = 2 * numbRows - 2;
        for(int i = 0; i < numbRows; i++){
            for (int j = 0; j + i < stringSize; j+= cycleLen){
                answer.append(s.charAt(j+i));
                if(i != 0 && i != numbRows - 1 && j + cycleLen - i < stringSize){
                    answer.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return answer.toString();
    }
}
