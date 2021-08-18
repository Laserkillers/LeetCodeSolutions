import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FourthQuestion {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String mass = bufferedReader.readLine();
        String[] splittedmass = mass.split(" ");
        int[] arrayOne = new int[splittedmass.length];
        for (int i = 0; i < arrayOne.length; i++){
            arrayOne[i] = Integer.parseInt(splittedmass[i]);
        }
        mass = bufferedReader.readLine();
        splittedmass = mass.split(" ");
        int[] arrayTwo = new int[splittedmass.length];
        for (int i = 0; i < arrayTwo.length; i++){
            arrayTwo[i] = Integer.parseInt(splittedmass[i]);
        }
        long start = System.currentTimeMillis();
        System.out.println(findMedianSortedArrays(arrayOne, arrayTwo));
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (end - start));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int i = 0;
        int j =  0;
        int k = 0;
        while (i < nums1.length || j < nums2.length){
            if (j >= nums2.length){
                arr[k++] = nums1[i++];
            }
            else if(i >= nums1.length){
                arr[k++] = nums2[j++];
            }
            else if(nums1[i] <= nums2[j]){
                arr[k++] = nums1[i++];
            }
            else {
                arr[k++] = nums2[j++];
            }
        }
        int n = k / 2;
        if (k % 2 == 0) {
            return (double) (arr[n] + arr[n - 1])/2;
        }else {
            return arr[n];
        }
    }

    /*
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>(nums1.length + nums2.length);
        double answer = 0.0;
        for (int i = 0; i < nums1.length; i++){
            list.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++){
            list.add(nums2[i]);
        }
        Collections.sort(list);
        int middle;
        if (list.size() % 2 == 0) {
            middle = list.size() / 2;
            answer = (double) (list.get(middle) + list.get(middle - 1))/2;
        }else {
            middle = list.size() / 2;
            answer = list.get(middle);
        }
        System.out.println("Linked array: " + list);
        System.out.println("Middle: " + middle);
        return answer;
    }*/

}
