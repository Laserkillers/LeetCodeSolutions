import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class TwelveQuestion {
    private static final int MAXNUMBER = (int) Math.pow(10,4);
    private static final int ARRAYSIZE = (int) Math.pow(10,5);

    public static void main(String[] args) throws IOException {
        /*
        FileReader fileReader = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        String[] splittedLine = line.split(" ");
        int[] array = new int[splittedLine.length];
        for(int i = 0; i < array.length; i++){
            array[i] = Integer.parseInt(splittedLine[i]);
        }*/
        int[] array = createRandArray();
        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        int result = maxAreaOld(array);
        long end = System.currentTimeMillis();
        System.out.println("Максимальная площадь (мой алгоритм): " + result + " Time exceed: " + (end - start));
        start = System.currentTimeMillis();
        result = maxArea(array);
        end = System.currentTimeMillis();
        System.out.println("Максимальная площадь (более оптимизированный алгоритм): " + result + " Time exceed: " + (end - start));
    }
    // Difficulty O(n), but with run time 1ms
    public static int maxArea(int[] height){
        int maxArea = 0;
        int area = 0;
        int i = 0;
        int j = height.length - 1;
        int hmin = 0;
        while (i < j){
            hmin = height[i] < height[j] ? height[i] : height[j];
            area = hmin * (j - i);
            maxArea = area > maxArea ? area : maxArea;
            while (i < height.length && height[i] <= hmin)
                i++;
            while (j >= 0 && height[j] <= hmin)
                j--;
        }
        return maxArea;
    }

// Difficulty O(2*n), but with run time 2ms
    public static int maxAreaOld(int[] height) {
        int maxArea = 0;
        int area = 0;
        for (int i = 0, j = height.length - 1; i < j;){
            area = (j - i) * (height[i] > height[j]? height[j] : height[i]);
            if (area > maxArea)
                maxArea = area;
            if (height[i] > height[j])
                j--;
            else i++;
        }
        return maxArea;
    }
    public static int[] createRandArray(){
        Random random = new Random(System.currentTimeMillis());
        int[] array = new int[ARRAYSIZE];
        for( int i = 0; i < array.length; i++)
            array[i] = random.nextInt(MAXNUMBER) + 2;
        return array;
    }

}
