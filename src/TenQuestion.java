import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TenQuestion {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String mass = bufferedReader.readLine();
        String[] splittedmass = mass.split(" ");
        int[] arrayOne = new int[splittedmass.length];
        for (int i = 0; i < arrayOne.length; i++){
            arrayOne[i] = Integer.parseInt(splittedmass[i]);
        }
        System.out.println(isPalindrome(arrayToListNode(arrayOne)));
    }
    public static boolean isPalindrome(ListNode head) {
        List<Integer> array = new ArrayList<Integer>();
        while (head != null){
            array.add(head.val);
            head = head.next;
        }
        for(int i = 0, j = array.size() - 1; i < (array.size() + 1) / 2; i++ , j--){
            if(!array.get(i).equals(array.get(j)))
                return false;
        }
        return true;
    }




    public static ListNode arrayToListNode(int[] array){
        if (array.length == 1)
            return new ListNode(array[0]);
        ListNode listNode = new ListNode(array[0]);
        ListNode temp = new ListNode(array[1]);
        listNode.next = temp;
        for (int i = 2; i < array.length; i++){
            temp.next = new ListNode();
            temp = temp.next;
            temp.val = array[i];
        }
        return listNode;
    }
}

