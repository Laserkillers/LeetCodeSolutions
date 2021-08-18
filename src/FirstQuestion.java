import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstQuestion {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String mass = bufferedReader.readLine();
        String[] splittedmass = mass.split(" ");
        int[] arrayOfNumbs = new int[splittedmass.length];
        for (int i = 0; i < arrayOfNumbs.length; i++){
            arrayOfNumbs[i] = Integer.parseInt(splittedmass[i]);
        }
        int target = Integer.parseInt(bufferedReader.readLine());
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(twoSum(arrayOfNumbs, target)));
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (end - start));
    }
    /*
    public static int[] twoSum(int[] nums, int target){
        int temp;
        int[] answ = new int[2];
        for (int i = 0; i < nums.length; i++){
            temp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++){
                if (temp == nums[j]) {
                    answ[0] = i;
                    answ[1] = j;
                    return answ;
                }
            }
        }
        return null;
    }
    Difficult O(n*log(n))
    */
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return null;
    }//difficult O(n)
}
